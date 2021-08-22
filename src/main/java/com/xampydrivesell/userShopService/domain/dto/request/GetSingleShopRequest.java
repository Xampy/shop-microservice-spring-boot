package com.xampydrivesell.userShopService.domain.dto.request;

public class GetSingleShopRequest implements UseCaseRequestInterface{

    /**
     * @var name the shop to be created
     */
    private String name;

    public GetSingleShopRequest(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
