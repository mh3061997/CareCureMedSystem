package com.carecure.medsysten.dtos.invoice;

import lombok.Data;

@Data
public class GetInvoiceItemEmbeddedDto
{

	private long code;
	private String name;
	private int price;
}
