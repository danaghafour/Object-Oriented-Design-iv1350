package se.kth.iv1350.pos.startup;

import java.lang.String;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.ReceiptPrinter;
import se.kth.iv1350.pos.model.discountCalculation.Discounter;
import se.kth.iv1350.pos.model.discountCalculation.QuantityDiscounter;
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
        AccountingSystem accountingSystem = AccountingSystem.getAccountingSystemInstance();
        InventorySystem inventorySystem = InventorySystem.getInventorySystemInstance();
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        Controller cont = new Controller(accountingSystem, inventorySystem, receiptPrinter);
        View view = new View(cont);
        cont.initializeNewSale();
        Discounter discounter = new QuantityDiscounter(3);
        cont.setDiscounter(discounter);
        view.simulateSaleProcess();
    }
}