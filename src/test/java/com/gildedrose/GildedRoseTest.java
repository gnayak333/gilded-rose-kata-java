package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @ParameterizedTest
    @MethodSource("getTestItems")
    void testUpdateQuality(String item, int sellIn, int quality, int updatedSellIn, int updatedQuality) {
        Item[] items = new Item[]{new Item(item, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedQuality, app.items[0].quality);
        assertEquals(updatedSellIn, app.items[0].sellIn);
    }

    private static Stream<Arguments> getTestItems() {
        return Stream.of(
            Arguments.of("Conjured Mana Cake", 3, 6, 2 ,4),
            Arguments.of("Elixir of the Mongoose", 5, 7, 4 ,6),
            Arguments.of("Elixir of the Mongoose", -5, 7, -6 ,5),
            Arguments.of("Sulfuras, Hand of Ragnaros", 0, 80, 0, 80),
            Arguments.of("Sulfuras, Hand of Ragnaros", -1, 80, -1, 80),
            Arguments.of("Aged Brie", -5, 12, -6, 14),
            Arguments.of("Aged Brie", 1, 1, 0, 2),
            Arguments.of("Aged Brie", 0, 2, -1, 4),
            Arguments.of("+5 Dexterity Vest", 10, 20, 9 , 19),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 15, 20, 14, 21),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 10, 49, 9 , 50),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 5, 50, 4 ,50),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", -2, 0, -3, 0)
        );
    }

}
