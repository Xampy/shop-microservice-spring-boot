package com.xampydrivesell.userShopService.infrastructure.adapter.primary.service;

import com.xampydrivesell.userShopService.domain.entity.Shop;
import com.xampydrivesell.userShopService.domain.port.primary.service.ShopServiceInterface;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.domain.share.exception.ShopNameAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService implements ShopServiceInterface {

    private final ShopRepositoryInterface repository;

    public ShopService(ShopRepositoryInterface repository){
        this.repository = repository;
    }

    @Override
    public void add(Shop shop) throws ShopNameAlreadyExistsException {
        boolean existsName = this.repository.selectExistsByName(shop.getName());
        if(existsName) {
            throw new ShopNameAlreadyExistsException();
        }

        repository.save(shop);
    }

    @Override
    public Shop getShopByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public List<Shop> getAllShop() {
        return repository.findAll();
    }
}
