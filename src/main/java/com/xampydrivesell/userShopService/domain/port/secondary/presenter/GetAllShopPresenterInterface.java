package com.xampydrivesell.userShopService.domain.port.secondary.presenter;


import com.xampydrivesell.userShopService.domain.dto.response.shop.GetAllShopResponse;

public interface GetAllShopPresenterInterface {

    /**
     * Present a response to a view
     * @param response an object from the use case execution
     * @return an object
     */
    Object present(GetAllShopResponse response);
}
