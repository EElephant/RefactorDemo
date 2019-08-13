package gildedRose;

public class Item {

    private final static String AGED_BRIE = "Aged Brie";
    private final static String BPTATC = "Backstage passes to a TAFKAL80ETC concert";
    private final static String SHOR = "Sulfuras, Hand of Ragnaros";

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update(Item item){
        ItemStrategy itemStrategy;

        switch(name){
            case AGED_BRIE:
                itemStrategy = new AgedBrie();
                updateParmas(item, itemStrategy);
                break;

            case BPTATC:
                itemStrategy = new Backstage();
                updateParmas(item, itemStrategy);
                break;

            case SHOR:
                itemStrategy = new Sulfuras();
                updateParmas(item, itemStrategy);
                break;

            default:
                itemStrategy = new NormalItem();
                updateParmas(item, itemStrategy);
                break;
        }
    }

    private void updateParmas(Item item, ItemStrategy itemStrategy) {
        itemStrategy.update(item);
    }

    private void deassignParams(Item item) {
        quality = item.quality;
        sellIn = item.sellIn;
        name = item.name;
    }

}
