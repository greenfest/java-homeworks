package homework4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        reverseList();
//        queue();
        calc();
    }

    /**
     * 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     */
    public static void reverseList() {
        LinkedList<Integer> linkList = createLinkedList();
        System.out.print("LinkedList до переворота: " + linkList);
        linkList = reverseLinkedList(linkList);
        System.out.print("\nПеревернутый LinkedList: " + linkList);
    }

    public static LinkedList<Integer> createLinkedList() {
        Random random = new Random();
        LinkedList<Integer> newLinkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            newLinkedList.add(random.nextInt(0,10));
        }
        return newLinkedList;
    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> revLinkedList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            revLinkedList.add(list.get(i));
        }
        return revLinkedList;
    }

    /**
     * 2. Реализуйте очередь с помощью LinkedList со следующими методами:
     * enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его,
     * first() - возвращает первый элемент из очереди, не удаляя.
     */

    public static void queue() {

        int[] list = {3, 5, 7, 2, 4, 6};

        LinkedList<Integer> linkList = new LinkedList<>();
        for (Integer temp : list) {
            linkList.add(temp);
        }

        System.out.println(linkList);

        enqueue(linkList, 9);
        System.out.println(linkList);

        System.out.println(dequeue(linkList));
        System.out.println(linkList);

        System.out.println(first(linkList));
    }

    public static void enqueue(LinkedList<Integer> list, int num) {
        list.addLast(num);
    }

    public static int dequeue(LinkedList<Integer> list) {
        int num;
        num = list.get(0);
        list.remove(0);
        return num;
    }

    public static int first(LinkedList<Integer> list) {
        int num;
        num = list.get(0);
        return num;
    }

    /**
     * 3. В калькулятор добавьте возможность отменить последнюю операцию.
     */
    private static void calc() {
        Deque<Double> queue = new LinkedList<>();
        boolean flag = true;
        while (flag) {
            double result = calculate();
            queue.addLast(result);
            System.out.println(queue);
            System.out.println("Для отмены операции введите 'cancel'");
            System.out.println("Для выхода введите 'exit'");
            System.out.println("Для продолжения введите любой символ");
            Scanner scanner = new Scanner(System.in);
            String back = scanner.next();

            if (back.equals("cancel")) {
                queue.pollFirst();
                System.out.println("Операция отменена!");
            }
            if (back.equals("exit")) {
                flag = false;
            }
        }
    }

    public static double calculate() {
        double num1;
        double num2;
        String operation;

        Scanner input = new Scanner(System.in);

        System.out.println("Пожалуйста, введите первое число: ");
        try {
            num1 = input.nextDouble();
        } catch (Exception e) {
            System.out.println("Ошибка ввода данных");
            return 0;
        }

        System.out.println("Пожалуйста, введите второе число: ");
        try {
            num2 = input.nextDouble();
        } catch (Exception e) {
            System.out.println("Ошибка ввода данных");
            return 0;
        }

        Scanner op = new Scanner(System.in);
        System.out.println("Пожалуйста, введите операцию (+, -, /, *)");
        operation = op.next();

        return switch (operation) {
            case "+" -> (num1 + num2);
            case "-" -> (num1 - num2);
            case "/" -> (num1 / num2);
            case "*" -> (num1 * num2);
            default -> 0;
        };
    }
}
