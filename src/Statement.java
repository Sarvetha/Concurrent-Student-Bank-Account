/** *********************************************************************
 * File:	Statement.java
 * Author:	P. Howells
 * Contents:	6SENG002W CW:  Statement class
 *		Provides the data structure for a bank account statement.
 * Date:	23/10/21
 ************************************************************************ */

public class Statement
{
    /********* private Instance Variables *********/

    private final char TAB       = '\t' ;
    private final int  MAX_TRANS = 20 ;

    private final StatementEntry[] statement = new StatementEntry[ MAX_TRANS ] ;

    private final String accountHolder ;
    private final int    accountNumber ;

    private int transactionCount = 0 ;


    /********* public Constructor Method *********/
    public Statement( String accountHolder, int accountNumber )
    {
        this.accountHolder = accountHolder ;

        this.accountNumber = accountNumber ;
    }


    /********* public Modifier Methods *********/

    public void addTransaction(String CustomerID, int amount, int balance)
    {
        // Create a new statement entry & add to the statement

        statement[ transactionCount ] = new StatementEntry(CustomerID, amount, balance) ;

        transactionCount++ ;
    }


    public void print( )
    {
        System.out.println( ) ;

        System.out.println( "Statement for "  +  accountHolder  +
                "'s Account: "    +  accountNumber    ) ;

        System.out.println( "================================================" ) ;

        System.out.format( "%1$-20s %2$10s  %3$13s", "Customer", "Amount", "Balance" ) ;
        System.out.println() ;

        System.out.println( "================================================" ) ;

        for (int tid = 0 ; tid < transactionCount ; tid++ )
        {
            //	 print a statement's transaction

            System.out.format( "%1$-20s %2$10d  %3$10d",
                    statement[ tid ].getCustomer(),
                    statement[ tid ].getAmount(),
                    statement[ tid ].getCurrentBalance()  ) ;
            System.out.println() ;
        }

        System.out.println( "================================================" ) ;
        System.out.println( ) ;
    }

}