package com.gildedrose.update_item_strategy;

import com.gildedrose.Item;

public interface ItemUpdateStrategy {
    void updateSellIn(Item item);

    void decreaseSellIn(Item item);

    void updateQuality(Item item);

    void increaseQuality(Item item);

    void decreaseQuality(Item item);


    default boolean isItemExpired(Item item) {
        return item.sellIn < 0;
    }


}
