package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.ReceiptDTO;

class ReceiptDTOTest {

    @Test
    void testReceiptDTOInit() {
        Receipt receipt = new Receipt();
        ReceiptDTO receiptDTO = new ReceiptDTO(receipt);

        assertNotNull(receiptDTO);
        assertEquals(0.0, receiptDTO.saleTotal);
        assertEquals(0.0, receiptDTO.change);
        assertEquals(0.0, receiptDTO.totalVat);
        assertEquals(0, receiptDTO.name.length);
        assertEquals(0, receiptDTO.price.length);
        assertEquals(0, receiptDTO.vat.length);
        assertEquals(0, receiptDTO.quantity.length);
        assertNotNull(receiptDTO.date);
        assertEquals(receipt.getSaleTotal(), receiptDTO.saleTotal);
        assertEquals(receipt.getChange(), receiptDTO.change);
        assertEquals(receipt.getTotalVat(), receiptDTO.totalVat);
        assertArrayEquals(receipt.getNameList(), receiptDTO.name);
        assertArrayEquals(receipt.getPrice(), receiptDTO.price);
        assertArrayEquals(receipt.getVatList(), receiptDTO.vat);
        assertArrayEquals(receipt.getQuantity(), receiptDTO.quantity);
        assertEquals(receipt.getReceiptCreationTime(), receiptDTO.date);
    }

}
