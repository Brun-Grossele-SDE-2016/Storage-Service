
package knowyourtown.localdb.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per readSuggestion complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="readSuggestion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="placeTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suggestionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readSuggestion", propOrder = {
    "personId",
    "placeTypeId",
    "suggestionId"
})
public class ReadSuggestion {

    protected int personId;
    protected String placeTypeId;
    protected int suggestionId;

    /**
     * Recupera il valore della proprietà personId.
     * 
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * Imposta il valore della proprietà personId.
     * 
     */
    public void setPersonId(int value) {
        this.personId = value;
    }

    /**
     * Recupera il valore della proprietà placeTypeId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceTypeId() {
        return placeTypeId;
    }

    /**
     * Imposta il valore della proprietà placeTypeId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceTypeId(String value) {
        this.placeTypeId = value;
    }

    /**
     * Recupera il valore della proprietà suggestionId.
     * 
     */
    public int getSuggestionId() {
        return suggestionId;
    }

    /**
     * Imposta il valore della proprietà suggestionId.
     * 
     */
    public void setSuggestionId(int value) {
        this.suggestionId = value;
    }

}
