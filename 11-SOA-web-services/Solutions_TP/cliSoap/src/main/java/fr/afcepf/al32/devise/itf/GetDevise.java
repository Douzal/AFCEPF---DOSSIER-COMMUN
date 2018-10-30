
package fr.afcepf.al32.devise.itf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getDevise complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getDevise">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="monnaie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDevise", propOrder = {
    "monnaie"
})
public class GetDevise {

    protected String monnaie;

    /**
     * Obtient la valeur de la propriété monnaie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonnaie() {
        return monnaie;
    }

    /**
     * Définit la valeur de la propriété monnaie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonnaie(String value) {
        this.monnaie = value;
    }

}
