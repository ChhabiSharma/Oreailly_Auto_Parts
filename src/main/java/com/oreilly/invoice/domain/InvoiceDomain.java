package com.oreilly.invoice.domain;

import lombok.Data;


@Data
public class InvoiceDomain {
    private Long customerId;
    private Long invoiceId;
    private String tenderDetails;
}
