public class University extends Thread{

    // University Name
    private String universityName;

    // Student's bank account details
    private BankCurrentAccount studentBankAccount;

    //  The thread group it is in
    public University(ThreadGroup threadGroup, String universityName, BankCurrentAccount bankAccount){
        super(threadGroup, universityName);
        this.universityName = universityName;
        studentBankAccount = bankAccount;
    }


    @Override
    public void run() {
        System.out.println("\n########################## Starting University Transactions" +
                " ######################\n");

        // Make 3 appropriate course fee withdrawals from student's account
        int numberOfWithdrawals = 3;

        for (int i = 0; i < numberOfWithdrawals; i++) {

            // Withdraws course fee from student's account
            Transaction courseFee = new Transaction(this.universityName, 70000);
            studentBankAccount.withdrawal( courseFee );
            System.out.println("[Student's University]: Withdrawing transaction made: " + courseFee);

            // Sleep for a random amount of time between each transaction
            try {
                sleep( (int)(Math.random() * 100) ) ;
            }
            catch (InterruptedException e) { }
        }

        System.out.println("\n############################ " + this.universityName + " terminating transactions " +
                "############################\n");
    }
}
