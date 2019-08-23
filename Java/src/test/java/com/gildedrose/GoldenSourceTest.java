package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenSourceTest {

    @Test
    void update_one_day_aged_brie_with_sellin_2_and_quality_less_than_quality_max_should_increment_quality() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(1, items[0].quality);
    }

    @Test
    void update_one_day_aged_brie_with_sellin_less_than_sellin_min_and_quality_less_than_quality_max_should_increment_quality() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(2, items[0].quality);
    }

    @Test
    void update_one_day_backstage_passes_with_sellin_15_and_quality_less_than_quality_max_should_increment_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(21, items[0].quality);
    }

    @Test
    void update_one_day_backstage_passes_with_sellin_less_than_sellin_min_and_quality_less_than_quality_max_should_increment_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(0, items[0].quality);
    }

    @Test
    void update_one_day_elixir_with_sellin_5_and_quality_less_than_quality_max_should_decrement_quality() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 5, 7)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(6, items[0].quality);
    }


    @Test
    void update_one_day_dexterity_vest_with_sellin_less_than_sellin_min_and_quality_less_than_quality_max_should_decrement_sellin() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(18, items[0].quality);
    }

    @Test
    void update_one_day_dexterity_vest_with_sellin_10_and_quality_20_should_decrement_quality() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(19, items[0].quality);
    }

    @Test
    void update_one_day_dexterity_vest_with_sellin_10_and_quality_20_should_decrement_sellin() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(9, items[0].sellIn);
    }

    @Test
    void update_one_day_aged_brie_with_sellin_2_and_quality_0_should_decrement_sellin() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(1, items[0].sellIn);
    }

    @Test
    void update_one_day_aged_brie_with_sellin_minus_1_and_quality_0_should_increment_quality() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(2, items[0].quality);
    }


    @Test
    void update_one_day_sulfuras_with_sellin_0_and_quality_80_should_not_modify_quality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(80, items[0].quality);
    }

    @Test
    void update_one_day_sulfuras_with_sellin_0_and_quality_80_should_not_modify_sellin() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(0, items[0].sellIn);
    }

    @Test
    void update_one_day_sulfuras_with_sellin_minus_1_and_quality_80_should_not_modify_quality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(80, items[0].quality);
    }

    @Test
    void update_one_day_sulfuras_with_sellin_minus_1_and_quality_80_should_not_modify_sellin() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void update_one_day_elixir_with_sellin_5_and_quality_7_should_decrement_sellin() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 5, 7)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(4, items[0].sellIn);
    }



    @Test
    void update_one_day_elixir_with_sellin_minus_1_and_quality_7_should_decrement_quality() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", -1, 7)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(5, items[0].quality);
    }


    @Test
    void update_one_day_backstage_passes_with_sellin_15_and_quality_20_should_decrement_sellin() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(14, items[0].sellIn);
    }


    @Test
    void update_one_day_backstage_passes_with_sellin_10_and_quality_49_should_increment_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(50, items[0].quality);
    }


    @Test
    void update_one_day_backstage_passes_with_sellin_10_and_quality_49_should_decrement_sellin() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(9, items[0].sellIn);
    }


    @Test
    void update_one_day_backstage_passes_with_sellin_minus_1_and_quality_10_should_reset_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(0, items[0].quality);
    }


}
