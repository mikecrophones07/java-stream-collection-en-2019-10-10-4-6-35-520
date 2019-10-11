package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if(left < right){
            return IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
        }
        else{
            return IntStream.rangeClosed(right, left).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if(left < right){
            return IntStream.rangeClosed(left, right).filter(value -> value%2 == 0).boxed().collect(Collectors.toList());
        }
        else{
            return IntStream.rangeClosed(right, left).filter(value -> value%2 == 0).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(value -> value%2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array).reduce((first, second) -> second)
                .orElse(0);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> finalRes =  Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        finalRes.retainAll(Arrays.stream(secondArray).boxed().collect(Collectors.toList()));
        return finalRes;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> finalRes =  Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> unCommon = Arrays.stream(secondArray).collect(Collectors.toList());
        unCommon.removeAll(finalRes);
        finalRes.addAll(unCommon);
        return finalRes;
    }
}
