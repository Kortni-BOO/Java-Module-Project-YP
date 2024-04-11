import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    int countPerson;
    ArrayList<Product> productList = new ArrayList<>();

    Calculator(int countPerson) {
        this.countPerson = countPerson;
    }


    /*   МЕТОДЫ   */
    //Добавить товар
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Введите название товара или 'Завершить':");
            String name = scanner.nextLine();
            if(name.equalsIgnoreCase("завершить")) {
                executePrint();
                System.out.println("Сумма для каждого человека: " + formatAmount(getSum(countPerson)));
                break;
            }

            double count = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Введите цену товара (в формате рубли,копейки):");
                    count = scanner.nextDouble();
                    scanner.nextLine();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите цену товара заново.");
                    scanner.nextLine(); // Очистить буфер ввода
                }
            }

            Product product = new Product(name, count);
            productList.add(product);
            System.out.println("Товар успешно добавлен.");


        }
    }

    //Вывод всех товаров
    private void executePrint() {
        System.out.println("Добавленные товары:");
        for (Product product : productList) {
            System.out.println("Продукт '" + product.name + "'");
        }
    }

    //Вывод суммы для каждого человека
    public double getSum(int count) {
        double priceTotal = 0;
        for(int i = 0; i < productList.size(); i++) {
            priceTotal += productList.get(i).price;
        }
        return priceTotal/count;
    }

    public static String formatAmount(double amount) {

        return String.format("%.2f руб%s", amount,
                    (amount % 10 == 1 && amount % 100 != 11) ? "ль"
                            : (amount % 10 >= 2 && amount % 10 <= 4
                            && (amount % 100 < 10 || amount % 100 >= 20)) ? "ля" : "лей");
    }

}
