package seungsoo.itemservice.domain;

import java.util.List;

public interface ItemRepository {
    Item save(Item item);
    Item findById(Long id);
    List<Item> findAll();
    void update(Long id, Item item);
    void clearStore();
}
