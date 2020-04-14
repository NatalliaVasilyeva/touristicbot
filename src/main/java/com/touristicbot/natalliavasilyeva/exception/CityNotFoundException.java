package com.touristicbot.natalliavasilyeva.exception;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(Long id) {
        super("Could not find city " + id);
    }
}
