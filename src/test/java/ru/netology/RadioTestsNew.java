package ru.netology;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

//    @Test
//    public void shouldCheckSettingStationQuantity() {
//        radio.setMaxRadioStation(11);
//        assertEquals(11, radio.getMaxRadioStation());
//    }

    @Test
    void shouldChangeTheStationByRemoteControl() {
        assertEquals(8, radio.changeTheStationByRemoteControl(8));
    }


    @Test
    void shouldChangeTheStationByRemoteControlIfStationQuantityIsChanged() {
        Radio radio = new Radio(15);
        assertEquals(14, radio.changeTheStationByRemoteControl(14));
    }

    @Test
    void shouldChangeTheStationByButtonNextIfStationQuantityIsChanged() {
        Radio radio = new Radio(15, 15);
        radio.changeTheStationByNextButton();
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    void shouldChangeTheStationByButtonNext() {
        radio.changeTheStationByNextButton();
        assertEquals(6, radio.getCurrentRadioStation());
    }

    @Test
    void shouldChangeTheStationByPrevButtonIfStationQuantityIsChanged() {
        Radio radio = new Radio(0, 15);
        radio.changeTheStationByPrevButton();
        assertEquals(15, radio.getCurrentRadioStation());
    }

    @Test
    void shouldChangeTheStationByPrevButton() {
        radio.changeTheStationByPrevButton();
        assertEquals(4, radio.getCurrentRadioStation());
    }


    @Test
    void shouldIncreaseVolumeUnderMax() {
        radio.increaseVolume();
        assertEquals(6, radio.getCurrentVolume());
    }

    @Test
    void shouldIncreaseVolumeAboveMax() {
        Radio radio = new Radio(100, 100, 0);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        radio.decreaseVolume();
        assertEquals(4, radio.getCurrentVolume());
    }


    @Test
    void shouldDecreaseVolumeIfMin() {
        Radio radio = new Radio(0, 100, 0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

}