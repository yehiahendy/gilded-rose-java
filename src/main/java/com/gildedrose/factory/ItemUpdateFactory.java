package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.update_item_strategy.*;

import static com.gildedrose.ItemNames.*;

public class ItemUpdateFactory implements UpdateStrategyFactory {


    @Override
    public ItemUpdateStrategy createItemUpdateStrategy(Item item) {
        switch (item.name) {
            case SULFURAS_HAND_OF_RAGNAROS:
                return new SulfurasUpdateStrategy(item);
            case AGED_BRIE:
                return new AgedBrieUpdateStrategy(item);
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new BackStageUpdateStrategy(item);
            case CONJURED:
                return new ConjuredUpdateStrategy(item);
            default:
                return new NormalItemUpdateStrategy(item);
        }
    }
}
