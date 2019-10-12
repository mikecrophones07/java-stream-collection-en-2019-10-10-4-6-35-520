package com.thoughtworks.collection;

import javafx.beans.binding.When;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> result = new ArrayList<>();
        Integer divider = random.nextInt(3);
        Integer num = Integer.parseInt(String.valueOf(number));
        while((num - divider) > 0){
            num -= divider;
            result.add(num);
        }
        return result;
    }
}
