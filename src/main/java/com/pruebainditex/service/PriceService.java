package com.pruebainditex.service;

import com.pruebainditex.entity.Price;
import com.pruebainditex.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    public Price updatePrice(Price price) {
        return priceRepository.save(price);
    }

    public void deletePrice(Long priceId) {
        priceRepository.deleteById(priceId);
    }

    public Price findPriceById(Long priceId) {
        return priceRepository.findById(priceId).orElse(null);
    }

    public List<Price> findAllPrices() {
        return priceRepository.findAll();
    }
}

