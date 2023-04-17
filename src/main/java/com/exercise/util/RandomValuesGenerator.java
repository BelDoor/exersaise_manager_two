package com.exercise.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class RandomValuesGenerator {

    public String uuidGenerator() {
        return UUID.randomUUID().toString();
    }

}
