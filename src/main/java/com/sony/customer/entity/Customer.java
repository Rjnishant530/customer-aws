package com.sony.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement

public class Customer {
	@Id
	@Column(name = "CUSTOMER_ID")
	private String id;
	@Column(name = "COMPANY_NAME")
	private String companyName;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_TITLE")
	private String contactTitle;
	private String address;
	private String city;
	private String region;
	@Column(name = "postal_code")
	private String postalCode;
	private String country;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "FAX")
	private String fax;
}
