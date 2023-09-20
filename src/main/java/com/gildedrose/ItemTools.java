package com.gildedrose;

public class ItemTools {

    public static int getQualityUpdateFactor(int sellIn) {
        return sellIn < 0 ? 2 : 1;
    }

    public static int restrictQualityWithinBounds(int quality) {
        return Math.min(50, Math.max(quality, 0));
    }
}
