package com.xampydrivesell.userShopService.domain.port.primary.service;

import com.xampydrivesell.userShopService.domain.entity.Shop;

import java.util.List;

public interface ShopServiceInterface {
    /**
     * Create a new shop
     * @param shop an object
     */
    void add(Shop shop) throws Exception;

    /**
     * Get shop by information
     * @param name the name of the shop
     * @return a shop with the provided name
     */
    Shop getShopByName(String name);

    /**
     * Find all shop
     * @return a collection of shops
     */
    List<Shop> getAllShop();
}
