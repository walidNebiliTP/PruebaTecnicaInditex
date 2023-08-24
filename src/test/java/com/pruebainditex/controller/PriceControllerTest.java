package com.pruebainditex.controller;
import com.pruebainditex.entity.Price;
import com.pruebainditex.service.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceControllerTest {

    @InjectMocks
    private PriceController priceController;

    @Mock
    private PriceService priceService;
    @Test
    public void testGetAllPrices()  {

        List<Price> testPrices = new ArrayList<>();
        when(priceService.findAllPrices()).thenReturn(testPrices);

        List<Price> result = priceController.getAllPrices();

        assertEquals(testPrices, result);
    }
    @Test
    public void testGetPriceById() {
        Long priceId = 1L;
        Price testPrice = new Price();
        when(priceService.findPriceById(priceId)).thenReturn(testPrice);

        Price result = priceController.getPriceById(priceId);

        assertEquals(testPrice, result);
    }

    @Test
    public void testCreatePrice() {
        Price testPrice = new Price();
        when(priceService.createPrice(any())).thenReturn(testPrice);

        Price result = priceController.createPrice(testPrice);

        assertEquals(testPrice, result);
    }

    @Test
    public void testUpdatePrice() {
        Long priceId = 1L;
        Price testPrice = new Price();
        when(priceService.updatePrice(any())).thenReturn(testPrice);

        Price result = priceController.updatePrice(priceId, testPrice);

        assertEquals(testPrice, result);
    }

    @Test
    public void testDeletePrice() {
        Long priceId = 1L;

        assertDoesNotThrow(() -> priceController.deletePrice(priceId));

        verify(priceService, times(1)).deletePrice(priceId);
    }
    @Test
    public void testGetPrice() {
        Price testPrice = new Price();
        when(priceService.findByBrandAndProductAndDate(any(), any(), any())).thenReturn(testPrice);

        ResponseEntity<Price> response = priceController.getPrice(LocalDateTime.now(), 35455L, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testPrice, response.getBody());
    }

    @Test
    public void testGetPrice10hDia14Zara() {
        Price testPrice = new Price();
        when(priceService.findByBrandAndProductAndDate(any(), any(), any())).thenReturn(testPrice);

        ResponseEntity<Price> response = priceController.getPrice(
                LocalDateTime.of(2023, 6, 14, 10, 0), 35455L, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testPrice, response.getBody());
    }

    @Test
    public void testGetPrice16hDia14Zara() {
        Price testPrice = new Price();
        when(priceService.findByBrandAndProductAndDate(any(), any(), any())).thenReturn(testPrice);

        ResponseEntity<Price> response = priceController.getPrice(
                LocalDateTime.of(2023, 6, 14, 16, 0), 35455L, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testPrice, response.getBody());
    }

    @Test
    public void testGetPrice21hDia14Zara() {
        Price testPrice = new Price();
        when(priceService.findByBrandAndProductAndDate(any(), any(), any())).thenReturn(testPrice);

        ResponseEntity<Price> response = priceController.getPrice(
                LocalDateTime.of(2023, 6, 14, 21, 0), 35455L, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testPrice, response.getBody());
    }
    @Test
    public void testGetPrice10hDia15Zara() {
        Price testPrice = new Price();
        when(priceService.findByBrandAndProductAndDate(any(), any(), any())).thenReturn(testPrice);

        ResponseEntity<Price> response = priceController.getPrice(
                LocalDateTime.of(2023, 6, 15, 10, 0), 35455L, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testPrice, response.getBody());
    }
    @Test
    public void testGetPrice21hDia16Zara() {
        Price testPrice = new Price();
        when(priceService.findByBrandAndProductAndDate(any(), any(), any())).thenReturn(testPrice);

        ResponseEntity<Price> response = priceController.getPrice(
                LocalDateTime.of(2023, 6, 16, 21, 0), 35455L, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testPrice, response.getBody());
    }
}
