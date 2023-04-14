package com.example.Layered.Architecture.web;

import com.example.Layered.Architecture.entity.Shop;
import com.example.Layered.Architecture.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        try {
            Shop createdShop = shopService.addShop(shop);
            return new ResponseEntity<>(createdShop, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> deleteShop(@PathVariable Long id) {
        try {
            shopService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Shop>> findAllShop() {
        try {
            List<Shop> shopList = shopService.findAllShop();
            return new ResponseEntity<>(shopList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> findShopById(@PathVariable Long id) {
        try {
            Shop shopById = shopService.findShopById(id);
            return new ResponseEntity<>(shopById, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShopById(@PathVariable Long id, @RequestBody Shop shop) {
        try {
            Shop updateShop = shopService.updateShopById(id, shop);
            return new ResponseEntity<>(updateShop, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
