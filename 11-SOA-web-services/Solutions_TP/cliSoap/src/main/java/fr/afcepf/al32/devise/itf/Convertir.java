
package fr.afcepf.al32.devise.itf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour convertir complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="convertir">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="monnaieSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monnaieCible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "convertir", propOrder = {
    "montant",
    "monnaieSource",
    "monnaieCible"
})
public class Convertir {

    protected Double montant;
    protected String monnaieSource;
    protected String monnaieCible;

    /**
     * Obtient la valeur de la propriété montant.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontant() {
        return montant;
    }

    /**
     * Définit la valeur de la propriété montant.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontant(Double value) {
        this.montant = value;
    }

    /**
     * Obtient la valeur de la propriété monnaieSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonnaieSource() {
        return monnaieSource;
    }

    /**
     * Définit la valeur de la propriété monnaieSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonnaieSource(String value) {
        this.monnaieSource = value;
    }

    /**
     * Obtient la valeur de la propriété monnaieCible.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonnaieCible() {
        return monnaieCible;
    }

    /**
     * Définit la valeur de la propriété monnaieCible.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonnaieCible(String value) {
        this.monnaieCible = value;
    }

}
