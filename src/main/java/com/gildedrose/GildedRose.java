package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            getSpecialItem(item).update();
        }
    }

    private SpecialItem getSpecialItem(Item item) {
        return new ItemFactory(item).getItem(item);
    }


}
