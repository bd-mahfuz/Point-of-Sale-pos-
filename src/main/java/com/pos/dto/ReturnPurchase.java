package com.pos.dto;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Return_Purchase")
public class ReturnPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "available_qty")
    private int AvailableQty;
    @Column(name = "return_qty")
    private int returnQty;
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Column(name = "serial_no")
    private int serialNo;
    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAvailableQty() {
        return AvailableQty;
    }

    public void setAvailableQty(int availableQty) {
        AvailableQty = availableQty;
    }

    public int getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(int returnQty) {
        this.returnQty = returnQty;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
