package com.mortgageCalculator;

public class MortgageCalculator2023 implements MortgageCalculator {
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private final int principal;
    private final float annualInterest;
    private final byte years;

    public MortgageCalculator2023(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    @Override
    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getMonths();

        return principal *
                ((monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
                        / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1));
    }

    @Override
    public double[] getRemainingPayments() {
        var payments = new double[getMonths()];
        for (short month = 1; month <= payments.length; month++) {
            payments[month - 1] = calculateBalance(month);
        }
        return payments;
    }

    private double calculateBalance(short month) {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getMonths();

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, month))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    private int getMonths() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }
}
