package com.gildedrose.update_item_strategy;

import com.gildedrose.Item;

public class AgedBrieUpdateStrategy implements ItemUpdateStrategy {
    private final Item item;

    public AgedBrieUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    public void updateQuality() {
        increaseQuality();
    }

    @Override
    public void update() {
        updateQuality();
        if (isItemExpired(item.sellIn))
            updateQuality();
        updateSellIn();
    }

    @Override
    public Item getItem() {
        return item;
    }
}
