package com.gildedrose;

class GildedRose {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String CONJURED = "Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            int qualityUpdateFactor = item.sellIn < 0 ? 2 : 1;

            if (item.name.equals(SULFURAS)) {
                continue;
            }

            switch (item.name) {
                case BACKSTAGE_PASSES:
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    } else if (item.sellIn <= 5) {
                        item.quality += 3;
                    } else if (item.sellIn <= 10) {
                        item.quality += 2;
                    } else {
                        item.quality++;
                    }
                    break;
                case AGED_BRIE:
                    item.quality += qualityUpdateFactor;
                    break;
                case CONJURED:
                    item.quality -= 2 * qualityUpdateFactor;
                    break;
                default:
                    item.quality -= qualityUpdateFactor;
                    break;
            }

            item.quality = Math.min(50, Math.max(item.quality, 0));
            item.sellIn--;
        }
    }
}
