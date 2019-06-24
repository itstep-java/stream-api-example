package org.itstep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Human> peoples = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            peoples.add(
                new Human(
                    random.nextInt(65) + 1,
                    random.nextBoolean() ? Gender.MALE : Gender.FEMALE
                )
            );
        }

//        peoples.stream()
//            .filter(
//                human -> human.getGender().equals(Gender.MALE)
//                    && human.getAge() >= 18
//                    && human.getAge() <= 27
//            ).peek(System.out::println)
//            .collect(Collectors.toList());

        peoples.stream()
//            .map(
//                human -> { human.setAge(human.getAge() + 1); return human; }
//            )
            .peek(human -> human.setAge(human.getAge() + 1))
            .filter(
                human -> human.getAge() >= 18
                    && (human.getAge() <= 55
                        || (human.getGender().equals(Gender.MALE)
                            && human.getAge() <= 60
                        )
                    )
            )
            .distinct()
            .peek(System.out::println)
            .collect(Collectors.toSet());
    }

    public static void main3(String[] args) {
        example(Cat::new);
    }

    private static void example(Supplier<Cat> s) {
        Cat cat = s.get();
        cat.meow();
    }

    public static void main2(String[] args) {
        Random random = new Random();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(random.nextInt(100)));
        }

        System.out.println(list.size());
        System.out.println("================");

        list.stream()
            // Конвеерные методы
            .filter(i -> Integer.parseInt(i) % 2 != 0)
            .limit(10)
            .peek(System.out::println)
            // Терминальный
            .collect(Collectors.toList());

        System.out.println("================");

//        try (Stream<String> stream = list.stream()) {
//            stream
//                .filter(i -> i.startsWith("1"))
//                .peek(System.out::println)
//                .findAny();
//        }

        List<String> list2 = list.stream()
            .map(i -> i + "!")
            .limit(10)
//            .peek(i -> i = i + "!")
            .peek(System.out::println)
            .collect(Collectors.toList());

        System.out.println("---------------------");

        list2.stream().peek(System.out::println).collect(Collectors.toList());
    }
}
