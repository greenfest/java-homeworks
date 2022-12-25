package homework5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        phone();
//        getDuplicates();
//        sort();
//        start();
    }

    /*
    * 1. Реализуйте структуру телефонной книги с помощью HashMap,
    * учитывая, что 1 человек может иметь несколько телефонов.
    */
    public static void phone() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", List.of("+7(111)111-11-11", "+7(222)222-22-22"));
        phoneBook.add("Петров", List.of("+7(222)333-44-55", "+7(112)221-22-66"));
        System.out.printf("%s: %s", "Петров", phoneBook.find("Петров"));
    }

    /*
    * 2. Пусть дан список сотрудников: ...
    * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    * Отсортировать по убыванию популярности.
    */
    public static void getDuplicates() {
        Map<String, Integer> nameMap = new HashMap<>();
        String employees = "Иван Иванов " +
                "Светлана Петрова " +
                "Кристина Белова " +
                "Анна Мусина " +
                "Анна Крутова " +
                "Иван Юрин " +
                "Петр Лыков " +
                "Павел Чернов " +
                "Петр Чернышов " +
                "Мария Федорова " +
                "Марина Светлова " +
                "Мария Савина " +
                "Мария Рыкова " +
                "Марина Лугова " +
                "Анна Владимирова " +
                "Иван Мечников " +
                "Петр Петин " +
                "Иван Ежов ";
        String[] listOfNamesAndSurnames = employees.split(" ");
        for (int i = 0; i < listOfNamesAndSurnames.length; i += 2) {
            if (nameMap.containsKey(listOfNamesAndSurnames[i])) {
                nameMap.replace(listOfNamesAndSurnames[i], nameMap.get(listOfNamesAndSurnames[i]) + 1);
            } else {
                nameMap.put(listOfNamesAndSurnames[i], 1);
            }
        }
        Map<String, Integer> sortedNameMap = new LinkedHashMap<>();
        int max = 1;
        for (int value : nameMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
                String key = entry.getKey();
                if (nameMap.get(key) == i) {
                    sortedNameMap.put(key, nameMap.get(key));
                }
            }
        }
        System.out.println(sortedNameMap);
    }

    /*
    * 3. Реализовать алгоритм пирамидальной сортировки (HeapSort).
    */
    public static void sort() {
        int[] arr = { 5, 7, 15, 11, 9, 25 };
        toSort(arr);
        printArray(arr);
    }

    public static void toSort(int[] arr) {
        int N = arr.length;

        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        for (int i = N - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[largest])
            largest = l;

        if (r < N && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }

    public static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    /*
    * 4. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
    */
    public static class Queen {
        int x, y;
        static int count = 0;

        public Queen(Board board) {
            while (true) {
                Random rnd = new Random();
                int x = rnd.nextInt(8);
                int y = rnd.nextInt(8);
                if (board.cell[x][y] == 0) {
                    this.x = x;
                    this.y = y;
                    count++;
                    break;
                }
            }
        }
    }

    public static class Board {
        int size;
        int[][] cell;

        public Board(int size) {
            this.size = size;
            this.cell = new int[this.size][this.size];
        }

        public void addQueen(Queen queen, int index) {
            this.cell[queen.x][queen.y] = index + 2;
            for (int i = 1; i < 8; i++) {
                int x = queen.x;
                int y = queen.y;
                if ((x + i) < 8 && (y + i) < 8 && (x + i) >= 0 && (y + i) >= 0 && this.cell[x + i][y + i] == 0) {
                    this.cell[x + i][y + i] = 1;
                }
                if ((x + i) < 8 && (y - i) < 8 && (x + i) >= 0 && (y - i) >= 0 && this.cell[x + i][y - i] == 0) {
                    this.cell[x + i][y - i] = 1;
                }
                if ((y + i) < 8 && (y + i) >= 0 && this.cell[x][y + i] == 0) {
                    this.cell[x][y + i] = 1;
                }
                if ((y - i) < 8 && (y - i) >= 0 && this.cell[x][y - i] == 0) {
                    this.cell[x][y - i] = 1;
                }
                if ((x - i) < 8 && (y + i) < 8 && (x - i) >= 0 && (y + i) >= 0 && this.cell[x - i][y + i] == 0) {
                    this.cell[x - i][y + i] = 1;
                }
                if ((x - i) < 8 && (y - i) < 8 && (x - i) >= 0 && (y - i) >= 0 && this.cell[x - i][y - i] == 0) {
                    this.cell[x - i][y - i] = 1;
                }
                if ((x + i) < 8 && (x + i) >= 0 && this.cell[x + i][y] == 0) {
                    this.cell[x + i][y] = 1;
                }
                if ((x - i) < 8 && (x - i) >= 0 && this.cell[x - i][y] == 0) {
                    this.cell[x - i][y] = 1;
                }
            }
        }

        public boolean checkBoard() {
            for (int[] row : this.cell) {
                for (int elem : row) {
                    if (elem == 0) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void print() {
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    if (this.cell[j][i] == 0 || this.cell[j][i] == 1) {
                        System.out.print(" - ");
                    } else {
                        System.out.printf(" %d ", this.cell[j][i] - 1);
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void start() {
        int size = 8;
        Board board = new Board(size);
        nextTurn(board);
    }

    public static void nextTurn(Board board) {
        Queen[] queens = new Queen[8];
        for (int i = 0; i < 8; i++) {
            if (board.checkBoard()) {
                start();
                return;
            }
            queens[i] = new Queen(board);
            board.addQueen(queens[i], i);
        }
        board.print();
    }

}
