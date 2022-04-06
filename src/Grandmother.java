public class Grandmother extends Thread {

    // Grandmother Name
    private String grandmotherName;

    // Student's bank account details
    private BankCurrentAccount studentBankAcount;

    //  The thread group it is in
    public Grandmother(ThreadGroup threadGroup, String threadName, BankCurrentAccount bankAccount){
        super(threadGroup, threadName);
        this.grandmotherName = threadName;
        this.studentBankAcount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("\n###################### " + this.grandmotherName + " starting to perform transactions" +
                "  #######################\n");

        // Deposit birthday money 25000 to student's account
        Transaction birthdayPresent = new Transaction(this.grandmotherName, 25000);
        studentBankAcount.deposit(birthdayPresent);

        // Sleep for a random amount of time between each transaction
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }

        // Deposit christmas gift 30000 to student's account
        Transaction christmasPresent = new Transaction(this.grandmotherName, 30000);
        studentBankAcount.deposit(christmasPresent);

        System.out.println("\n######################## " + this.grandmotherName + " terminating transactions " +
                "##########################\n");
    }
}
