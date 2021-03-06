package gildedRose;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseTest {


    private final static String AGED_BRIE = "Aged Brie";
    private final static String ITEM_A = "Item A";
    private final static String BPTATC = "Backstage passes to a TAFKAL80ETC concert";
    private final static String SHOR = "Sulfuras, Hand of Ragnaros";


    @Test
    public void should_return_49_given_item_name_is_item_A_and_item_quality_is_50_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(ITEM_A,10,50));
        gildedRose.updateQuality();

        Assert.assertEquals(49,gildedRose.quality);
    }

    @Test
    public void should_return_50_given_item_name_is_Aged_Brie_and_item_quality_is_50_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(AGED_BRIE,10,50));
        gildedRose.updateQuality();

        Assert.assertEquals(50,gildedRose.quality);
    }

    @Test
    public void should_return_50_given_item_name_is_Aged_Brie_and_item_quality_is_49_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(AGED_BRIE,10,49));
        gildedRose.updateQuality();

        Assert.assertEquals(50,gildedRose.quality);
    }

    @Test
    public void should_return_50_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_item_quality_is_49_and_item_sellIn_is_10_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(BPTATC,10,49));
        gildedRose.updateQuality();

        Assert.assertEquals(50,gildedRose.quality);
    }

    @Test
    public void should_return_50_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_item_quality_is_48_and_item_sellIn_is_10_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(BPTATC,10,48));
        gildedRose.updateQuality();

        Assert.assertEquals(50,gildedRose.quality);
    }

    @Test
    public void should_return_50_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_item_quality_is_49_and_item_sellIn_is_5_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(BPTATC,5,49));
        gildedRose.updateQuality();

        Assert.assertEquals(50,gildedRose.quality);
    }

    @Test
    public void should_return_50_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_item_quality_is_47_and_item_sellIn_is_5_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(BPTATC,5,47));
        gildedRose.updateQuality();

        Assert.assertEquals(50,gildedRose.quality);
    }

    @Test
    public void should_return_0_given_item_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_item_quality_is_47_and_item_sellIn_less_than_0_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(BPTATC,-1,47));
        gildedRose.updateQuality();

        Assert.assertEquals(0,gildedRose.quality);
    }

    @Test
    public void should_return_45_given_item_name_is_Item_A_and_item_quality_is_47_and_item_sellIn_less_than_0_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(ITEM_A,-1,47));
        gildedRose.updateQuality();

        Assert.assertEquals(45,gildedRose.quality);
    }

    @Test
    public void should_return_47_given_item_name_is_Sulfuras_Hand_of_Ragnaros_and_item_quality_is_47_and_item_sellIn_less_than_0_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(SHOR,-1,47));
        gildedRose.updateQuality();

        Assert.assertEquals(47,gildedRose.quality);
    }

    @Test
    public void should_return_49_given_item_name_is_Aged_Brie_and_item_quality_is_47_and_item_sellIn_less_than_0_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(AGED_BRIE,-1,47));
        gildedRose.updateQuality();

        Assert.assertEquals(49,gildedRose.quality);
        Assert.assertEquals(-2,gildedRose.sellIn);
    }

    private List<Item> addItem(Item item,List<Item> items){
        items.add(item);
        return items;
    }

    private GildedRose getGildedRose(Item item) {
        List<Item> items = new ArrayList<>();
        addItem(item,items);
        return new GildedRose(items);
    }
}
