public class StudentLoanCompany  extends Thread{

    // Company Name
    private String companyName;

    // Student's bank account details
    private BankCurrentAccount studentBankAcount;

    //  The thread group it is in
    public StudentLoanCompany(ThreadGroup threadGroup, String threadName, BankCurrentAccount bankAccount){
        super(threadGroup, threadName);
        this.companyName = threadName;
        this.studentBankAcount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("\n######################### " + companyName + " starting to perform transactions " +
                "#####################\n");

        int numberOfDeposits = 3;

        // 3 student loan deposits into the student's bank account
        for (int i = 0; i < numberOfDeposits; i++) {

            // Deposits loan amount in student's account
            Transaction loan = new Transaction(this.companyName, 62000);
            studentBankAcount.deposit(loan);

            // Sleep for a random amount of time between each transaction
            try {
                sleep( (int)(Math.random() * 100) ) ;
            }
            catch (InterruptedException e) { }
        }

        System.out.println("\n############################# " + this.companyName + " terminating transactions " +
                "########################\n");
    }
}
