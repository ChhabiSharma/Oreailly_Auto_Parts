package com.oreilly.invoice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TenderDetails {

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("type")
    private String type;
}
