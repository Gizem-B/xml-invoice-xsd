//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.07.07 at 03:46:25 AM TRT 
//


package com.melasoft.xsdvalidater.generated;

import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for TFaWiersz complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TFaWiersz">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NrWierszaFa" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="P_7" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="P_8A" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="P_8B" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TIlosci"/>
 *         &lt;element name="P_9A" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TKwotowy"/>
 *         &lt;element name="P_11" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TKwotowy"/>
 *         &lt;element name="P_12" type="{http://crd.gov.pl/wzor/2023/06/29/12648/}TStawkaPodatku"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TFaWiersz", propOrder = {
    "nrWierszaFa",
    "p7",
    "p8A",
    "p8B",
    "p9A",
    "p11",
    "p12"
})
public class TFaWiersz {

    @XmlElement(name = "NrWierszaFa", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger nrWierszaFa;
    @XmlElement(name = "P_7", required = true)
    protected String p7;
    @XmlElement(name = "P_8A", required = true)
    protected String p8A;
    @XmlElement(name = "P_8B", required = true)
    protected BigDecimal p8B;
    @XmlElement(name = "P_9A", required = true)
    protected BigDecimal p9A;
    @XmlElement(name = "P_11", required = true)
    protected BigDecimal p11;
    @XmlElement(name = "P_12", required = true)
    protected String p12;

    /**
     * Gets the value of the nrWierszaFa property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNrWierszaFa() {
        return nrWierszaFa;
    }

    /**
     * Sets the value of the nrWierszaFa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNrWierszaFa(BigInteger value) {
        this.nrWierszaFa = value;
    }

    /**
     * Gets the value of the p7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getP7() {
        return p7;
    }

    /**
     * Sets the value of the p7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setP7(String value) {
        this.p7 = value;
    }

    /**
     * Gets the value of the p8A property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getP8A() {
        return p8A;
    }

    /**
     * Sets the value of the p8A property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setP8A(String value) {
        this.p8A = value;
    }

    /**
     * Gets the value of the p8B property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getP8B() {
        return p8B;
    }

    /**
     * Sets the value of the p8B property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setP8B(BigDecimal value) {
        this.p8B = value;
    }

    /**
     * Gets the value of the p9A property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getP9A() {
        return p9A;
    }

    /**
     * Sets the value of the p9A property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setP9A(BigDecimal value) {
        this.p9A = value;
    }

    /**
     * Gets the value of the p11 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getP11() {
        return p11;
    }

    /**
     * Sets the value of the p11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setP11(BigDecimal value) {
        this.p11 = value;
    }

    /**
     * Gets the value of the p12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getP12() {
        return p12;
    }

    /**
     * Sets the value of the p12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setP12(String value) {
        this.p12 = value;
    }

}
