package com.mortgageCalculator;

public class Main {

    public static void main(String[] args) throws Exception {
        int principal = (int) Console.readNumber("Principal", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate", .01, 30);
        byte years = (byte) Console.readNumber("Period (Years)", 1, 30);

        var calculator = new MortgageCalculator2023(principal, annualInterest, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }
}