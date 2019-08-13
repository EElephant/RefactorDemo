package gildedRose;

public class Backstage implements ItemStrategy {
    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality++;
            addQualityBySellIn(item);
        }
        item.sellIn --;
        if (item.sellIn < 0) {
            modifyQualityByItemName(item);
        }
    }

    private void addQualityBySellIn(Item item) {
        if (item.sellIn < 11) {
            addQualityWhenQualityLessThan50(item);
        }

        if (item.sellIn < 6) {
            addQualityWhenQualityLessThan50(item);
        }
    }

    private void modifyQualityByItemName(Item item) {
        item.quality = 0;
    }

    private void addQualityWhenQualityLessThan50(Item item) {
        if (item.quality < 50)
            item.quality++;
    }

}
