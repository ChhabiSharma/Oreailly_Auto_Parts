package com.oreilly.invoice.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oreilly.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1")
public class InvoiceWebService {

    private final InvoiceService invoiceService;

    public InvoiceWebService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public ResponseEntity<Map<Long, String>> getCustomerInvoice(@RequestParam Long customerId) throws JsonProcessingException {
        log.info("Fetching customer invoices");

        final Map<Long, String> customerInvoices = invoiceService.findCustomerInvoice(customerId);

        return new ResponseEntity<>(customerInvoices, HttpStatus.OK);
    }
}
