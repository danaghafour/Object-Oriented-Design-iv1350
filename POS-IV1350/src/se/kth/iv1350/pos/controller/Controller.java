package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.ReceiptPrinter;
import se.kth.iv1350.pos.model.Product;
import se.kth.iv1350.pos.model.ProductDTO;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleDTO;

/**
 * The Controller class is responsible for controlling the POS system flow and interacting with external systems.
 */
public class Controller {
    private Sale saleCont;
    private AccountingSystem accountingSCont;
    private InventorySystem inventorySCont;
    private ReceiptPrinter printerCont;


    /**
     * Creates a new instance of Controller.
     *
     * @param accountingS The accounting system.
     * @param inventoryS The inventory system.
     * @param receiptPrinter The receipt printer.
     */
    public Controller(AccountingSystem accountingS, InventorySystem inventoryS, ReceiptPrinter receiptPrinter){
        accountingSCont = accountingS;
        inventorySCont = inventoryS;
        printerCont = receiptPrinter;
    }

    /**
     * Start a new <code>Sale</code>
     */

    public void startSale() {
        saleCont = new Sale();
    }

    /**
     * Add products from <code>InventorySystem</code> to <code>Sale</code>
     * @param productId The ID of the product to add.
     */

    public void scanProduct(int productId) {
        ProductDTO productDTOInDB = inventorySCont.getProductDTOFromDB(productId);
        Product productInDB = new Product(productDTOInDB);
        productInDB.increaseQuantity(1);
        saleCont.addProductToSale(productInDB);
    }


    /**
     * A method to end the <code>sale</code> and update the external systems with the <code>Sale</code> details.
     */
    public void endSale(){
        SaleDTO saleDTO = null;

        inventorySCont.updateSaleQuantity(saleDTO);
        accountingSCont.update(saleDTO);
        this.saleCont = null;
    }

    /**
     * Calculates the change for the customer's payment and returns it.
     *
     * @param paymentAmount The amount paid by the customer.
     * @return The change to give back to the customer.
     */
    public double paySale(double paymentAmount){
        saleCont.getCustomerPayment().calculateChange(saleCont.getCustomerPayment().getTotalAmount());
        return saleCont.getCustomerPayment().getChange();
    }

    /**
     * Get <code>SaleDTO</code> for current <code>Sale</code> linked to <code>Controller</code>
     * @return saleDTO
     */

    public SaleDTO getSaleDTO(){
        SaleDTO saleDTO = new SaleDTO(saleCont);
        return saleDTO;
    }

    /**
     * Gets the current sale object.
     *
     * @return The current sale object.
     */

    public Sale getSaleCont(){
        return saleCont;
    }


}
