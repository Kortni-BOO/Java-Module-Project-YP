import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        start();
    }

    public static void start() {

        while (true) {
            System.out.println("На сколько человек вы хотите разделить счет? Ввод целое число.");
            try {
                int count = scanner.nextInt();
                scanner.nextLine();

                if(count < 1) {
                    showErrorMessage();
                } else if(count == 1) {
                    break;
                } else {
                    //создать калькулятор
                    Calculator calculator = new Calculator(count);
                    calculator.addProduct();
                    break;
                }
            } catch (InputMismatchException e) {
                showErrorMessageNumber();
                scanner.nextLine(); // очистить буфер ввода
            }
        }

    }

    private static void showErrorMessage() {
        System.out.println("Число не может быть отрицательным.");
    }

    private static void showErrorMessageNumber() {
        System.out.println("Ввод только целое число.");
    }
}