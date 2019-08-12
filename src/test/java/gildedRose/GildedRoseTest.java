package gildedRose;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseTest {


    private static String AGED_BRIE = "Aged Brie";
    private static String ITEM_A = "Item A";
    private static String BPTATC = "Backstage passes to a TAFKAL80ETC concert";


    @Test
    public void should_return_49_given_item_name_is_item_A_and_item_quality_is_50_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(ITEM_A,10,50));
        gildedRose.updateQuality();

        Assert.assertEquals(49,gildedRose.getItem(0).quality);
    }

    @Test
    public void should_return_50_given_item_name_is_Aged_Brie_and_item_quality_is_50_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(AGED_BRIE,10,50));
        gildedRose.updateQuality();

        Assert.assertEquals(50,gildedRose.getItem(0).quality);
    }

    @Test
    public void should_return_50_given_item_name_is_Aged_Brie_and_item_quality_is_49_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(AGED_BRIE,10,49));
        gildedRose.updateQuality();

        Assert.assertEquals(50,gildedRose.getItem(0).quality);
    }

    @Test
    public void should_return_50_given_item_name_is_Aged_Brie_and_item_quality_is_49_and_item_sellIn_is_10_when_call_updateQuality(){
        GildedRose gildedRose = getGildedRose( new Item(BPTATC,10,49));
        gildedRose.updateQuality();

        Assert.assertEquals(50,gildedRose.getItem(0).quality);
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
