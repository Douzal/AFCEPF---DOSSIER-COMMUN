
package fr.afcepf.al32.devise.itf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al32.devise.itf package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDeviseResponse_QNAME = new QName("http://itf.devise.al32.afcepf.fr/", "getDeviseResponse");
    private final static QName _ConvertirResponse_QNAME = new QName("http://itf.devise.al32.afcepf.fr/", "convertirResponse");
    private final static QName _Convertir_QNAME = new QName("http://itf.devise.al32.afcepf.fr/", "convertir");
    private final static QName _GetDevise_QNAME = new QName("http://itf.devise.al32.afcepf.fr/", "getDevise");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al32.devise.itf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConvertirResponse }
     * 
     */
    public ConvertirResponse createConvertirResponse() {
        return new ConvertirResponse();
    }

    /**
     * Create an instance of {@link GetDeviseResponse }
     * 
     */
    public GetDeviseResponse createGetDeviseResponse() {
        return new GetDeviseResponse();
    }

    /**
     * Create an instance of {@link Convertir }
     * 
     */
    public Convertir createConvertir() {
        return new Convertir();
    }

    /**
     * Create an instance of {@link GetDevise }
     * 
     */
    public GetDevise createGetDevise() {
        return new GetDevise();
    }

    /**
     * Create an instance of {@link Devise }
     * 
     */
    public Devise createDevise() {
        return new Devise();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeviseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.devise.al32.afcepf.fr/", name = "getDeviseResponse")
    public JAXBElement<GetDeviseResponse> createGetDeviseResponse(GetDeviseResponse value) {
        return new JAXBElement<GetDeviseResponse>(_GetDeviseResponse_QNAME, GetDeviseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.devise.al32.afcepf.fr/", name = "convertirResponse")
    public JAXBElement<ConvertirResponse> createConvertirResponse(ConvertirResponse value) {
        return new JAXBElement<ConvertirResponse>(_ConvertirResponse_QNAME, ConvertirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Convertir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.devise.al32.afcepf.fr/", name = "convertir")
    public JAXBElement<Convertir> createConvertir(Convertir value) {
        return new JAXBElement<Convertir>(_Convertir_QNAME, Convertir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDevise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.devise.al32.afcepf.fr/", name = "getDevise")
    public JAXBElement<GetDevise> createGetDevise(GetDevise value) {
        return new JAXBElement<GetDevise>(_GetDevise_QNAME, GetDevise.class, null, value);
    }

}
