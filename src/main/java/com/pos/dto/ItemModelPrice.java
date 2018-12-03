package com.pos.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ItemModelPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "buy_price")
    private double buyPrice;
    @Column(name="sell_price")
    private double sellPrice;
    @ManyToOne
    @JoinColumn(name = "productItem_id")
    private ProductItem productItem;
    @OneToOne
    @JoinColumn(name = "itemModel_id")
    private ItemModel itemModel;
    private String notes;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate = new Date();

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }

    public ItemModel getItemModel() {
        return itemModel;
    }

    public void setItemModel(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

}
