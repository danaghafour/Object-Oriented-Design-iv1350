package se.kth.iv1350.pos.integration;


import se.kth.iv1350.pos.model.SaleDTO;

/**
 * The AccountingSystem class provides methods to update the accounting system with sales information.
 */

public class AccountingSystem {
    private static final AccountingSystem accountingSystemInstance = new AccountingSystem();

    /**
     * Creates a new instance of AccountingSystem.
     */
    private AccountingSystem(){
    }

    public static AccountingSystem getAccountingSystemInstance() {
        return accountingSystemInstance;
    }

    /**
     * Updates the accounting system with the sale information.
     *
     * @param saleDTOLog The {@link SaleDTO} object representing the sale to update the accounting system with.
     */
    public void updateAccountingSystem(SaleDTO saleDTOLog){
    }
}