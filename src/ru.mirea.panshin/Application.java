package ru.mirea.panshin;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        int[] numberArray1;
        int[] numberArray2;

        int arrayLength;

        System.out.println("Введите размер массивов");

        Scanner scan = new Scanner(System.in);
        arrayLength = scan.nextInt();

        numberArray1 = new int[arrayLength];
        numberArray2 = new int[arrayLength];

        Random random = new Random();


        for (int i = 0; i < arrayLength; i++) {
            numberArray1[i] = random.nextInt(-200, 200);
            numberArray2[i] = random.nextInt(-200, 200);
        }
        Arrays.sort(numberArray1);
        Arrays.sort(numberArray2);

        System.out.println("Массив 1: " + Arrays.toString(numberArray1));
        System.out.println("Массив 2: " + Arrays.toString(numberArray2));


        findCommonElements(numberArray1, numberArray2);

    }

    public static void findCommonElements(int[] array1, int[] array2) {
        System.out.print("Совпадающие элементы: ");
        for (int i = 0; i < array1.length; i++) {
            myMethod(array2, array1[i]);
        }
        System.out.println();
    }

    public static void myMethod(int[] numberArray, int numToFind) {
        int low = 0;
        int high = numberArray.length - 1;
        int middle;

        while (low <= high) {
            middle = (low + high) / 2;

            int num = numberArray[middle];

            if (num == numToFind) {
                System.out.print(numberArray[middle] + " ");
                return;
            } else if (num > numToFind) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
    }
}
