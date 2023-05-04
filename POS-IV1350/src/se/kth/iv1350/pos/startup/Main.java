package se.kth.iv1350.pos.startup;

import java.lang.String;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.ReceiptPrinter;
import se.kth.iv1350.pos.view.View;


/**
 * The Main class contains the main method that starts up the program.
 */

public class Main {

    /**
     *
     * @param args contains the arguments sent in command line when running the program.
     *             This won't be used since no commands will be sent in this case.
     */
    public static void main(String[] args) {
        InventorySystem inventoryS = new InventorySystem();
        ReceiptPrinter printer = new ReceiptPrinter();
        AccountingSystem accountingS = new AccountingSystem();
        Controller cont = new Controller(accountingS, inventoryS, printer);
        View view = new View(cont);
        view.saleInt();
    }
}