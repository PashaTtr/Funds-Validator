package app;

// Кастомний виняток
public class FundsException extends Exception {

    public FundsException(String message) {
        super(message); // Передаємо повідомлення у батьківський клас Exception
    }
}
