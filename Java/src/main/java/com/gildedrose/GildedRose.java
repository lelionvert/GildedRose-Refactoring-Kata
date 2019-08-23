package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final int INCREASE_QUALITY_TEN_DAY_LIMIT = 11;
    private static final int INCREASE_QUALITY_FIVE_DAY_LIMIT = 6;
    private static final int SELLIN_MIN = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (int itemIndex = 0; itemIndex < items.length; itemIndex++) {
            Item item = items[itemIndex];
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        updateSellin(item);
        updateQuality(item);
    }

    private void updateQuality(Item item) {
        if (isSulfuras(item.name)) {
            return;
        }
        if (isAgedBrie(item.name)) {
            updateAgedBrie(item);
            return;
        }
        if (isBackstagePasses(item.name)) {
            updateBackstagePasses(item);
            return;
        }
        updateStandardItem(item);
    }

    private void updateStandardItem(Item item) {
        decrementNotMinimumQuality(item);
        if (item.sellIn < SELLIN_MIN)
            decrementNotMinimumQuality(item);
    }

    private void updateBackstagePasses(Item item) {
        if (item.quality < MAX_QUALITY) {
            incrementQuality(item);
            updateBackstagePassesQuality(item, item.name);
        }
        if (item.sellIn < SELLIN_MIN)
            resetQuality(item);
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < MAX_QUALITY) {
            incrementQuality(item);
            if (item.sellIn < SELLIN_MIN)
                incrementQuality(item);
        }
        return;
    }

    private void updateSellin(Item item) {
        if (!isSulfuras(item.name)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void decrementNotMinimumQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            decrementQuality(item);
        }
    }

    private void updateBackstagePassesQuality(Item item, String name) {
        if (isBackstagePasses(name)) {
            if (item.sellIn < INCREASE_QUALITY_TEN_DAY_LIMIT) {
                if (item.quality < MAX_QUALITY) {
                    incrementQuality(item);
                }
            }

            if (item.sellIn < INCREASE_QUALITY_FIVE_DAY_LIMIT) {
                if (item.quality < MAX_QUALITY) {
                    incrementQuality(item);
                }
            }
        }
    }

    private void resetQuality(Item item) {
        item.quality = 0;
    }

    private boolean isAgedBrie(String name) {
        return name.equals(AGED_BRIE);
    }

    private boolean isSulfuras(String name) {
        return name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    private boolean isBackstagePasses(String name) {
        return name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);
    }

    private void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void decrementQuality(Item item) {
        item.quality = item.quality - 1;
    }

}