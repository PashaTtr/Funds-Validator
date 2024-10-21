package app;

import java.util.Scanner;

public class Main {

    static double balance;

    public static void main(String[] args) {
        // Ініціалізація балансу
        balance = getBalance();
        balance = validateAmount(balance, getAmount());
    }

    // Отримання початкового балансу
    private static double getBalance() {
        return 1000.00; // Наявні кошти на рахунку
    }

    // Отримання суми покупки від користувача
    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%nEnter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // Метод валідації наявних коштів
    private static double validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println(ex.getMessage());
                return balance; // Якщо недостатньо коштів, повертаємо поточний баланс
            }
        } else {
            balance = getNewBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid.%nBalance is USD %.2f%n", balance);
            return balance; // Повертаємо новий баланс після покупки
        }
    }

    // Метод обчислення нового балансу після зняття суми
    private static double getNewBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
