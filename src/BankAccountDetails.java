public class BankAccountDetails {

    public static void main(String[] args) {

        // ===== Primitive Data Types =====
        byte creditScore = 87;
        short accountOpeningYear = 2019;
        int accountNumber = 123456789;
        long ifscLookupCode = 123456789012L;
        float monthlyInterestRate = 0.5f;
        double accountBalance = 250000.75;
        boolean isNetBankingEnabled = true;
        char accountType = 'S';

        // ===== Reference Types =====
        String accountHolderName = "Your Name";
        String bankName = "State Bank of India";
        String branchName = "Kukatpally Branch";

        // ===== Constants =====
        final int MINIMUM_BALANCE = 1000;
        final double ANNUAL_INTEREST_RATE = 6.0;
        final String BANK_CODE = "SBI001";

        // ===== var Keyword =====
        var interestPerMonth = accountBalance * monthlyInterestRate / 100;
        var annualInterest = accountBalance * ANNUAL_INTEREST_RATE / 100;
        var balanceAfterOneYear = accountBalance + annualInterest;

        // ===== Type Casting =====
        int floorBalance = (int) accountBalance;
        long accountNumAsLong = accountNumber;

        // ===== Wrapper Classes =====
        String maskedAccount = Integer.toString(accountNumber);
        String balanceAsText = Double.toString(accountBalance);

        System.out.println("Maximum Integer Value: " + Integer.MAX_VALUE);

        // ===== Bank Statement =====
        System.out.println("\n==============================================");
        System.out.println("           BANK ACCOUNT STATEMENT");
        System.out.println("==============================================");

        System.out.printf("%-25s : %s%n", "Bank Name", bankName);
        System.out.printf("%-25s : %s%n", "Branch Name", branchName);
        System.out.printf("%-25s : %s%n", "Bank Code", BANK_CODE);
        System.out.printf("%-25s : %s%n", "Account Holder", accountHolderName);
        System.out.printf("%-25s : %s%n", "Account Number", accountNumber);
        System.out.printf("%-25s : %d%n", "Opening Year", accountOpeningYear);
        System.out.printf("%-25s : %c%n", "Account Type", accountType);
        System.out.printf("%-25s : %d%n", "Credit Score", creditScore);
        System.out.printf("%-25s : %b%n", "Net Banking Enabled", isNetBankingEnabled);

        System.out.println("----------------------------------------------");

        System.out.printf("%-25s : %.2f%n", "Account Balance", accountBalance);
        System.out.printf("%-25s : %.2f%%%n", "Monthly Interest Rate", monthlyInterestRate);
        System.out.printf("%-25s : %.2f%%%n", "Annual Interest Rate", ANNUAL_INTEREST_RATE);
        System.out.printf("%-25s : %.2f%n", "Monthly Interest", interestPerMonth);
        System.out.printf("%-25s : %.2f%n", "Annual Interest", annualInterest);
        System.out.printf("%-25s : %.2f%n", "Balance After 1 Year", balanceAfterOneYear);

        System.out.println("----------------------------------------------");

        System.out.printf("%-25s : %d%n", "Floor Balance", floorBalance);
        System.out.printf("%-25s : %d%n", "Account No as Long", accountNumAsLong);
        System.out.printf("%-25s : %s%n", "Account String", maskedAccount);
        System.out.printf("%-25s : %s%n", "Balance String", balanceAsText);
        System.out.printf("%-25s : %d%n", "Minimum Balance", MINIMUM_BALANCE);
        System.out.printf("%-25s : %d%n", "IFSC Lookup Code", ifscLookupCode);

        System.out.println("==============================================");
    }
}