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
        if (isSellInNegative()) {
            item.quality = 0;
        } else if (isSellInLessThanFive()) {
            item.quality += 3;
        } else if (isSellInLessThanTen()) {
            item.quality += 2;
        } else {
            item.quality++;
        }
        item.quality = restrictQualityWithinBounds(item.quality);
    }

    private boolean isSellInLessThanTen() {
        return item.sellIn < 10;
    }

    private boolean isSellInLessThanFive() {
        return item.sellIn < 5;
    }

    private boolean isSellInNegative() {
        return item.sellIn < 0;
    }

}
