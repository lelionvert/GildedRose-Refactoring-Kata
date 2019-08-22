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
            Item item = items[itemIndex];
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        String name = item.name;
        if (!isAgedBrie(name)
                && !isBackstagePasses(name)) {
            if (item.quality > MIN_QUALITY) {
                if (!isSulfuras(name)) {
                    decrementQuality(item);
                }
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                incrementQuality(item);

                if (isBackstagePasses(name)) {
                    if (item.sellIn < 11) {
                        if (item.quality < MAX_QUALITY) {
                            incrementQuality(item);
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < MAX_QUALITY) {
                            incrementQuality(item);
                        }
                    }
                }
            }
        }

        if (!isSulfuras(name)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!isAgedBrie(name)) {
                if (!isBackstagePasses(name)) {
                    if (item.quality > MIN_QUALITY) {
                        if (!isSulfuras(name)) {
                            decrementQuality(item);
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    incrementQuality(item);
                }
            }
        }
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