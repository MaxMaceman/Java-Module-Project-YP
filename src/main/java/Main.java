import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons;

        while (true) {
            System.out.println("На скольких человек необходимо разделить счет?");
            if (scanner.hasNextInt()) {
                persons = scanner.nextInt();
                if (persons > 1) // Введеное значение должно быть целым числом больще 1
                    break;
                else {
                    System.out.println("Ошибка:\n" + "Введенное значение должно быть больше 1-го!");
                }
            } else {
                System.out.println("Ошибка:\n" + "Введенное значение должно быть целым числом!");
                scanner.next();
            }
        }

        Calculator calculator = new Calculator(persons);
        calculator.start();
    }
}