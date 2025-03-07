package com.korotkov.dockertest;

import java.util.Scanner;

public class Calculator {
    private String operation;
    private Scanner scanner;

    public void calculate() {
        scanner = new Scanner(System.in);
        System.out.println("CALCULATOR");
        do {
            double a = getNumber("Enter number 1:");
            double b = getNumber("Enter number 2:");
            getOperation();
            switch (operation) {
                case "+" -> System.out.printf("%.3f%s%.3f = %.3f%n", a, operation, b, (a + b));
                case "-" -> System.out.printf("%.3f%s%.3f = %.3f%n", a, operation, b, (a - b));
                case "*" -> System.out.printf("%.3f%s%.3f = %.3f%n", a, operation, b, (a * b));
                case "/" -> System.out.printf("%.3f%s%.3f = %.3f%n", a, operation, b, (a / b));
            }
            System.out.println("\nDo you want to continue? [1 - yes]");
        } while ((scanner.nextLine()).trim().equals("1"));
        scanner.close();
    }

    private double getNumber(String message) {
        while (true) {
            try {
                System.out.println(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private void getOperation() {
        while (true) {
            System.out.println("Enter operation: [+, -, *, /]");
            operation = scanner.nextLine().trim();
            if (!operation.matches("[+\\-*/]")) {
                System.out.println("Please enter a valid operation!");
            } else break;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate();
    }
}