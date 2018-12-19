package com.pos.dto;

import com.pos.utility.DateUtil;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "bill_no")
    private int billNo;
    @Column(name = "invoice_no")
    private int invoiceNo;
    @Column(name = "airway_bill")
    private double airWayBill;
    @Column(name = "no_of_cartoon")
    private int noOfCartoon;
    @Column(name = "cartoon_dimension")
    private int cartoonDimension;
    @Column(name = "purchase_quantity")
    private int quantity;
    @Column(name = "available_qty")
    private int availableQty;
    private double rate;
    private double total;
    @Column(name = "net_payment")
    private double netPayment;
    private double due;

    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @OneToOne
    private Supplier supplier;
    @OneToOne
    private ItemModel model;

    @Column(name = "serial_no")
    private int serialNo;
    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
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

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public double getAirWayBill() {
        return airWayBill;
    }

    public void setAirWayBill(double airWayBill) {
        this.airWayBill = airWayBill;
    }

    public int getNoOfCartoon() {
        return noOfCartoon;
    }

    public void setNoOfCartoon(int noOfCartoon) {
        this.noOfCartoon = noOfCartoon;
    }

    public int getCartoonDimension() {
        return cartoonDimension;
    }

    public void setCartoonDimension(int cartoonDimension) {
        this.cartoonDimension = cartoonDimension;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public double getNetPayment() {
        return netPayment;
    }

    public void setNetPayment(double netPayment) {
        this.netPayment = netPayment;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ItemModel getModel() {
        return model;
    }

    public void setModel(ItemModel model) {
        this.model = model;
    }
}
