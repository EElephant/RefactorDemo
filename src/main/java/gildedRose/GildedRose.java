package gildedRose;

import java.util.List;

public class GildedRose {



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
            update(i);
        }
    }

    private void update(int i) {
        items.get(i).update(items.get(i));
        deassignParams(items.get(i));
    }


    private void initParams(int i) {
        this.name = items.get(i).name;
        this.quality = items.get(i).quality;
        this.sellIn = items.get(i).sellIn;
    }
    private void deassignParams(Item item) {
        quality = item.quality;
        sellIn = item.sellIn;
        name = item.name;
    }
}