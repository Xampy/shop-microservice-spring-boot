package com.xampydrivesell.userShopService.infrastructure.adapter.secondary.repository;

import com.xampydrivesell.userShopService.domain.entity.Shop;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.share.exception.ShopNameAlreadyExistsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InMemoryRepository implements ShopRepositoryInterface {

    private ArrayList<Shop> shops = new ArrayList<>();

    public InMemoryRepository(){
        super();
    }


    @Override
    public Shop save(Shop shop) {
        this.shops.add(shop);
        return shop;
    }

    @Override
    public Shop getByName(String name) {
        for(Shop sh: this.shops){
            if(sh.getName().equals(name))
                return sh;
        }
        return null;
    }

    @Override
    public List<Shop> findAll() {
        return Arrays.asList(this.shops.toArray(new Shop[this.shops.size()]));
    }

    @Override
    public void deleteAll() {
        this.shops.clear();
    }


    @Override
    public boolean selectExistsByName(String name) {
        for(Shop sh: this.shops){
            if(sh.getName().equals(name))
                return true;
        }
        return false;
    }
}
