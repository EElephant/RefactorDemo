package gildedRose;

import java.util.List;

public class GildedRose {
    List<Item> items;
    String name;
    int quality;
    int sellIn;

    public GildedRose(List<Item> items) {
        this.items = items;
    }


    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            initParams(i);
            if (!name.equals("Aged Brie")
                    && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (quality > 0) {
                    if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                        quality --;
                    }
                }
            } else {
                if (quality < 50) {
                    quality ++;

                    if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (sellIn < 11) {
                            addQualityWhenQualityLessThan50();
                        }

                        if (sellIn < 6) {
                            addQualityWhenQualityLessThan50();
                        }
                    }
                }
            }

            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                sellIn --;
            }

            if (sellIn < 0) {
                if (!name.equals("Aged Brie")) {
                    if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (quality > 0) {
                            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                                quality --;
                            }
                        }
                    } else {
                        quality = 0;
                    }
                } else {
                    addQualityWhenQualityLessThan50();
                }
            }
        }
    }

    private void addQualityWhenQualityLessThan50() {
        if (quality < 50)
            quality++;
    }

    private void initParams(int i) {
        this.name = items.get(i).name;
        this.quality = items.get(i).quality;
        this.sellIn = items.get(i).sellIn;
    }
}