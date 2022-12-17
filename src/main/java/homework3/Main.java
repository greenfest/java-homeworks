package homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        int[] array = getRandomArray();
//        System.out.println(Arrays.toString(array));
//        mergeSort(array, array.length);
//        System.out.println(Arrays.toString(array));

//        delEvenNum();

        searchItems();
    }

    /*
    * 1. Реализовать алгоритм сортировки слиянием
    */
    public static int[] getRandomArray() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public static void mergeSort(int[] src, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(src, 0, left, 0, mid);
        System.arraycopy(src, mid, right, 0, n - mid);

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(src, left, right, mid, n - mid);
    }
    public static void merge(int[] src, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) src[k++] = left[i++];
            else src[k++] = right[j++];
        }

        while (i < leftLength) {
            src[k++] = left[i++];
        }

        while (j < rightLength) {
            src[k++] = right[j++];
        }
    }

    /*
    * 2. Пусть дан произвольный список целых чисел, удалить из него четные числа
    */
    public static void delEvenNum() {
        Random random = new Random();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(0, 100);
            array.add(val);
        }
        System.out.printf("Первоначальный список: %s\n", array);
        for (int i = 0; i < array.size(); ) {
            if(array.get(i) % 2 == 0) {
                array.remove(i);
            } else {
                i++;
            }
        }
        System.out.printf("Список с удаленными четными числами: %s\n", array);
    }

    /*
    * 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
    */
    public static void searchItems() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(0, 100);
            array[i] = val;
        }
        System.out.printf("Массив: %s\n", Arrays.toString(array));
        int max = array[0];
        int min = array[0];
        for (Integer num : array) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int avg = Arrays.stream(array).sum() / array.length;
        System.out.println("Максимальное: " + max);
        System.out.println("Минимальное: " + min);
        System.out.println("Среднее: " + avg);
    }
}

