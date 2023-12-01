package com.gildedrose.update_item_strategy;

import com.gildedrose.Item;

public class NormalItemUpdateStrategy implements ItemUpdateStrategy {
    private final Item item;

    public NormalItemUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        if (isItemExpired(item.sellIn))
            decreaseQuality();
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
