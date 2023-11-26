package com.proftelran.org.homework_12.searchengine;

import java.util.Map;

public class Product {

    private int id;
    private String name;
    private Map<String, String> stringProperties;
    private Map<String, Integer> integerProperties;

    public Product(int id, String name, Map<String, String> stringProperties, Map<String, Integer> integerProperties) {
        this.id = id;
        this.name = name;
        this.stringProperties = stringProperties;
        this.integerProperties = integerProperties;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getStringProperties() {
        return stringProperties;
    }


    public Map<String, Integer> getIntegerProperties() {
        return integerProperties;
    }

}