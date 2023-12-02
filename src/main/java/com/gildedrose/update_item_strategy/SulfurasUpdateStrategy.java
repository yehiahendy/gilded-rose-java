package com.gildedrose.update_item_strategy;

import com.gildedrose.Item;

public class SulfurasUpdateStrategy implements ItemUpdateStrategy {
    private final Item item;

    public SulfurasUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateSellIn() {

    }

    @Override
    public void updateQuality() {

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
