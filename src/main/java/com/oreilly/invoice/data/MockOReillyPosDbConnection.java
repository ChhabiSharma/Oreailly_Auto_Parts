package com.oreilly.invoice.data;

import com.oreilly.invoice.domain.InvoiceDomain;
import com.oreilly.invoice.dto.InvoiceDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Mock the OReilly Connection as a Map
 */
@Repository
public class MockOReillyPosDbConnection {

    private  List<InvoiceDomain> invoices = new ArrayList<>();

    /**
     *
     * @return Map<Long CustomerId, Map<Long InvoiceId, String TenderDetails>>
     */
    @PostConstruct
    public void init() {
        List<String> data = tenderDetails();

        InvoiceDomain invoiceDomain = new InvoiceDomain();
        invoiceDomain.setCustomerId(1L);
        invoiceDomain.setInvoiceId(54L);
        invoiceDomain.setTenderDetails(data.get(0));
        invoices.add(invoiceDomain);

        invoiceDomain = new InvoiceDomain();
        invoiceDomain.setCustomerId(2L);
        invoiceDomain.setInvoiceId(55L);
        invoiceDomain.setTenderDetails(data.get(1));
        invoices.add(invoiceDomain);

        invoiceDomain = new InvoiceDomain();
        invoiceDomain.setCustomerId(2L);
        invoiceDomain.setInvoiceId(56L);
        invoiceDomain.setTenderDetails(data.get(2));
        invoices.add(invoiceDomain);

    }

    protected List<String> tenderDetails() {
        return Arrays.asList(
                "{\"time\":\"19:53\", \"tenderDetails\": {\"amount\":23.43, \"type\":\"cash\"}, \"storeNumber\":\"999\"}",
                "{\"time\":\"12:00\", \"tenderDetails\": {\"amount\":4.95, \"type\":\"cash\"}, \"storeNumber\":\"999\"}",
                "{\"time\":\"08:49\", \"tenderDetails\": {\"amount\":100.12, \"type\":\"credit\"}, \"storeNumber\":\"999\"}"
        );
    }

    public List<InvoiceDomain> getInvoices() {
        return invoices;
    }
}
