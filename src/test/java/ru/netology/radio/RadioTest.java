package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    @Test
    public void shouldSetRadioStationsQuantity() {
        Radio radio = new Radio(30);

        int expected = 30;
        int actual = radio.getRadioStationsQuantity();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetRadioStationsQuantityByDefault() {
        Radio radio = new Radio();
        int expected = 10;
        int actual = radio.getRadioStationsQuantity();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetRadioStationBetweenMaxAndMin() {
        Radio radio = new Radio(30);

        radio.setCurrentRadioStation(23);

        int expected = 23;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetRadioStationAboveMax() {
        Radio radio = new Radio(30);

        radio.setCurrentRadioStation(32);
        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetRadioStationBelowMin() {
        Radio radio = new Radio(30);

        radio.setCurrentRadioStation(-1);
        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseCurrentRadioStationBy1() {
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(5);

        radio.next();

        int expected = 6;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseCurrentRadioStationFromMaxToMin() {
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(29);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldDecreaseCurrentRadioStationBy1() {
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(6);

        radio.prev();

        int expected = 5;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseCurrentRadioStationFromMinToMax() {
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(0);

        radio.prev();

        int expected = 29;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseCurrentVolumeBy1() {
        Radio radio = new Radio();
        radio.setCurrentVolume(92);

        radio.increaseVolume();

        int expected = 93;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseCurrentVolumeBy1() {
        Radio radio = new Radio();
        radio.setCurrentVolume(93);

        radio.decreaseVolume();

        int expected = 92;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseCurrentVolumeIf100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDecreaseCurrentVolumeIf0() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
