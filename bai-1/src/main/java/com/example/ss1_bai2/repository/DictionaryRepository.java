package com.example.ss1_bai2.repository;

import com.example.ss1_bai2.model.Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryRepository implements IDictionaryRepository {

    static Map<Integer, Dictionary> listDictionary = new HashMap<>();

    static {
        listDictionary.put(1, new Dictionary("banana", "chuối"));
        listDictionary.put(2, new Dictionary("apple", "táo"));
        listDictionary.put(3, new Dictionary("orange", "cam"));
        listDictionary.put(4, new Dictionary("coconut", "dừa"));
    }

    @Override
    public List<Dictionary> display() {
        return new ArrayList<>(listDictionary.values());
    }
}
