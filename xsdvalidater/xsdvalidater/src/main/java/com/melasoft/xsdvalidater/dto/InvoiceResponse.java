package com.melasoft.xsdvalidater.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Invoice creation response")
public class InvoiceResponse {
    @Schema(description = "Message information", example = "Invoice saved successfully")
    private String message;
}
