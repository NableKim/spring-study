package seungsoo.itemservice.web.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    /**
     * 특정 Item의 정보를 보여줄 요청 처리
     */
    @GetMapping("/basic/items/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item findItem = itemRepository.findById(itemId);
        model.addAttribute("item", findItem);
        return "basic/item";
    }

    /**
     * Item을 새로 등록하기 위한 등록폼 요청 처리
     */
    @GetMapping("/basic/items/add")
    public String getAddForm() {
        return "basic/addForm";
    }
    
    /**
     * Item을 새로 등록 요청 처리
     * 요청 처리 후 basic/item/{itemId}로 리다이렉트
     */
    @PostMapping("/basic/items/add")
    public String save(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }


    /**
     * 특정 Item 정보 수정 페이지 요청
     */
    @GetMapping("/basic/items/{itemId}/edit")
    public String getEditForm(@PathVariable Long itemId, Model model) {
        Item findItem = itemRepository.findById(itemId);
        model.addAttribute("item", findItem);
        return "basic/editForm";
    }

    /**
     * 특정 Item 정보 수정 요청
     * 요청 처리 후 basic/item/{itemId}로 리다이렉트
     */
    @PostMapping("/basic/items/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }
}
