package org.codeship.ExceptionExample;

public class TryCatchFinallyExample {

    public static void main(String[] args) {
        try {
            int x = 10 / 0;
        }
        catch (ArithmeticException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("From finally block");
        }
    }
}
