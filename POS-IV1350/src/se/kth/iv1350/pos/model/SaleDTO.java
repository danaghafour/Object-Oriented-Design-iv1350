package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The SaleDTO class represents a data transfer object for a sale made in the point of sale system.
 * It contains information about the products included in the sale, any discounts applied, payment information,
 * time of sale and the receipt for the sale.
 */

public class SaleDTO {
    /**
     * ArrayList that stores the current list of products in the sale.
     */
    public ArrayList<ProductDTO> currentProducts = new ArrayList<>();

    /**
     * The discount applied to the sale, if any.
     */

    public double discount;
    /**
     * The payment information related to the sale.
     */
    public PaymentDTO paymentDTO;
    /**
     * The time when the sale was initiated.
     */
    public LocalTime timeOfSale;
    /**
     * The receipt information related to the sale.
     */
    public ReceiptDTO receiptDTO;

    /**
     * Constructs a new instance of SaleDTO based on the specified Sale object.
     * @param saleToDTO The Sale object to create the SaleDTO from.
     */
    public SaleDTO(Sale saleToDTO){
        this.timeOfSale = saleToDTO.getTimeOfSale();
        for(Product product : saleToDTO.getCurrentProducts()){
            this.currentProducts.add(new ProductDTO(product));
        }

        this.receiptDTO = new ReceiptDTO(saleToDTO.getSalesReceipt());
        this.paymentDTO = new PaymentDTO(saleToDTO.getCustomerPayment());
    }


}
