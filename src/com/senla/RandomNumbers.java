package com.senla;

public class RandomNumbers {

    public static String RandomAndLargeNum() {
        System.out.println("First.");
        int i = (int) (100 + Math.random() * 900);
        String str = "Random number: " + i;
        int max = 0;
        while (i != 0) {
            if (max < i % 10)
                max = i % 10;
            i /= 10;
        }
        str += " Largest number:" + max;
        return str;
    }

    public static void RandomAndFirstAmount() {
        System.out.println("Second.");
        int amount = 0;
        for (int i = 0; i < 3; i++) {
            int j = (int) (100 + Math.random() * 900);
            System.out.println((i + 1) + " number:" + j);
            j = j /= 100;
            amount += j;
        }
        System.out.println("Amount of the firsts digits:" + amount);
    }


    public static void RandomAndDifference() {
        System.out.println("Third.");
        StringBuilder stringBuilder = new StringBuilder();
        int j = 0, difference = 0;
        for (int i = 0; i < 3; i++) {
            j = (int) (100 + Math.random() * 900);
            System.out.println((i + 1) + " number:" + j);
            if (i == 2) break;
            stringBuilder.append(j);
        }
        difference = Integer.parseInt(stringBuilder.toString()) - j;
        System.out.println("Difference:" + difference);
    }

    public static void RandomAndAmount() {
        System.out.println("Fourth.");
        int amount = 0;
        int i = (int) (100 + Math.random() * 900);
        System.out.println("Number:" + i);
        while (i != 0) {
            amount += i % 10;
            i /= 10;
        }
        System.out.println("Amount of the firsts digits:" + amount);
    }
}

