package com.carecure.medsysten.resources.reports;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class ResMonthlySpecialityIncomeDto extends AbstractPersistable<Long>
{
	private String Speciality;
	private Date Date;
	private Integer Total;

}
