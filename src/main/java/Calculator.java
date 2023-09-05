import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " - " + new DecimalFormat("0.00").format(price) + " рубля";
    }
}

class Calculator {
    private int persons;

    public Calculator(int persons) {
        this.persons = persons;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> allProductCost = new ArrayList<>();

        parentLoop:
        while (true) {
            System.out.println("Введите наименование товара.");
            String product = scanner.nextLine();

            if (product == null || product.isEmpty() || !product.matches("\\p{L}*")) {
                System.out.println("Ошибка:\nНаименование товара должно содержать только буквы.");
                continue;
            }

            double cost = 0.0;
            boolean validCost = false;

            while (!validCost) {
                try {
                    System.out.println("Введите стоимость товара в формате - \"рубли.копейки\".");
                    cost = Double.parseDouble(scanner.nextLine());

                    if (cost > 0) {
                        validCost = true;
                        System.out.println("Добавлен товар:\n" + product + " - " + new DecimalFormat("0.00").format(cost) + " рубля.");
                    } else {
                        System.out.println("Ошибка:\nСумма должна быть больше нуля.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка:\nСумма может быть указана только в цифрах.\nПример - 12.13.");
                }
            }

            Product item = new Product(product, cost);
            allProductCost.add(item);

            childLoop:
            while (true) {
                System.out.println("Хотите добавить еще один товар? (Да/Завершить)");
                String anotherOne = scanner.nextLine();

                if (anotherOne.equalsIgnoreCase("Да")) {
                    continue parentLoop;
                } else if (anotherOne.equalsIgnoreCase("Завершить")) {
                    System.out.println("Добавленные товары:");
                    break parentLoop;
                } else {
                    System.out.println("Ошибка:\nВы ввели неверное значение." + "\nВведите команду \"Завершить\" чтобы выполнить расчет.");
                    continue childLoop;
                }
            }
        }

        double totalCost = 0.0;
        for (Product item : allProductCost) {
            System.out.println(item);
            totalCost += item.getPrice();
        }

        double costPerPerson = totalCost / persons;
        System.out.println("Всего:\n" + new DecimalFormat("0.00").format(totalCost) + " рублей.");
        System.out.println("Каждый должен заплатить по:\n" + new DecimalFormat("0.00").format(costPerPerson) + " рублей.");
    }
}