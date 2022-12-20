package homework4;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        reverseList();
        queue();
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
}
