package Odev2.PolymorphismDemo;

public class ConsoleLogger extends BaseLogger{

    public void log(String message) {
        System.out.println("Logged to console : " + message);
    }
}
