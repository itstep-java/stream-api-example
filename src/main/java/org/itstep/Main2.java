package org.itstep;

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Integer> collection = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            collection.add(i);
        }

        collection.stream()
            .map(i -> i + 1)
            .peek(System.out::println)
//            .sorted(Comparator.reverseOrder())
            .map(i -> i - 1)
            .peek(i -> System.out.println(i + "!"))
            .reduce((a, b) -> a + b);
    }

    public static void main2(String[] args) {
        ArrayList<String> collection = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            String[] element = new String[10];

            for (int j = 0; j < 10; j ++) {
                element[j] = String.valueOf(random.nextInt(100));
            }

            String full = Arrays.toString(element).substring(1);
            full = full.substring(0, full.length() - 1);
            collection.add(full);
        }

        collection.forEach(System.out::println);

        System.out.println("=============================");

        List<Integer> list = collection.stream()
            .flatMapToInt(
                i -> Arrays.stream(i.split(", "))
                    .mapToInt(Integer::parseInt)
            )
            .boxed()
            .limit(10)
            .peek(System.out::println)
            .collect(Collectors.toList());

        System.out.println("===============");

        collection.stream()
            .peek(System.out::println)
            .findFirst();

        System.out.println("=========================");

        System.out.println(collection.size());
        System.out.println(list.size());
    }
}
