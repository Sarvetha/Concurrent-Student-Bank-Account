/** *********************************************************************
 * File:      StatementEntry.java
 * Author:    P. Howells
 * Contents:  6SENG002W CW:  StatementEntry class
 *            This provides the basic data structure for a single
 *            bank account statement entry, i.e. a single transaction.
 * Created:   23/10/21
 ************************************************************************ */


public class StatementEntry
{

    private final char TAB = '\t' ;

    private final String CustomerID ;
    private final int    amount ;
    private final int    currentBal ;


    public StatementEntry( String CustomerID, int amount, int currentBal )
    {
        this.CustomerID = CustomerID ;
        this.amount     = amount ;
        this.currentBal = currentBal ;
    }


    public String getCustomer()      { return CustomerID ; }

    public int    getAmount()        { return amount ; }

    public int    getCurrentBalance(){ return currentBal ; }

    public String toStringOLD( )
    {
        return  new String( "Customer: " + CustomerID + ","  + TAB +
                "Amount: "   + amount     + ", " + TAB +
                "Balance: "  + currentBal
        ) ;
    }

}
