//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2023.01.19 alle 04:52:59 PM CET 
//


package it.siav.SpringSOAPws.gs_producing_web_service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="population" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="capital" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="currency" type="{http://spring.io/guides/gs-producing-web-service}currency"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "population",
    "capital",
    "currency"
})
@XmlRootElement(name = "insertCountryRequest")
public class InsertCountryRequest {

    @XmlElement(required = true)
    protected String name;
    protected Integer population;
    @XmlElement(required = true)
    protected String capital;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Currency currency;

    /**
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Recupera il valore della proprietà population.
     * 
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Imposta il valore della proprietà population.
     * 
     */
    public void setPopulation(Integer value) {
        this.population = value;
    }

    /**
     * Recupera il valore della proprietà capital.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Imposta il valore della proprietà capital.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapital(String value) {
        this.capital = value;
    }

    /**
     * Recupera il valore della proprietà currency.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Imposta il valore della proprietà currency.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCurrency(Currency value) {
        this.currency = value;
    }

}
