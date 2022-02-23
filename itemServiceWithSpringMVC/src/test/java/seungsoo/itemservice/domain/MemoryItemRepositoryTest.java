package seungsoo.itemservice.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryItemRepositoryTest {

    private MemoryItemRepository memoryItemRepository = new MemoryItemRepository();

    /**
     * 테스트 후 매번 Memory에 저장된 상품 정보 삭제
     */
    @AfterEach
    void clear() {
        memoryItemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("Item1", 10000, 30);

        // when
        Item saveItem = memoryItemRepository.save(item);
        Item findItem = memoryItemRepository.findById(saveItem.getId());

        // then
        Assertions.assertThat(saveItem).isEqualTo(findItem);
    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("Item1", 10000, 30);
        Item item2 = new Item("Item2", 30000, 20);

        memoryItemRepository.save(item1);
        memoryItemRepository.save(item2);

        // when
        List<Item> allItems = memoryItemRepository.findAll();

        // then
        Assertions.assertThat(allItems.size()).isEqualTo(2);
        Assertions.assertThat(allItems).contains(item1, item2);
    }

    @Test
    void update() {

        // given
        Item item = new Item("ItemA", 10000, 30);
        Item saveItem = memoryItemRepository.save(item);
        Item updateItem = new Item("ItemB", 30000, 10);

        // when
        memoryItemRepository.update(saveItem.getId(), updateItem);

        // then
        Assertions.assertThat(saveItem.getItemName()).isEqualTo(updateItem.getItemName());
        Assertions.assertThat(saveItem.getPrice()).isEqualTo(updateItem.getPrice());
        Assertions.assertThat(saveItem.getQuantity()).isEqualTo(updateItem.getQuantity());
    }
}