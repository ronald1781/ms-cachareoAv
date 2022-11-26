package com.r2g.msshopping.service;

import com.r2g.msshopping.entity.Invoice;
import com.r2g.msshopping.repository.InvoiceItemRepository;
import com.r2g.msshopping.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    InvoiceItemRepository invoiceItemRepository;

    @Override
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        Invoice invoiceBD=invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
        if (invoiceBD!=null){
            return invoiceBD;
        }
        invoice.setState("CREATED");
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice invoiceBD=getInvoice(invoice.getId());
        if (invoiceBD==null){
            return null;
        }
        invoiceBD.setCustomerId(invoice.getCustomerId());
        invoiceBD.setDescription(invoice.getDescription());
        invoiceBD.setNumberInvoice(invoice.getNumberInvoice());
        invoiceBD.getItems().clear();
        invoiceBD.setItems(invoice.getItems());
        return invoiceRepository.save(invoiceBD);
    }

    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceBD=getInvoice(invoice.getId());
        if (invoiceBD==null){
            return null;
        }
        invoiceBD.setState("DELETED");
        return invoiceRepository.save(invoiceBD);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

}
