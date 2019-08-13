package gildedRose;

public class AgedBrie implements ItemStrategy {
    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality ++;
        }
        item.sellIn --;
        if (item.sellIn < 0) {
            if (item.quality < 50)
                item.quality++;
        }
    }
}
