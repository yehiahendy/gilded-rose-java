package com.gildedrose;

import com.gildedrose.update_item_strategy.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemUpdateStrategy itemUpdateStrategy;
        for (Item item : items) {
            itemUpdateStrategy = createItemUpdateStrategy(item);
            itemUpdateStrategy.update();
        }
    }

    private ItemUpdateStrategy createItemUpdateStrategy(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasUpdateStrategy(item);
            case "Aged Brie":
                return new AgedBrieUpdateStrategy(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackStageUpdateStrategy(item);
            default:
                return new NormalItemUpdateStrategy(item);
        }
    }
}