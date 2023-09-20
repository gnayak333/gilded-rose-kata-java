package com.gildedrose;

import static com.gildedrose.ItemTools.getQualityUpdateFactor;
import static com.gildedrose.ItemTools.restrictQualityWithinBounds;

public class AgedBrie implements SpecialItem{
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }
    @Override
    public void update() {
        item.sellIn--;
        item.quality += getQualityUpdateFactor(item.sellIn);
        item.quality = restrictQualityWithinBounds(item.quality);
    }
}
