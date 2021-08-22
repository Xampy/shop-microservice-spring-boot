package com.xampydrivesell.userShopService.domain.dto.response.shopProduct;

import com.xampydrivesell.userShopService.domain.dto.response.UseCaseResponseInterface;

public class AddProductToShopResponse implements UseCaseResponseInterface {

    /**
     * Content in the response
     * @var content
     */
    private String content;

    public AddProductToShopResponse(String content) {
        this.content = content;
    }

    public AddProductToShopResponse() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
