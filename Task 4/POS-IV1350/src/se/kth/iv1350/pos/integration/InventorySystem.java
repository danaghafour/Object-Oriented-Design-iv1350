package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Product;
import se.kth.iv1350.pos.model.ProductDTO;
import se.kth.iv1350.pos.model.SaleDTO;
import se.kth.iv1350.pos.exceptions.*;

/**

 Represents an inventory system that is used for fetching products.
 */
public class InventorySystem {
    private Product[] productsInDB;
    private static final int SERVER_DOWN_PRODUCT_ID = 404;
    private static final InventorySystem instance = new InventorySystem();

    private InventorySystem() {
        productsInDB = new Product[] {
                new Product(121, 3, "Eggs", 25, 30),
                new Product(123, 3, "Lemon",10, 3.33)
        };
    }

    /**

     Updates the quantity of products in the inventory system based on the completed sale.
     @param processedSale The completed sale to update the product quantities for.
     */
    public void updateQuantityFromSale(SaleDTO processedSale) {
    }
    /**

     Retrieves the {@link ProductDTO} from the inventory system based on the product ID.

     @param productID The ID of the product to be found in the inventory system.

     @return A {@link ProductDTO} representing the found product, or null if not found.

     @throws ProductIDMissingException If the given product ID was not found in the inventory system.

     @throws InventoryDBException If the inventory system is unavailable.
     */
    public ProductDTO getProductDTOFromDB(int productID) throws ProductIDMissingException, InventoryDBException {
        if (productID == SERVER_DOWN_PRODUCT_ID) {
            throw new InventoryDBException();
        }

        Product productToReturn = null;

        for (Product product : productsInDB) {
            if (product.getProductId() == productID) {
                productToReturn = product;
            }
        }

        if (productToReturn == null) {
            throw new ProductIDMissingException(productID);
        }

        return new ProductDTO(productToReturn);
    }

    /**

     Retrieves the singleton instance of the InventorySystem class.
     @return The singleton instance of the InventorySystem.
     */
    public static InventorySystem getInventorySystemInstance() {
        return instance;
    }
}