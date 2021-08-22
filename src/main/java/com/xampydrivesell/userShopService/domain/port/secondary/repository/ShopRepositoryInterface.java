package com.xampydrivesell.userShopService.domain.port.secondary.repository;

import com.xampydrivesell.userShopService.domain.entity.Shop;

import java.util.List;

public interface ShopRepositoryInterface {


    /**
     * Create a new shop
     * @param shop an object representation a shop
     */
    Shop save(Shop shop);

    /**
     * Get shop by information
     * @return the name of the shop
     */
    Shop getByName(String name);

    /**
     * Find all shop
     * @return a collection of shop object
     */
    List<Shop> findAll();

    /**
     * Delete all records
     */
    void deleteAll();

    /**
     * Check if a shop exists with the given name
     * @param name The shop name
     * @return a boolean
     */
    boolean selectExistsByName(String name);
}
