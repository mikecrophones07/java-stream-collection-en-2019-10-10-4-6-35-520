package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().reduce(0, (initial, curr) -> {
            if(initial>curr){
                return initial;
            }
            return curr;
        });
    }

    public double getMinimum() {
        return arrayList.stream().reduce(0, (initial, curr) -> {
            if(initial<curr && initial != 0){
                return initial;
            }
            return curr;
        });
    }

    public double getAverage() {
        return arrayList.stream().reduce(0, Integer::sum).doubleValue() / arrayList.size();
    }

    public double getOrderedMedian() {
        return arrayList.stream().mapToDouble(Integer::doubleValue).reduce(0, (initial, curr) ->{
            int quotient = (int) Math.round((double) arrayList.size() /2);
            if(arrayList.size()%2 == 0){
                return (double) (arrayList.get(quotient-1) + arrayList.get(quotient)) / 2;
            }
            else{
                return (double) arrayList.get(quotient-1);
            }
        });
    }

    public int getFirstEven() {
        return arrayList.stream().reduce(0, (initial, curr) ->{
            if(initial == 0) {
                if (curr % 2 == 0) {
                    return curr;
                }
            }
            return initial;
        });
    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(getFirstEven());
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.stream().reduce(1, (initial, curr) -> {
            try {
                if(arrayList.get(initial-1).equals(curr) && initial != 0){
                    return ++initial;
                }
                return 0;
            }catch (Exception e){
                return 0;
            }
        }) >= 1;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        return arrayList.stream().mapToDouble(Integer::doubleValue).reduce(0, (initial, curr) ->{
            int quotient = (int) Math.round((double) arrayList.size() /2);
            if(arrayList.size()%2 == 0){
                return (double) ((int)singleLink.getNode(quotient+1) + (int)singleLink.getNode(quotient)) / 2;
            }
            else{
                return Double.valueOf(singleLink.getNode(quotient).toString());
            }
        });
    }

    public int getLastOdd() {
        return arrayList.stream().reduce(0, (initial, curr) ->{
            if(curr%2 != 0){
                return curr;
            }
            return initial;
        });
    }

    public int getIndexOfLastOdd() {
        return arrayList.indexOf(getLastOdd());
    }
}
