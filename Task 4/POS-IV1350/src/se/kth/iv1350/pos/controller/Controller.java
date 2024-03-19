package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.exceptions.*;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.model.discountCalculation.Discounter;
import se.kth.iv1350.pos.model.discountCalculation.QuantityDiscounter;

import java.math.BigDecimal;
import java.util.*;

/**
 * The Controller class is responsible for controlling the POS system flow and interacting with external systems.
 */
public class Controller {
    private Sale saleCont;
    private AccountingSystem accountingSCont;
    private ReceiptPrinter printerCont;
    private InventorySystem inventorySCont;
    private DiscountSystem discountSCont;

    private List<PaymentObserver> paymentObserverList = new ArrayList<>();
    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();
    private DeveloperLog developerLog = new DeveloperLog();

    /**
     * Creates a new instance of Controller.
     *
     * @param accountingS The accounting system.
     * @param inventoryS The inventory system.
     * @param receiptPrinter The receipt printer.
     */
    public Controller(AccountingSystem accountingS, InventorySystem inventoryS, ReceiptPrinter receiptPrinter){
        accountingSCont = AccountingSystem.getAccountingSystemInstance();
        inventorySCont = inventoryS;
        printerCont = receiptPrinter;
        discountSCont = new DiscountSystem();
    }

    /**
     * Adds a new observer for the CustomerPayment class to the controller.
     *
     * @param observer the observer to be added
     */
    public void addPaymentObserver(PaymentObserver observer) {
        paymentObserverList.add(observer);
    }

    /**
     * Adds an item found in the InventorySystem connected by the itemID to the Sale.
     *
     * @param productId the productId to be searched for
     * @throws OperationFailedException thrown if there are server issues or if there is no match for productID in the inventory system
     */
    public void scanProduct(int productId) throws OperationFailedException {
        ProductDTO productDTOFromDB = null;

        try {
            productDTOFromDB = inventorySCont.getProductDTOFromDB(productId);
        } catch (ProductIDMissingException productIDMissing) {
            throw new OperationFailedException("Product ID was not found in the inventory system.", productIDMissing);
        } catch (InventoryDBException inventoryDBDown) {
            developerLog.logException(inventoryDBDown.getMessage());
            throw new OperationFailedException("Inventory system server is down.", inventoryDBDown);
        }

        Product productFromDB = new Product(productDTOFromDB);
        productFromDB.increaseQuantity(1);

        saleCont.addProductToSale(productFromDB);
    }

    /**
     * Start a new <code>Sale</code>.
     */

    public void initializeNewSale() {
        saleCont = new Sale();
        saleCont.getPayment().addPaymentObservers(paymentObserverList);
        saleCont.getPayment().setTotalRevenue(totalRevenueFileOutput);
    }

    /**
     * A method to end the <code>Sale</code> and update the external systems with the <code>Sale</code> details.
     */
    public void finalizeSaleAndUpdateSystems(){
        SaleDTO saleDTO = new SaleDTO(saleCont);
        inventorySCont.updateQuantityFromSale(saleDTO);
        AccountingSystem.getAccountingSystemInstance().updateAccountingSystem(saleDTO);
    }

    /**
     * Calculates the change for the customer's payment and returns it.
     *
     * @param amountPaid The amount paid by the customer.
     * @return The change to give back to the customer.
     */
    public double processPaymentAndReturnChange(double amountPaid){
        saleCont.getPayment().calculateChange(amountPaid);
        return saleCont.getPayment().getChange();
    }

    /**
     * Get <code>SaleDTO</code> for current <code>Sale</code> linked to <code>Controller</code>.
     *
     * @return The <code>SaleDTO</code> object representing the current sale.
     */

    public SaleDTO getSaleDTO(){
        SaleDTO saleDTO = new SaleDTO(saleCont);
        return saleDTO;
    }

    // A method that creates a new sale and applies a discount to it and handles any exceptions that may occur
    public void createSaleAndApplyDiscount() {
        Sale sale = new Sale();
        sale.setDiscounter(new QuantityDiscounter(3));
        BigDecimal amount = sale.getTotalAmount();
        BigDecimal discountedPrice = sale.applyDiscount(amount);
        System.out.println("The discounted price is: " + discountedPrice);
    }
    public void setDiscounter(Discounter discounter) {
        saleCont.setDiscounter(discounter);
    }
}