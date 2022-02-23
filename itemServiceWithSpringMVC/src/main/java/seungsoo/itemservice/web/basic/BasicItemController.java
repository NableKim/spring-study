package seungsoo.itemservice.web.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import seungsoo.itemservice.domain.Item;
import seungsoo.itemservice.domain.ItemRepository;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;
    
    // @Autowired 파라미터 있는 생성자가 자동으로 생성되어 DI가 이뤄짐

    /**
     * 모든 상품 정보를 보여줄 요청 처리
     * Thymeleaf로 basic/items.html를 Rendering
     */
    @GetMapping("/basic/items")
    public String showAllItems(Model model) {

        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);

        // thymeleaf로 생성할 동적 html 경로 반환
        return "basic/items";
    }

    /**
     * Memory에 저장되는 Repository에 기본값으로 아래 두 데이터를 저장
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 30000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

    @GetMapping("basic/items/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item findItem = itemRepository.findById(itemId);
        model.addAttribute("item", findItem);
        return "basic/item";
    }

}
