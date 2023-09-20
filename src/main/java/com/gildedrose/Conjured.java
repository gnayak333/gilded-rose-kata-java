package com.gildedrose;

import static com.gildedrose.ItemTools.getQualityUpdateFactor;
import static com.gildedrose.ItemTools.restrictQualityWithinBounds;

public class Conjured implements SpecialItem {
    private final Item item;

    public Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;
        item.quality = restrictQualityWithinBounds(item.quality - 2 * getQualityUpdateFactor(item.sellIn));
    }
}
