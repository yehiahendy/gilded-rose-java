package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.update_item_strategy.ItemUpdateStrategy;

public interface UpdateStrategyFactory {
    ItemUpdateStrategy createItemUpdateStrategy(Item item);
}
