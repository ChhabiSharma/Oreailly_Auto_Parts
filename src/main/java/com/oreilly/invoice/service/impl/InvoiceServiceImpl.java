package com.oreilly.invoice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.invoice.data.MockOReillyPosDbConnection;
import com.oreilly.invoice.domain.InvoiceDomain;
import com.oreilly.invoice.dto.InvoiceDto;
import com.oreilly.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final MockOReillyPosDbConnection mockOReillyPosDbConnection;

    public InvoiceServiceImpl(MockOReillyPosDbConnection mockOReillyPosDbConnection) {
        this.mockOReillyPosDbConnection = mockOReillyPosDbConnection;
    }

    @Override
    public Map<Long, String> findCustomerInvoice(Long customerId) throws JsonProcessingException {

        Map<Long, String> outputData = new HashMap<>();

        try {
            List<InvoiceDomain> invoiceDomains = mockOReillyPosDbConnection.getInvoices();

            ObjectMapper objectMapper = new ObjectMapper();

            for(InvoiceDomain dto : invoiceDomains) {
                if(customerId == dto.getCustomerId()) {
                    InvoiceDto invoiceData = objectMapper.readValue(dto.getTenderDetails(), InvoiceDto.class);
                    outputData.put(dto.getInvoiceId(), invoiceData.getTenderDetails().getType());
                }
            }
        } catch (Exception ex) {
            // Handle the exception appropriately
        }

        return outputData;
    }
}
