package com.xampydrivesell.userShopService.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE)
    private Long id;

    public Shop(){}

    /**
     * @var name
     */
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
    protected String description = "";
    /**
     * All products in the shop. It consists of a list
     * of the product id (a unique identifier)
     * @var products
     */
    //private ArrayList<Long> products = new ArrayList<Long>();

    /**
     * Constructor
     * @param name the shop name
     */
    public Shop(String name){
        this.name = name;
    }

    /**
     * Constructor
     * @param name the shop name
     * @param description a description about the shop
     */
    public Shop(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    /*public ArrayList<Long> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Long> products) {
        this.products = products;
    }

    public void addProduct(long id){
        this.products.add(id);
    }*/
}
