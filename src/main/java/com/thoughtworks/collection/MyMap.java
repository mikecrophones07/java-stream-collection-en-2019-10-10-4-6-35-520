package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(value -> value * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(value -> {
            return getEquivalentAlphabet(value);
        }).collect(Collectors.toList());
    }

    private String getEquivalentAlphabet(Integer value) {
        int num = value + 96;
        return String.valueOf(Character.valueOf((char) num));
    }

    public List<String> mapLetters() {
        return array.stream().map(value -> {
            List<Integer> list;
//            int num = value + 96;
//            String result = isInRange(num) ? String.valueOf(Character.valueOf((char)getRangeNumber(num))) : "";
//            while (!isInRange(num)){
//                num = num - 26;
//                result += isInRange(num) ? String.valueOf(Character.valueOf((char)getRangeNumber(num))) : "";
//            }
            return "";
        }).collect(Collectors.toList());
    }

    private int getRangeNumber(int num) {
        if(isInRange(num)){
            return num;
        }
        else if(num < 97) {
            return num;
        }
        return getRangeNumber(num - 26);
    }

    private boolean isInRange(int num) {
        return num > 96 && num <= 122;
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted(Collections.reverseOrder().reversed()).collect(Collectors.toList());
    }
}
