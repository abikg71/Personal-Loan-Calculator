import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        
        System.out.println("Loan amount: ");
        String loanAmount = in.readLine();
        double loan = Double.parseDouble(loanAmount);
                
        System.out.println("Loan term in years: ");
        String termInYears = in.readLine();
        int term = Integer.parseInt(termInYears);
        
        System.out.println("Interest rate per year: ");
        String annualRate = in.readLine();
        double rate = Double.parseDouble(annualRate);
        
        System.out.println("Downpayment: ");
        String downPayment = in.readLine();
        double downPay = Double.parseDouble(downPayment);
        System.out.println();
        
        double monthlyPayment = calculateMonthlyPayment(loan, term, rate, downPay);
        double totalInterestAccrued = calculateInterestAccrued(monthlyPayment, loan, downPay, term);
        
        System.out.println("Monthly Payment: ");
        System.out.print("$");
        System.out.printf("%.2f", monthlyPayment);
        System.out.println();
        System.out.println("Total Accrued Interest: ");
        System.out.println("$" + (int)Math.round(totalInterestAccrued));
    }
    
    public static double calculateMonthlyPayment(double loan, int term, double rate, double downPay )
    {
        double monthlyRate = (rate/100.0) / 12;
        int termsInMonths = term * 12;
        loan -= downPay;
        double monthlyPayment = (monthlyRate * loan)/(1-Math.pow((1+monthlyRate), -termsInMonths));
        return monthlyPayment;
    }
    
    public static double calculateInterestAccrued(double monthlyPayment, double loan, double downPay, int term)
    {
        int termsInMonths = term * 12;
        loan -= downPay;
        double totalCost = monthlyPayment * termsInMonths;
        double totalInterestAccrued = totalCost - loan;
        return totalInterestAccrued;
    }
    
}
