package com.r2g.msshopping.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;
@Entity
@Data
@Table(name="tbl_invoice_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive(message = "El stock ser mayor que cero")
    private Double quantity;
    private Double price;
    @Column(name = "product_id")
    private Long productId;
    @Transient
    private Double subTotal;

    public Double getSubTotal() {
        if (this.price > 0 && this.quantity > 0) {
            return this.quantity * this.price;
        } else {
            return (double) 0;
        }
    }
    public InvoiceItem(){}
}
