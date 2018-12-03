package com.pos.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.utility.DateUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sales_invoice")
public class SalesInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "sell_invoice")
    private int sellInvoice;
    @Column(name = "sell_type")
    private String sellType;
    @Column(name = "available_return_qty")
    private int availableQty; // its available return quantity
    @Column(name = "sell_qty")
    private int quantity;
    private String unit;
    private double rate;
    private double total;
    private double dis;
    @Column(name = "net_total")
    private double netTotal;
    @Column(name = "payment_receive")
    private double paymentReceive;
    private double due;

    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "model_id")
    private ItemModel model;

    @JsonIgnore
    @OneToMany(mappedBy = "salesInvoice", cascade = CascadeType.ALL)
    //@JoinTable(joinColumns = @JoinColumn("salesInvoice_Id"))
    private List<MacList> macLists = new ArrayList<>();


    // ---------- transient field for macList ----------
    //@JsonIgnore
    @Transient
    List<String> macIDs = new ArrayList<>();


    public List<String> getMacIDs() {
        return macIDs;
    }

    public void setMacIDs(List<String> macIDs) {
        this.macIDs = macIDs;
    }

    public List<MacList> getMacLists() {
        return macLists;
    }

    public void setMacLists(List<MacList> macLists) {
        this.macLists = macLists;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSellInvoice() {
        return sellInvoice;
    }

    public void setSellInvoice(int sellInvoice) {
        this.sellInvoice = sellInvoice;
    }

    public String getSellType() {
        return sellType;
    }

    public void setSellType(String sellType) {
        this.sellType = sellType;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDis() {
        return dis;
    }

    public void setDis(double dis) {
        this.dis = dis;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }

    public double getPaymentReceive() {
        return paymentReceive;
    }

    public void setPaymentReceive(double paymentReceive) {
        this.paymentReceive = paymentReceive;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ItemModel getModel() {
        return model;
    }

    public void setModel(ItemModel model) {
        this.model = model;
    }
}
