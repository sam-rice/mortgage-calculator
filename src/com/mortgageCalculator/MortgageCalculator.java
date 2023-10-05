package com.mortgageCalculator;

public class MortgageCalculator {
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getMonths();

        return principal *
                ((monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
                        / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1));
    }

    public double calculateBalance(short month) {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getMonths();

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, month))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double[] getRemainingPayments() {
        var payments = new double[getMonths()];
        for (short month = 1; month <= payments.length; month++) {
            payments[month - 1] = calculateBalance(month);
        }
        return payments;
    }

    private int getMonths() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }
}
