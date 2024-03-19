package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.Payment;
import se.kth.iv1350.pos.model.ProductDTO;
import se.kth.iv1350.pos.model.SaleDTO;

/**
 * The View class represents the cashier's view.
 */

public class View {

    private Controller cont;
    int firstProductId;
    int secondProductId;

    /**
     * Creates a new instance of the View class.
     *
     * @param cont the controller instance to be associated with this view
     */

    public View(Controller cont) {
        this.cont = cont;
        cont.addPaymentObserver(new TotalRevenueObserver());
        secondProductId = 404;
        firstProductId = 101;
    }
    private void getProductById(int productId) {
        try {
            cont.scanProduct(productId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Simulates a sale process with three purchased products,
     * where two share the same product ID and payment,
     * and prints to the terminal.
     */
    public void simulateSaleProcess() {

        cont.initializeNewSale();
        getProductById(firstProductId);
        getProductById(secondProductId);
        getProductById(firstProductId);
        cont.finalizeSaleAndUpdateSystems();
        sendProductInfoToDisplay();
        cont.processPaymentAndReturnChange(Payment.FIRST_PAYMENT);

        cont.initializeNewSale();
        getProductById(firstProductId);
        getProductById(firstProductId);
        getProductById(121);
        cont.finalizeSaleAndUpdateSystems();
        sendProductInfoToDisplay();
        cont.processPaymentAndReturnChange(Payment.SECOND_PAYMENT);
    }

    private void sendProductInfoToDisplay() {
        showProductsInSale(cont.getSaleDTO());
        showPriceOfProductsInSale(cont.getSaleDTO());
        showQuantityOfProductsInSale(cont.getSaleDTO());
        showProductPrice(cont.getSaleDTO());
    }

    /**
     * Displays the products in the sale.
     *
     * @param saleDTO the SaleDTO object containing the products in the sale
     */
    public void showProductsInSale(SaleDTO saleDTO) {
        System.out.println("Products in sale:");

        for (ProductDTO product : saleDTO.getCurrentProducts())
            System.out.println(product.getProductName());
    }

    /**
     * Displays the price of the products in the sale.
     *
     * @param saleDTO the SaleDTO object containing the products in the sale
     */
    public void showPriceOfProductsInSale(SaleDTO saleDTO) {
        System.out.println("Price of products in sale: ");
        for (ProductDTO productDTO : saleDTO.getCurrentProducts()) {
            System.out.println(productDTO.getProductPrice());
        }
    }

    /**
     * Displays the quantity of the products in the sale.
     *
     * @param saleDTO the SaleDTO object containing the products in the sale
     */
    public void showQuantityOfProductsInSale(SaleDTO saleDTO) {
        System.out.println("Quantity of products in sale: ");
        for (ProductDTO productDTO : saleDTO.getCurrentProducts()) {
            System.out.println(productDTO.getProductQuantity());
        }
    }
    /**
     * Displays the total price of the products in the sale.
     *
     * @param saleDTO the SaleDTO object containing the payment information
     */
    public void showProductPrice(SaleDTO saleDTO) {
        System.out.println("Price of products in sale: " + saleDTO.getPaymentDTO().getTotalAmount());
    }


}