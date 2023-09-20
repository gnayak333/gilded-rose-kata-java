package com.gildedrose;

import static com.gildedrose.ItemTools.restrictQualityWithinBounds;

public class BackstagePasses implements SpecialItem {
    private final Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            item.quality += 3;
        } else if (item.sellIn < 10) {
            item.quality += 2;
        } else {
            item.quality++;
        }
        item.quality = restrictQualityWithinBounds(item.quality);
    }
}
