package com.xampydrivesell.userShopService.domain.dto.request.shopProduct;

import com.xampydrivesell.userShopService.domain.dto.request.UseCaseRequestInterface;

public class AddProductToShopRequest implements UseCaseRequestInterface {

    /**
     * The id of the product to be added
     * @var productId a number representing the product identifier
     */
    private long productId;

    /**
     * The shop name
     * @var shopName a string
     */
    private String shopName;

    public AddProductToShopRequest(long productId, String shopName) {
        this.productId = productId;
        this.shopName = shopName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
