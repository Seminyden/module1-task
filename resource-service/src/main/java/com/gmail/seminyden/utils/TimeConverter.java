package com.gmail.seminyden.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TimeConverter {

    public String convert(String seconds) {
        int minutes = (int) (Double.parseDouble(seconds) / 60);
        int remainingSeconds = (int) (Double.parseDouble(seconds) % 60);
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}