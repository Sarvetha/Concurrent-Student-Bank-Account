import java.util.ArrayList;

public class Student extends Thread{

    // Student Name
    private String studentName;

    // Student's bank account details
    private BankCurrentAccount studentBankAccount;

    //  The thread group it is in
    public Student (ThreadGroup threadGroup, String threadName, BankCurrentAccount bankAccount){
        super(threadGroup, threadName);
        this.studentName = threadName;
        studentBankAccount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("\n######################## " + this.studentName + " starting to perform transactions " +
                "#######################\n");

        // Student transactions
        // Deposits Lottery amount
        Transaction winLottery = new Transaction(this.studentName, 2000000);

        // Withdraws amount to buy new samsung phone
        Transaction buyPhone = new Transaction(this.studentName, 60000);

        // Withdraws amount to buy new laptop
        Transaction buyLaptop = new Transaction(this.studentName, 200000);

        // Withdraws amount to give birthday treat for friends
        Transaction birthdayTreat = new Transaction(this.studentName, 15000);

        // Deposits part time job salary
        Transaction partTimeSalary = new Transaction(this.studentName, 25000);

        // Deposits monthly savings amount
        Transaction monthlySavings = new Transaction(this.studentName, 7500);


        ArrayList<Transaction> studentTransactions = new ArrayList();
        studentTransactions.add(winLottery);
        studentTransactions.add(buyPhone);
        studentTransactions.add(buyLaptop);
        studentTransactions.add(birthdayTreat);
        studentTransactions.add(partTimeSalary);
        studentTransactions.add(monthlySavings);


        //Sleeping for a random amount of time between each transaction.
        for (Transaction transaction: studentTransactions) {
            try {
                sleep( (int)(Math.random() * 100) ) ;
            }
            catch (InterruptedException e) { }
        }

        // After completing the transactions, prints the final account statement.
        studentBankAccount.printStatement();

        System.out.println("\n############################## " + this.studentName + " terminating transactions" +
                " ########################\n");
    }
}
