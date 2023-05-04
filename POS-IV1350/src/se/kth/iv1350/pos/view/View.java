package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.*;

/**
 * The View class represents the cashier's view
 */

public class View {
    private Controller cont;
    int macBookId;
    int magicMouseId;

    /**
     * Creates a new instance of the View class.
     *
     * @param cont the controller instance to be associated with this view
     */

    public View(Controller cont){
        this.cont = cont;
        macBookId = 44;
        magicMouseId = 31;

    }

    /**
     * Triggers a fictional sale process.
     */
    public void saleInt(){
        cont.startSale();
        cont.scanProduct(macBookId);
        cont.scanProduct(macBookId);
        cont.scanProduct(magicMouseId);
        cont.scanProduct(magicMouseId);
        cont.scanProduct(magicMouseId);
        cont.paySale(1000);
        displayProductInfo();
        cont.endSale();
    }

    private void displayProductInfo(){
        displayProductsInSale(cont.getSaleDTO());
        displayPriceOfProductsInSale(cont.getSaleDTO());
        displayQuantityOfProductsInSale(cont.getSaleDTO());
        showTotal(cont.getSaleDTO());
    }

    /**
     * Displays a list of scanned products in the current sale.
     *
     * @param saleDTO the sale data transfer object containing the list of products
     */

    public void displayProductsInSale(SaleDTO saleDTO){
        System.out.println("Products scanned:");

        for(ProductDTO product : saleDTO.currentProducts){
            System.out.println("- " + product.productName);
        }


    }

    /**
     * Displays the price of each product in the current sale.
     *
     * @param saleDTO the sale data transfer object containing the list of products
     */
    public void displayPriceOfProductsInSale(SaleDTO saleDTO){
        System.out.println("\n" + "Price per product:");

        for(ProductDTO productDTO : saleDTO.currentProducts){
            System.out.println("- " + "$" + productDTO.productPrice);
        }
        System.out.println();
    }

    /**
     * Displays the quantity of each product in the current sale.
     *
     * @param saleDTO the sale data transfer object containing the list of products
     */
    public void displayQuantityOfProductsInSale(SaleDTO saleDTO){
        System.out.println("Amount per product:");

        for(ProductDTO productDTO : saleDTO.currentProducts){
            System.out.println(productDTO.productQuantity + "x " + productDTO.productName);
        }
    }

    /**
     * Displays the total amount of the current sale.
     *
     * @param saleDTO the sale data transfer object containing the total amount
     */
    public void showTotal(SaleDTO saleDTO){
        System.out.println("\n" + "Your grand total: " + "$" + saleDTO.paymentDTO.totalAmount);
    }
}
