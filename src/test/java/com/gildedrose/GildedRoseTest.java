package com.gildedrose;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private Item[] items;

    @BeforeEach
    void setUp() {
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        };
    }

    @AfterEach
    void clear() {
        items = null;
    }

    @Test
    @DisplayName("For All Items except Sulfuras sell in value should decrease after each day")
    void sellInValueShouldDecreaseWithTime() {
        int numberOfDays = 3;
        //Arrange
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(7, gildedRose.items[0].sellIn);
        assertEquals(-1, gildedRose.items[1].sellIn);
        assertEquals(2, gildedRose.items[2].sellIn);
        assertEquals(12, gildedRose.items[5].sellIn);

    }

    @Test
    @DisplayName("Sulfuras sell in value never changes")
    void sulfurasSellInValueShouldBeTheSame() {
        int numberOfDays = 5;
        //Arrange
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(0, gildedRose.items[3].sellIn);

    }

    @Test
    @DisplayName("Sulfuras Quality value never changes")
    void sulfurasQualityValueShouldBeTheSame() {
        int numberOfDays = 5;
        //Arrange
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(80, gildedRose.items[3].quality);

    }

    @Test
    @DisplayName("Normal item Quality value decrease with time")
    void normalItemQualityValueShouldDecrease() {
        int numberOfDays = 5;
        //Arrange
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(15, gildedRose.items[0].quality);
    }

    @Test
    @DisplayName("Normal item Quality value decrease twice as fast when all sell sby date has passed ")
    void normalItemQualityValueShouldDecreaseTwiceIfSellInNegative() {
        //Arrange
        int numberOfDays = 3;
        items[0].sellIn = 0;
        items[2].sellIn = 0;
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(14, gildedRose.items[0].quality);
        assertEquals(1, gildedRose.items[2].quality);
    }
    @Test
    @DisplayName("Aged brie item Quality value increase twice as fast when all sell sby date has passed ")
    void AgedBrieQualityValueShouldIncreaseTwiceIfSellInNegative() {
        //Arrange
        int numberOfDays = 3;
        items[1].sellIn = 0;
        items[1].quality = 10;
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(16, gildedRose.items[1].quality);
    }

    @Test
    @DisplayName("Normal item Quality value Can't be negative ")
    void normalItemQualityValueNeverBeNegative() {
        //Arrange
        int numberOfDays = 3;
        items[0].sellIn = 0;
        items[0].quality = 5;
        items[2].sellIn = 0;
        items[2].quality = 5;
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(0, gildedRose.items[0].quality);
        assertEquals(0, gildedRose.items[2].quality);
    }

    @Test
    @DisplayName("Item quality always less than 50 ")
    void itemQualityValueLessThanFifty() {
        //Arrange
        int numberOfDays = 2;
        items[1].quality = 49;
        items[1].sellIn = 20;
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(50, gildedRose.items[1].quality);
        assertEquals(50, gildedRose.items[6].quality);
    }

    @Test
    @DisplayName("Aged brie and Backstage item there values " +
            "increase with time when sell in value is more than 10")
    void agedBrieAndBackStageQualityValueIncreaseByTime() {
        //Arrange
        int numberOfDays = 2;
        items[1].quality = 20;
        items[1].sellIn = 20;
        items[5].quality = 20;
        items[5].sellIn = 20;
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(22, gildedRose.items[1].quality);
        assertEquals(22, gildedRose.items[5].quality);
    }

    @Test
    @DisplayName("Backstage item  value " +
            "increases by 2 with time when sell in value is more less 10 and more than 5")
    void backStageQualityValueIncreaseTwiceByTime() {
        //Arrange
        int numberOfDays = 2;
        items[5].quality = 20;
        items[5].sellIn = 9;
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(24, gildedRose.items[5].quality);
    }

    @Test
    @DisplayName("Backstage item  value " +
            "increases by 3 with time when sell in value is less than 6")
    void backStageQualityValueIncreaseByThree() {
        //Arrange
        int numberOfDays = 2;
        items[5].quality = 20;
        items[5].sellIn = 5;
        GildedRose gildedRose = new GildedRose(items);
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(26, gildedRose.items[5].quality);
    }

    @Test
    @DisplayName("Backstage item  value " +
            "drops to zero when sell in value is zero or negative")
    void backStageQualityValueDropsToZero() {
        //Arrange
        items[5].quality = 20;
        items[5].sellIn = 0;
        GildedRose gildedRose = new GildedRose(items);
        //Act
        gildedRose.updateQuality();
        //Assert
        assertEquals(0, gildedRose.items[5].quality);
    }
}
