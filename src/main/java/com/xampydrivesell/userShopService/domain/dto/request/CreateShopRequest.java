package com.xampydrivesell.userShopService.domain.dto.request;

public class CreateShopRequest implements UseCaseRequestInterface{

    /**
     * @var name the shop to be created
     */
    private String name;

    public CreateShopRequest(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
