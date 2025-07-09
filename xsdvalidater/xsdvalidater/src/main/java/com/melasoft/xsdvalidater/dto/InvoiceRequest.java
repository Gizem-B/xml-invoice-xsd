package com.melasoft.xsdvalidater.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Request DTO containing Base64 encoded XML data")
public class InvoiceRequest {

    private String base64xml;
}
