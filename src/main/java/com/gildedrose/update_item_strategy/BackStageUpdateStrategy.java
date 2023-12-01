package com.gildedrose.update_item_strategy;

import com.gildedrose.Item;

public class BackStageUpdateStrategy implements ItemUpdateStrategy {
    private final Item item;

    public BackStageUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        if (item.sellIn < 10)
            increaseQuality();
        if (item.sellIn < 6)
            increaseQuality();
        if (isItemExpired(item.sellIn))
            item.quality = 0;
    }

    @Override
    public void update() {
        updateQuality();
        updateSellIn();
    }

    @Override
    public Item getItem() {
        return item;
    }
}
