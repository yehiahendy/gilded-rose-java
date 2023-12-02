package com.gildedrose;

import com.gildedrose.factory.ItemUpdateFactory;
import com.gildedrose.update_item_strategy.ItemUpdateStrategy;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemUpdateStrategy itemUpdateStrategy;
        ItemUpdateFactory factory = new ItemUpdateFactory();
        for (Item item : items) {
            itemUpdateStrategy = factory.createItemUpdateStrategy(item);
            itemUpdateStrategy.update();
        }
    }
}