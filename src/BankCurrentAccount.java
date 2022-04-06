public class BankCurrentAccount implements BankAccount {


    private String accountHolder;
    private int accountNumber;
    private int balance;
    private Statement bankStatement;

    public BankCurrentAccount(int accountNumber, String accountHolder, int balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.bankStatement = new Statement(accountHolder, accountNumber);
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public int getAccountNumber() {

        return this.accountNumber;
    }

    @Override
    public String getAccountHolder() {

        return this.accountHolder;
    }

    @Override
    public synchronized void deposit(Transaction transaction) {
        // Checks if deposit is 0 or less than 0
        if(transaction.getAmount() <= 0){
            System.out.println("Invalid Deposit Amount");
        }
        else {
            // Updates the student's bank account with deposit amount
            this.balance += transaction.getAmount();

            // Updates the bank statement
            this.bankStatement.addTransaction(transaction.getCID(), transaction.getAmount(), this.balance);
            System.out.println("Amount DepositED Successfully");

            // Wakes up all threads that are waiting for a deposit
            notifyAll();
        }
    }

    @Override
    public synchronized void withdrawal(Transaction transaction) {

        // Checks if withdrawal is 0 or less than 0
        if (transaction.getAmount() <= 0) {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx INVALID WITHDRAWAL AMOUNT xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }

        while (this.balance < transaction.getAmount()) {
            System.out.println("Insufficient account balance remaining for a withdrawal of " + transaction.getAmount()
                    + " . Waiting for deposit(s)...\n");
            try {
                System.out.println("[Student CurrentAccount]: Withdrawing of " + transaction.getAmount() + " by " +
                        transaction.getCID() + " unsuccessful. Please wait until funds are available...");
                wait();
            } catch (InterruptedException e) { }
        }

        // Checks if the account has sufficient amount for withdrawal
        if (this.getBalance() >= transaction.getAmount()) {
            // Updates student's account balance after a withdrawal
            this.balance -= transaction.getAmount();
            this.bankStatement.addTransaction(transaction.getCID(), transaction.getAmount(), this.balance);
            System.out.println("------------------------------ WITHDRAWAL MADE SUCCESSFULLY -------------------" +
                    "---------\n");
        }
    }

    @Override
    public boolean isOverdrawn() {
        /* When money is withdrawn from a bank account and the available balance
           goes below zero. */
        return this.getBalance() < 0;
    }

    @Override
    public void printStatement() {
        /* Prints out the transactions performed or after all the threads have
         terminated, it prints out the final statement for the student's bank account.*/
        this.bankStatement.print();
    }
}
