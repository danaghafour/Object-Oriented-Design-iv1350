package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Product;
import se.kth.iv1350.pos.model.ProductDTO;
import se.kth.iv1350.pos.model.SaleDTO;

/**
 * This class represents the inventory system and the products in the database.
 */
public class InventorySystem {
    private Product[] productsInDB;

    /**
     * Creates a new instance of the InventorySystem class with hardcoded products.
     */
    public InventorySystem (){
        productsInDB = new Product[]{new Product(44, 15, "MacBook Pro M1 Pro", 2000, 25), new Product(31, 60, "Magic Mouse", 100, 25)};
    }

    /**
     * Update the quantity of products in the inventory system based on a sale.
     * @param registeredSale The SaleDTO to use for updating the inventory system.
     */
    public void updateSaleQuantity(SaleDTO registeredSale){
    }

    /**
     * Get a ProductDTO from the inventory system database based on a product id.
     * @param productId The id of the product to retrieve.
     * @return The corresponding ProductDTO, or null if not found.
     */
    public ProductDTO getProductDTOFromDB(int productId){

        if (productsInDB != null) {
            for (Product product : productsInDB) {
                if (product.getProductId() == productId){
                    return new ProductDTO(product);
                }
            }
        }

        // If the method reaches this point, it means no product matching the given productId was found in the productsInDB collection
        return null;
    }
}
