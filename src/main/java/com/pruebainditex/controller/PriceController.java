package com.pruebainditex.controller;

import com.pruebainditex.entity.Price;
import com.pruebainditex.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("prices")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public List<Price> getAllPrices() {
        return priceService.findAllPrices();
    }

    @GetMapping("/{priceId}")
    public Price getPriceById(@PathVariable Long priceId) {
        return priceService.findPriceById(priceId);
    }

    @PostMapping
    public Price createPrice(@RequestBody Price price) {
        return priceService.createPrice(price);
    }

    @PutMapping("/{priceId}")
    public Price updatePrice(@PathVariable Long priceId, @RequestBody Price price) {
        price.setId(priceId); // Ensure the provided ID matches the path
        return priceService.updatePrice(price);
    }

    @DeleteMapping("/{priceId}")
    public void deletePrice(@PathVariable Long priceId) {
        priceService.deletePrice(priceId);
    }

    @GetMapping
    public ResponseEntity<Price> getPrice(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                          @RequestParam("productId") Long productId,
                                          @RequestParam("brandId") Long brandId) {
        Price price = priceService.findByBrandAndProductAndDate(date, productId, brandId);

        if (price != null) {
            return ResponseEntity.ok(price);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
