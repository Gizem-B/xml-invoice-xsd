package com.melasoft.xsdvalidater.controller;


import com.melasoft.xsdvalidater.dto.InvoiceRequest;
import com.melasoft.xsdvalidater.dto.InvoiceResponse;
import com.melasoft.xsdvalidater.model.InvoiceEntity;
import com.melasoft.xsdvalidater.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {


    private final InvoiceService invoiceService;

    @PostMapping(value = "/invoices")
    public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest request) throws Exception {
        //Firstly, request came and went to the service layer for processing.
        InvoiceEntity savedInvoice = invoiceService.processAndSaveInvoice(request.getBase64xml());
        //After the transactions were completed successfully, a response was created with the requested information.
        InvoiceResponse response = new InvoiceResponse("Invoice saved successfully");
        //After the successful operation, a response was returned with code 201 as requested.
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
