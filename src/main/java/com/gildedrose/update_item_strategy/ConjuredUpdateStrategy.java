package com.gildedrose.update_item_strategy;

import com.gildedrose.Item;

public class ConjuredUpdateStrategy implements ItemUpdateStrategy {
    private final Item item;

    public ConjuredUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    public void updateQuality() {
        if (isItemExpired(item.sellIn))
            decreaseQualityTwice();
        else
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

    @Override
    public void decreaseQuality() {
        item.quality -= 2;
    }

    private void decreaseQualityTwice() {
        item.quality -= 4;
    }
}
