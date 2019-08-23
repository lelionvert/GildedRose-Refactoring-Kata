package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenSourceTest {

    @Test
    void update_one_day_dexterity_vest_with_sellin_10_and_quality_20_should_decrement_quality() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(19, items[0].quality);
    }

    @Test
    void update_one_day_dexterity_vest_with_sellin_10_and_quality_20_should_decrement_sellin() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
    }

    @Test
    void update_one_day_aged_brie_with_sellin_2_and_quality_0_should_decrement_sellin() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(1, items[0].sellIn);
    }

    @Test
    void update_one_day_aged_brie_with_sellin_2_and_quality_0_should_increment_quality() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(1, items[0].sellIn);
    }

    @Test
    void update_one_day_sulfuras_with_sellin_0_and_quality_80_should_not_modify_quality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, items[0].quality);
    }

    @Test
    void update_one_day_sulfuras_with_sellin_0_and_quality_80_should_not_modify_sellin() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, items[0].sellIn);
    }

    @Test
    void update_one_day_sulfuras_with_sellin_minus_1_and_quality_80_should_not_modify_quality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, items[0].quality);
    }

    @Test
    void update_one_day_sulfuras_with_sellin_minus_1_and_quality_80_should_not_modify_sellin() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
    }




}
