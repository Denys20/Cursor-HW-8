package com.example.Layered.Architecture.service;

import com.example.Layered.Architecture.entity.Shop;

import java.util.List;

public interface ShopService {
    Shop addShop(Shop shop);

    void deleteById(Long id);

    List<Shop> findAllShop();

    Shop findShopById(Long id);

    Shop updateShopById(Long id, Shop shop);
}
