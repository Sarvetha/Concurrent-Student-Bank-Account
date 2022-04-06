public class BankingSystem {
    // Initial account balance
    int iniitialAccountBalance = 5000;
    BankCurrentAccount bankAccount;

    // Declare two thread groups: one for humans and one for the Loan Company & University.
    ThreadGroup threadGroup1;
    ThreadGroup threadGroup2;

    // Declare 4 threads
    Thread student;
    Thread grandmother;
    Thread loanCompany;
    Thread university;

    public BankingSystem(){

        // Create student bank account with details
        System.out.println("------------------ Creating bank account ---------------");
        bankAccount = new BankCurrentAccount(2018427, "Sarvetha Nadanamainthan", iniitialAccountBalance);
        System.out.println("Created bank account with: \n initial balanace: Rs." + bankAccount.getBalance() + "\n " +
                "account holder: " + bankAccount.getAccountHolder() +
                "\n account number: " + bankAccount.getAccountNumber());
        System.out.println("-------------------------------------------------------\n\n");


        // Create thread groups
        System.out.println("------------------ Creating thread groups ---------------");
        threadGroup1 = new ThreadGroup("Thread Group 1(Humans)");
        threadGroup2 = new ThreadGroup("Thread Group 2(Loan Company & University)");
        System.out.println("Created thread groups: \n" + threadGroup1.getName() + "\n" + threadGroup2.getName());
        System.out.println("-------------------------------------------------------\n\n");


        // Create thread for student
        System.out.println("----------------- Creating student thread ---------------");
        student = new Student(threadGroup1, "Student", bankAccount);
        System.out.println("Created student thread");
        System.out.println(student.getName() + " Thread State: " + student.getState());
        System.out.println("-------------------------------------------------------\n\n");


        // Create thread for grandmother
        System.out.println("----------------- Creating grandmother thread ---------------");
        grandmother = new Grandmother(threadGroup1, "Grandmother", bankAccount);
        System.out.println("Created grandmother thread");
        System.out.println(grandmother.getName() + " Thread State: " + grandmother.getState());
        System.out.println("-------------------------------------------------------\n\n");


        // Create thread for student loan bankingsystem
        System.out.println("----------------- Creating loan bankingsystem thread ---------------");
        loanCompany = new StudentLoanCompany(threadGroup2, "Loan Company", bankAccount);
        System.out.println("Created loan bankingsystem thread");
        System.out.println(loanCompany.getName() + " Thread State: " + loanCompany.getState());
        System.out.println("-------------------------------------------------------\n\n");


        // Create thread for university
        System.out.println("----------------- Creating university thread ---------------");
        university = new University(threadGroup2, "University", bankAccount);
        System.out.println("Created university thread");
        System.out.println(university.getName() + " Thread State: " + student.getState());
        System.out.println("-------------------------------------------------------\n\n");

    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------- BANKING SYSTEM --------------------------------------\n\n");

        BankingSystem bankingSystem = new BankingSystem();

        // Starts all 4 threads executing
        bankingSystem.student.start();
        bankingSystem.grandmother.start();
        bankingSystem.loanCompany.start();
        bankingSystem.university.start();


        // Wait until all 4 threads terminate
        try {
            bankingSystem.student.join();
            bankingSystem.grandmother.join();
            bankingSystem.loanCompany.join();
            bankingSystem.university.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-------------------------------------- All threads are terminated --------------------------------------\n\n");

        // Prints the final account statement
        bankingSystem.bankAccount.printStatement();

    }
}
