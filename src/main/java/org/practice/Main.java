package org.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[] arr={5,9,11,2,8,21,1};

        String[] arr2={"gkp","abhi"};

        Optional<String> first = Arrays.stream(arr2).sorted(Comparator.reverseOrder()).skip(1).findFirst();
        first.ifPresent(System.out::println);

        Integer i = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println(i);

        String name="GulabKumar";

        String[] split = name.split("");

        Map<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        String key = collect.entrySet().stream().filter(x -> x.getValue() > 1).findFirst().get().getKey();

        System.out.println(key);

    }
}
