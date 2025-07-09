package com.melasoft.xsdvalidater.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "invoices")
@Getter
@Setter
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tax_id", nullable = false)
    private String nip;

    @Column(name = "invoice_field_p1", nullable = false)
    private String p1;

    @Column(name = "invoice_field_p2", nullable = false)
    private String p2;
}