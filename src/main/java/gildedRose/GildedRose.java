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
                    itemStrategy = new AgedBrie();
                    update(i, itemStrategy);
                    break;

                case BPTATC:
                    itemStrategy = new Backstage();
                    update(i, itemStrategy);
                    break;

                case SHOR:
                    itemStrategy = new Sulfuras();
                    update(i, itemStrategy);
                    break;

                default:
                    itemStrategy = new NormalItem();
                    update(i, itemStrategy);
                    break;
            }
        }
    }

    private void update(int i, ItemStrategy itemStrategy) {
        itemStrategy.update(items.get(i));
        deassignParams(items.get(i));
    }

    private void deassignParams(Item item) {
        quality = item.quality;
        sellIn = item.sellIn;
        name = item.name;
    }

    private void initParams(int i) {
        this.name = items.get(i).name;
        this.quality = items.get(i).quality;
        this.sellIn = items.get(i).sellIn;
    }
}