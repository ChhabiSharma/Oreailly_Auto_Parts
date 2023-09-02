package com.oreilly.invoice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InvoiceDto {

    @JsonProperty("time")
    private String time;

    @JsonProperty("tenderDetails")
    private TenderDetails tenderDetails;

    @JsonProperty("storeNumber")
    private String storeNumber;
}
