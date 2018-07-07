# Personal Loan Calculator
The program calculates monthly payments on a loan. It prints out monthly payments and total interest on a loan for the duration of a loan's term. User needs to provide loan amount, term and interest rate. 

## Getting Started

## Formula
<img src="Loan Payment Formula.gif" width="150" align="left">

```
    public static double calculateMonthlyPayment(double loan, int term, double rate, double downPay )
    {
        double monthlyRate = (rate/100.0) / 12;
        int termsInMonths = term * 12;
        loan -= downPay;
        double monthlyPayment = (monthlyRate * loan)/(1-Math.pow((1+monthlyRate), -termsInMonths));
        return monthlyPayment;
    }
```

## Usage
To compile the file:
```diff
javac LoanCalc.java
```
To run the file:
```diff
java LoanCalc
```
