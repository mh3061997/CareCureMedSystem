package com.carecure.medsysten.resources;

import com.carecure.medsysten.enums.enumInventoryOrderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class resInventoryOrder
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	private int units;
	private int itemPrice;
	private int totalPrice;
	@Temporal(TemporalType.DATE)
	private Date itemExpiryDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	private String supplierName;
	@Enumerated(EnumType.STRING)
	private enumInventoryOrderType type;
	private String userMadeBy;

	@ManyToOne(fetch = FetchType.LAZY)
	private resInventoryItem item;


}
