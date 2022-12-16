package homework1;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
//        getFactorialAndTriangle();
//        getPrimeNumbers();
        calc();

    }

    /*
        1. Вычислить n-ое треугольного число(сумма чисел от 1 до n),
        n! (произведение чисел от 1 до n)
    */
    public static void getFactorialAndTriangle() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int num = in.nextInt();
        System.out.printf("Треугольное число: %d \nФакториал числа n: %d \n", triangle(num), getFactorial(num));
        in.close();
    }

    public static int triangle(int n) {
        if(n==1) {
            return 1;
        }
        else {
            return (n + triangle(n - 1));
        }
    }

    public static int getFactorial(int f) {
        if (f==1) {
            return 1;
        }
        else {
            return (f * getFactorial(f - 1));
        }
    }

    //2. Вывести все простые числа от 1 до 1000

    public static void getPrimeNumbers() {
        System.out.print("Простые числа от 1 до 1000: \n");
        for (int i = 2; i < 1001; i++) {
            if (isPrime(i)){
                System.out.printf(i + ",");
            }
        }
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    //3. Реализовать простой калькулятор

    public static void calc()
    {
        double num1;
        double num2;
        String operation;

        Scanner input = new Scanner(System.in);

        System.out.println("Пожалуйста введите первое число: ");
        num1 = input.nextDouble();

        System.out.println("Пожалуйста введите второе число: ");
        num2 = input.nextDouble();

        Scanner op = new Scanner(System.in);

        System.out.println("Пожалуйста, введите операцию (+, -, /, *)");
        operation = op.next();

        if (operation.equals("+"))
        {
            System.out.println("Ваш ответ = " + (num1 + num2));
        }
        if  (operation.equals("-"))
        {
            System.out.println("Ваш ответ = " + (num1 - num2));
        }

        if (operation.equals("/"))
        {
            System.out.println("Ваш ответ = " + (num1 / num2));
        }
        if (operation.equals("*"))
        {
            System.out.println("Ваш ответ = " + (num1 * num2));
        }
    }



}
