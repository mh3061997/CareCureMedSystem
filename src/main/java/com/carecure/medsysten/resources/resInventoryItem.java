package com.carecure.medsysten.resources;

import com.carecure.medsysten.enums.enumInventoryItemCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class resInventoryItem
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	private String name;
	private int availableUnits;
	@Enumerated(EnumType.STRING)
	private enumInventoryItemCategory category;
	private int sellingPrice;

	@ElementCollection
	@MapKeyTemporal(TemporalType.DATE)
	@Column(name = "numberOfUnits")
	private Map<Date, Integer> expiryDates;

	public void setExpiryDateCount(Date key , int count){
		this.expiryDates.put(key,count);
	}
	public void addExpiryDateCount(Date key , int count){
		this.expiryDates.put(key,this.expiryDates.get(key)+count);
	}
	public boolean deductExpiryDateCount(Date key , int count){
		int currentCount = this.expiryDates.get(key);

		if(currentCount >= count){
			this.expiryDates.put(key,currentCount-count);
			return true;
		}
	return false;

	}
}
