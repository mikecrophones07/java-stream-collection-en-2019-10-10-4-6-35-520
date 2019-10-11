package com.thoughtworks.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class CollectionOperatorTest {

    @Test
    public void should_return_list_by_Interval() {
        //Select all the numbers in a given interval

        int right = 5;
        int left = 1;

        CollectionOperator collectionOperator = new CollectionOperator();

        Integer[] result = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> resultList = Arrays.asList(result);
        assertThat(collectionOperator.getListByInterval(left, right)).isEqualTo(resultList);

        Integer[] inverseResult = new Integer[]{5, 4, 3, 2, 1};
        List<Integer> inverseResultList = Arrays.asList(inverseResult);
        assertThat(collectionOperator.getListByInterval(right, left)).isEqualTo(inverseResultList);
    }

    @Test
    public void should_return_list_by__two_Intervals() {
        //Select all even numbers in a given interval
        int right = 10;
        int left = 1;

        CollectionOperator collectionOperator = new CollectionOperator();

        Integer[] result = new Integer[]{2, 4, 6, 8, 10};
        List<Integer> resultList = Arrays.asList(result);
        assertThat(collectionOperator.getEvenListByIntervals(left, right)).isEqualTo(resultList);

        Integer[] inverseResult = new Integer[]{10, 8, 6, 4, 2};
        List<Integer> inverseResultList = Arrays.asList(inverseResult);
        assertThat(collectionOperator.getEvenListByIntervals(right, left)).isEqualTo(inverseResultList);
    }

    @Test
    public void should_pop_even_elements() {
    //Select all even numbers in a given interval
        int[] array = new int[]{1, 2, 3, 4, 5};

        Integer[] result = new Integer[]{2, 4};
        List<Integer> resultList = Arrays.asList(result);

        CollectionOperator collectionOperator = new CollectionOperator();

        assertThat(collectionOperator.popEvenElments(array)).isEqualTo(resultList);
    }

    @Test
    public void should_pop_last_element() {
        //Pop the last element of the collection
        int[] array = new int[]{1, 2, 3, 4, 5};

        CollectionOperator collectionOperator = new CollectionOperator();

        assertThat(collectionOperator.popLastElment(array)).isEqualTo(5);
    }

    @Test
    public void should_pop_common_elements() {
        //Pops up the intersection of two arrays
        int[] firstArray = new int[]{1, 2, 4, 6, 10};
        int[] secondArray = new int[]{3, 2, 6, 10, 8};

        Integer[] result = new Integer[]{2, 6, 10};
        List<Integer> resultList = Arrays.asList(result);

        CollectionOperator collectionOperator = new CollectionOperator();
        assertThat(collectionOperator.popCommonElement(firstArray, secondArray)).isEqualTo(resultList);
    }

    @Test
    public void should_add_uncommon_elements_to_first_array() {
        // Add a different element from the array two to the array one
        Integer[] firstArray = new Integer[]{1, 2, 4, 6, 10};
        Integer[] secondArray = new Integer[]{3, 2, 6, 10, 8};

        Integer[] result = new Integer[]{1, 2, 4, 6, 10, 3, 8};
        List<Integer> resultList = Arrays.asList(result);

        CollectionOperator collectionOperator = new CollectionOperator();
        assertThat(collectionOperator.addUncommonElement(firstArray, secondArray).size()).isEqualTo(7);
        assertThat(collectionOperator.addUncommonElement(firstArray, secondArray)).isEqualTo(resultList);
    }
}
