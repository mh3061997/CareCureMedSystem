package com.carecure.medsysten.resources;

import com.carecure.medsysten.enums.EnumInventoryItemCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
@ToString
public class ResInventoryItem
{
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	private String name;
	private int availableUnits;
	@Enumerated(EnumType.STRING)
	private EnumInventoryItemCategory category;
	private int sellingPrice;

	@ElementCollection
	@MapKeyTemporal(TemporalType.DATE)
	@Column(name = "numberOfUnits")
	private Map<Date, Integer> expiryDates;

	public void setExpiryDateCount(Date key, int count) throws ParseException
	{
		//change from datetime to date to match the DB's format to avoid duplicates in the map
		key = dateFormatter.parse(dateTimeFormatter.format(key));

		this.expiryDates.put(key, count);
	}

	public void addExpiryDateCount(Date key, int count) throws ParseException
	{
		//change from datetime to date to match the DB's format to avoid duplicates in the map
		key = dateFormatter.parse(dateTimeFormatter.format(key));

		if (this.expiryDates.get(key) != null)
		{
			this.expiryDates.put(key, this.expiryDates.get(key) + count);
		}
		else
		{
			this.expiryDates.put(key, count);
		}
	}

	public boolean deductExpiryDateCount(Date key, int count) throws ParseException
	{
		//change from datetime to date to match the DB's format to avoid duplicates in the map
		key = dateFormatter.parse(dateTimeFormatter.format(key));

		int currentCount = this.expiryDates.get(key);

		if (currentCount >= count)
		{
			this.expiryDates.put(key, currentCount - count);
			return true;
		}
		return false;

	}
}
