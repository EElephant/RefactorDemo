package gildedRose;

import java.util.List;

public class GildedRose {

    private final static String AGED_BRIE = "Aged Brie";

    protected List<Item> items;
    protected String name;
    protected int quality;
    protected int sellIn;

    public GildedRose(List<Item> items) {
        this.items = items;
    }


    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {

            initParams(i);

            if (!name.equals("Aged Brie")
                    && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (quality > 0) {
                    reduceQualityWhenNameEqualsSulfuras();
                }
            } else {
                if (quality < 50) {
                    quality ++;

                    if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        addQualityBySellIn();
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
                            reduceQualityWhenNameEqualsSulfuras();
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

    private void addQualityBySellIn() {
        if (sellIn < 11) {
            addQualityWhenQualityLessThan50();
        }

        if (sellIn < 6) {
            addQualityWhenQualityLessThan50();
        }
    }

    private void reduceQualityWhenNameEqualsSulfuras() {
        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            quality--;
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