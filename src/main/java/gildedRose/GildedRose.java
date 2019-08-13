package gildedRose;

import java.util.List;

public class GildedRose {

    private final static String AGED_BRIE = "Aged Brie";
    private final static String BPTATC = "Backstage passes to a TAFKAL80ETC concert";
    private final static String SHOR = "Sulfuras, Hand of Ragnaros";

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
            ItemStrategy itemStrategy;

            switch(name){
                case AGED_BRIE:
//                    if (quality < 50) {
//                        quality ++;
//                    }
//                    sellIn --;
//                    if (sellIn < 0) {
//                        modifyQualityByItemName();
//                    }
                    itemStrategy = new AgedBrie();
                    itemStrategy.update(items.get(i));
                    deassignParams(items.get(i));
                    break;
                case BPTATC:
                    if (quality < 50) {
                        quality++;
                        addQualityBySellIn();
                    }
                    sellIn --;
                    if (sellIn < 0) {
                        modifyQualityByItemName();
                    }
                    break;
                case SHOR:
                    if (sellIn < 0) {
                        modifyQualityByItemName();
                    }
                    break;
                default:
                    if (quality > 0) {
                        reduceQualityWhenNameNotEqualsSulfuras();
                    }
                    sellIn --;
                    if (sellIn < 0) {
                        modifyQualityByItemName();
                    }
                    break;
            }

//            if (!name.equals("Aged Brie")
//                    && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (quality > 0) {
//                    reduceQualityWhenNameNotEqualsSulfuras();
//                }
//            } else {
//                if (quality < 50) {
//                    quality ++;
//
//                    if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        addQualityBySellIn();
//                    }
//                }
//            }
//
//            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
//                sellIn --;
//            }
//
//            if (sellIn < 0) {
//                modifyQualityByItemName();
//            }
        }
    }

    private void deassignParams(Item item) {
        quality = item.quality;
        sellIn = item.sellIn;
        name = item.name;
    }

    private void modifyQualityByItemName() {
        if (!name.equals("Aged Brie")) {
            if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (quality > 0) {
                    reduceQualityWhenNameNotEqualsSulfuras();
                }
            } else {
                quality = 0;
            }
        } else {
            addQualityWhenQualityLessThan50();
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

    private void reduceQualityWhenNameNotEqualsSulfuras() {
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