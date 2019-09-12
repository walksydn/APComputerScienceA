public class TimeDepositAccount extends SavingsAccount
{  public TimeDepositAccount(double rate, int maturity)
   {  super(rate);
      periodsToMaturity = maturity;
   }
 
   public void addInterest()
   {  periodsToMaturity--;
      super.addInterest();
   }

   public void withdraw(double amount)
   {  if (periodsToMaturity > 0) 
         super.withdraw(EARLY_WITHDRAWAL_PENALTY);
      super.withdraw(amount);
   }
    
   private int periodsToMaturity;
   private static double EARLY_WITHDRAWAL_PENALTY = 20;  
}
