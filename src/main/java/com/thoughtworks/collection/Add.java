package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.charset.MalformedInputException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Integer maxVal = Math.max(leftBorder, rightBorder);
        Integer minVal = Math.min(leftBorder, rightBorder);

        System.out.println(minVal + " " + maxVal);
        IntStream stream = IntStream.rangeClosed(minVal, maxVal);
        return stream.boxed().filter(value -> value%2==0).mapToInt(Integer::intValue).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        Integer maxVal = Math.max(leftBorder, rightBorder);
        Integer minVal = Math.min(leftBorder, rightBorder);

        System.out.println(minVal + " " + maxVal);
        IntStream stream = IntStream.rangeClosed(minVal, maxVal);
        return stream.boxed().filter(value -> value%2!=0).mapToInt(Integer::intValue).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(value -> (value * 3) + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(value -> {
            if(value%2 != 0) {
                return (value * 3) + 2;
            }
            else {
                return value;
            }
        }).boxed().collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(value -> value%2!=0 ).mapToInt(value -> (value * 3) + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(value -> value%2==0).collect(Collectors.toList());
        return IntStream.range(0, evenList.size()).mapToLong(index -> {
            return getSumMedian(evenList, index);
        }).sum();
    }

    private long getSumMedian(List<Integer> evenList, int index) {
        Integer halfSize = evenList.size()/2;
        if(evenList.size()%2 == 0 && index == halfSize-1){
            return (evenList.get(index) + evenList.get(++index))/2;
        }
        else if(evenList.size()%2 != 0 && index == halfSize-1){
            return evenList.get(index);
        }
        else{
            return 0;
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().mapToDouble(Integer::intValue).average().orElse(0);
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(value -> value%2==0).collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return new ArrayList<>(new HashSet<>(arrayList.stream().filter(value -> value%2==0).collect(Collectors.toList())));
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream()
                .filter(value -> value % 2 == 0)
                .collect(Collectors.toList());
        List<Integer> odd = arrayList.stream()
                .filter(value -> value % 2 != 0)
                .collect(Collectors.toList());
        Collections.reverse(odd);
        even.addAll(odd);
        return even;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return IntStream.range(0, arrayList.size()-1).map(index -> {
            if(index != arrayList.size()-1) {
               return (arrayList.get(index) * 3) + arrayList.get(index + 1) * 3;
            }
            return 0;
        }).boxed().collect(Collectors.toList());

    }
}
