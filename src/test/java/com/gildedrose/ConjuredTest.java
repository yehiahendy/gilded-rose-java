package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemNames.CONJURED;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest {
    GildedRose gildedRose;

    @BeforeEach
    void beforeAll() {
        Item[] Conjured = new Item[]{
                new Item(CONJURED, 5, 15),
                new Item(CONJURED, 0, 10),
                new Item(CONJURED, 0, 20),
        };
        gildedRose = new GildedRose(Conjured);
    }

    @Test
    @DisplayName("Conjured item Quality value decrease twice faster than normal")
    void conjuredItemQualityValueShouldDecreaseTwiceThanFaster() {
        //Arrange
        int numberOfDays = 3;
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(9, gildedRose.items[0].quality);
    }
    @Test
    @DisplayName("Conjured item Quality value decrease by four when Item is expired")
    void conjuredItemQualityValueShouldDecreaseTwiceThanFasterWhenExpire() {
        //Arrange
        int numberOfDays = 3;
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(8, gildedRose.items[2].quality);
    }

    @Test
    @DisplayName("Conjured item Sell in value decreases with time")
    void conjuredItemQualityValueShouldDecreaseSellIn() {
        //Arrange
        int numberOfDays = 3;
        //Act
        for (int i = 0; i < numberOfDays; i++)
            gildedRose.updateQuality();
        //Assert
        assertEquals(2, gildedRose.items[0].sellIn);
    }

}
