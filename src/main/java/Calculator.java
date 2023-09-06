import java.util.Scanner;
import java.util.ArrayList;

class Calculator {
    private final int persons; // Добавил модификатор

    public Calculator(int persons) {
        this.persons = persons;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
            ArrayList<Product> allProductCost = new ArrayList<>();

        parentLoop:
        while (true) { // Для ревью разбивать не стал, боюсь всё поломать =), но в качестве факультатива разломаю на методы
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
                        System.out.println("Добавлен товар:\n" + product + " - " + Formatter.chooseRublesWord(cost));
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
                    continue; // Убрал лейбл "childLoop"
                }
            }
        }

        double totalCost = 0.0;
        for (Product item : allProductCost) {
            System.out.println(item);
            totalCost += item.getPrice();
        }

        double costPerPerson = totalCost / persons;
        System.out.println("Всего:\n" + Formatter.chooseRublesWord(totalCost));
        System.out.println("Каждый должен заплатить по:\n" + Formatter.chooseRublesWord(costPerPerson));
    }
}

// ༼ つ ◕_◕ ༽つ
