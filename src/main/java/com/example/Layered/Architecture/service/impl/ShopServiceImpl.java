package com.example.Layered.Architecture.service.impl;

import com.example.Layered.Architecture.entity.Shop;
import com.example.Layered.Architecture.repository.ShopRepository;
import com.example.Layered.Architecture.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Shop addShop(Shop shop) {
        if (shop == null) {
            throw new IllegalArgumentException("Магазин не може бути null");
        }
        return shopRepository.save(shop);
    }

    @Override
    public void deleteById(Long id) {
        if (shopRepository.existsById(id)) {
            shopRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Магазину не знайдено");
        }
    }

    @Override
    public List<Shop> findAllShop() {
        return (List<Shop>) shopRepository.findAll();
    }

    @Override
    public Shop findShopById(Long id) {
        return shopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Магазину з id " + id + " не знайдено"));
    }

    @Override
    public Shop updateShopById(Long id, Shop shop) {
        shop.setId(id);
        return shopRepository.save(shop);
    }
}
