package com.carecure.medsysten.resources;

import com.carecure.medsysten.enums.EnumInventoryOrderType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "resinventoryorder")
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
public class ResInventoryOrder
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
	private EnumInventoryOrderType type;
	private String userMadeBy;
	private boolean isCancelled;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemCode",referencedColumnName = "code",nullable = false)
	private ResInventoryItem item;
	private String note;

}
