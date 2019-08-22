package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int itemIndex = 0; itemIndex < items.length; itemIndex++) {
            if (!items[itemIndex].name.equals(AGED_BRIE)
                    && !items[itemIndex].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                if (items[itemIndex].quality > MIN_QUALITY) {
                    if (!SULFURAS_HAND_OF_RAGNAROS.equals(items[itemIndex].name)) {
                        items[itemIndex].quality = items[itemIndex].quality - 1;
                    }
                }
            } else {
                if (items[itemIndex].quality < MAX_QUALITY) {
                    incrementQuality(itemIndex);

                    if (items[itemIndex].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (items[itemIndex].sellIn < 11) {
                            if (items[itemIndex].quality < MAX_QUALITY) {
                                incrementQuality(itemIndex);
                            }
                        }

                        if (items[itemIndex].sellIn < 6) {
                            if (items[itemIndex].quality < MAX_QUALITY) {
                                incrementQuality(itemIndex);
                            }
                        }
                    }
                }
            }

            if (!items[itemIndex].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                items[itemIndex].sellIn = items[itemIndex].sellIn - 1;
            }

            if (items[itemIndex].sellIn < 0) {
                if (!items[itemIndex].name.equals(AGED_BRIE)) {
                    if (!items[itemIndex].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (items[itemIndex].quality > MIN_QUALITY) {
                            if (!items[itemIndex].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                items[itemIndex].quality = items[itemIndex].quality - 1;
                            }
                        }
                    } else {
                        items[itemIndex].quality = 0;
                    }
                } else {
                    if (items[itemIndex].quality < MAX_QUALITY) {
                        incrementQuality(itemIndex);
                    }
                }
            }
        }
    }

    private void incrementQuality(int i) {
        items[i].quality = items[i].quality + 1;
    }
}