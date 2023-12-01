package com.gildedrose.update_item_strategy;

import com.gildedrose.Item;

public interface ItemUpdateStrategy {
    void updateSellIn();

    void updateQuality();

    void update();

    default void decreaseSellIn() {
        getItem().sellIn--;
    }

    default void increaseQuality() {
        if (getItem().quality < 50)
            getItem().quality++;
    }

    default void decreaseQuality() {
        if (getItem().quality > 0)
            getItem().quality--;
    }

    Item getItem();

    default boolean isItemExpired(int numberOfDays) {
        return numberOfDays <= 0;
    }


}
