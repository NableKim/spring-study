package seungsoo.itemservice.domain;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

/**
 * 상품 정보를 저장할 Repository
 */
@Repository
public class MemoryItemRepository implements ItemRepository {

    private static Map<Long, Item> store = new HashMap<>();   // 회원 정보를 저장할 메모리
    private static long sequence = 0L;                          // Item Id를 순차적으로 부여하기 위함

    /**
     * 상품 정보를 HashMap에 저장하는 메소드
     */
    @Override
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    /**
     * 하나의 상품 정보를 HashMap에서 조회하는 메소드
     */
    @Override
    public Item findById(Long id) {
        return store.get(id);
    }

    /**
     * HashMap에 저장된 모든 상품 정보를 List로 조회하는 메소드
     */
    @Override
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * 특정 상품의 정보를 수정하는 메소드
     */
    @Override
    public void update(Long id, Item item) {
        Item findItem = store.get(id);
        findItem.setItemName(item.getItemName());
        findItem.setPrice(item.getPrice());
        findItem.setQuantity(item.getQuantity());
    }

    /**
     * HashMap에 들어있는 정보를 모두 삭제하는 메소드
     */
    @Override
    public void clearStore() {
        store.clear();
    }
}
