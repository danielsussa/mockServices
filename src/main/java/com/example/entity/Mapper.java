package com.example.entity;

import java.util.List;

/**
 * Created by DEK on 13/03/2017.
 */
public class Mapper {
    String key;
    List<Mapper> mappers;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(List<Mapper> mappers) {
        this.mappers = mappers;
    }
}
