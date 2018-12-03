package com.pos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@Column(name="company_name")
	private String companyName;
	private String address;
	private String phone;
	private String fax;
	private String mobile;
	private String web;
	private String email;
	@Column(name="pay_vat")
	private String payVat;
	private boolean tax;
	@Column(name="tp_invoice")
	private String tpInvoice;
	@Column(name="ce_invoice")
	private String ceInvoice;
	private String note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPayVat() {
		return payVat;
	}

	public void setPayVat(String payVat) {
		this.payVat = payVat;
	}

	public boolean isTax() {
		return tax;
	}

	public void setTax(boolean tax) {
		this.tax = tax;
	}

	public String getTpInvoice() {
		return tpInvoice;
	}

	public void setTpInvoice(String tpInvoice) {
		this.tpInvoice = tpInvoice;
	}

	public String getCeInvoice() {
		return ceInvoice;
	}

	public void setCeInvoice(String ceInvoice) {
		this.ceInvoice = ceInvoice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
