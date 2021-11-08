package hk.edu.polyu.comp.comp2021.assignment4.bankaccount;

public class Withdrawer implements Runnable{
    private BankAccount ba;
    private int amount;

    public Withdrawer(BankAccount ba, int amount){
        this.ba = ba;
        this.amount = amount;
    }

    public void run() {
        // Note that a withdraw is only allowed when the
        // balance is greater than the amount to withdraw
        for (int i = 0; i < 10; i++){
            ba.withdraw(amount);       
        }
    }
}
