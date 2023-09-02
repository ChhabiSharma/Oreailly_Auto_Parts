package com.oreilly.invoice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Repository;

import java.util.Map;

public interface InvoiceService {

    Map<Long, String> findCustomerInvoice(Long customerId) throws JsonProcessingException;
}
