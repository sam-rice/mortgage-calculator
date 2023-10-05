package com.mortgageCalculator;

public class Main {

    public static void main(String[] args) throws Exception {
        int principal = (int) CLI.readNumber("Principal", 1000, 1_000_000);
//    int downPayment = (int) CLI.readNumber("Down Payment", 0, principal);
        float annualInterest = (float) CLI.readNumber("Annual Interest Rate", .01, 30);
        byte years = (byte) CLI.readNumber("Period (Years)", 0, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }
}