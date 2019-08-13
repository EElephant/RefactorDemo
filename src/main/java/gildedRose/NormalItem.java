package gildedRose;

public class NormalItem implements ItemStrategy {
    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn --;
        if (item.sellIn < 0) {
            modifyQualityByItemName(item);
        }
    }

    private void modifyQualityByItemName(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
