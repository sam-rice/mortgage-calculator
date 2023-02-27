package com.mortgageCalculator;
  
import java.text.NumberFormat;
                  
public class MortgageReport {
  private final NumberFormat currency;
  private MortgageCalculator calculator;

  public MortgageReport(MortgageCalculator calculator) {
    this.calculator = calculator;
    this.currency = NumberFormat.getCurrencyInstance();
  }

  public void printMortgage() {
    double mortgage = calculator.calculateMortgage();
    System.out.println();
    System.out.println("MORTGAGE");
    System.out.println("----------");
    System.out.println("Monthly Payments: " + currency.format(mortgage));
  }

  public void printPaymentSchedule() {
    System.out.println();
    System.out.println("PAYMENT SCHEDULE");
    System.out.println("----------");
    for (double payment: calculator.getRemainingPayments()) {
      System.out.println(currency.format(payment));
    }
  }
}
