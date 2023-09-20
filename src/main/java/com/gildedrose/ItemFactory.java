package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String CONJURED = "Conjured Mana Cake";

    private final Map<String, SpecialItem> itemMap= new HashMap<>();

    public ItemFactory(Item item) {
        itemMap.put(SULFURAS, new Sulfuras());
        itemMap.put(BACKSTAGE_PASSES, new BackstagePasses(item));
        itemMap.put(AGED_BRIE, new AgedBrie(item));
        itemMap.put(CONJURED, new Conjured(item));
    }

    public SpecialItem getItem(Item item) {
        if (itemMap.containsKey(item.name)) {
            return itemMap.get(item.name);
        }
        return new NormalItem(item);
    }
}
