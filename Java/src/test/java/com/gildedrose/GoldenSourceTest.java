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

}
