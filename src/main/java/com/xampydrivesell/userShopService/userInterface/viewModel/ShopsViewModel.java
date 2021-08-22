package com.xampydrivesell.userShopService.userInterface.viewModel;

import com.xampydrivesell.userShopService.domain.entity.Shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * class Shop
 */
public class ShopsViewModel implements Serializable {

    /**
     * @var shops
     */
    transient private ArrayList<Shop> shops = new ArrayList<Shop>();

    /**
     * Constructor
     * @param shops al list of shop name
     */
    public ShopsViewModel(Shop[] shops){
        this.shops.addAll(List.of(shops));
    }

    public ArrayList<Shop> getShops() {
        return shops;
    }
}
