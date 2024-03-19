package model;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.Product;
import se.kth.iv1350.pos.model.Sale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaleTest {

    private Sale sale = new Sale();

    @AfterEach
    public void cleanUp() {
        sale = new Sale();
    }

    @Test
    void isProductInSaleFail() {
        Product productInSale = new Product(132,2,"socks",50,8);
        sale.addProductToSale(productInSale);
        Product productNotInSale = new Product(111,2,"apple", 50,8);
        boolean productIsInSale = sale.isProductInSale(productNotInSale);
        assertEquals(productIsInSale,false, "The product should not be in the sale if it has a different product ID.");
    }

    @Test
    void isProductInSaleSuccess() {
        Product productInSale = new Product(132,2,"socks",50,8);
        sale.addProductToSale(productInSale);
        Product productNotInSale = new Product(132,1,"socks",50,8);
        boolean productIsInSale = sale.isProductInSale(productNotInSale);
        assertEquals(productIsInSale,true);
    }

    @Test
    void addNewProductToSaleSuccess(){
        Product productInSale = new Product(132,2,"socks",50,8);
        sale.addProductToSale(productInSale);

        Product nextProduct = new Product(sale.getCurrentProducts().get(0));

        assertEquals(nextProduct.getProductId(),productInSale.getProductId());
    }
}