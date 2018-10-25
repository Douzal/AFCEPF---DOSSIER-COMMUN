package fr.afcepf.al32;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class App {

	public static void main(String[] args) throws Exception {
		Personne p1 = new Personne();p1.setNum(1); 	p1.setPrenom("alex"); p1.setNom("Therieur");
		System.out.println("p1="+p1.toString());
		Adresse a1 = new Adresse(); a1.setVille("Rouen");a1.setCp("76000");
		p1.getAdresses().add(a1);
		javaToXmlViaJaxb2(p1);
		
		Personne p2 = xmlToJavaViaJaxb2();	
		System.out.println("p2="+p2.toString());
		for(Adresse a : p2.getAdresses()) {
			System.out.println("\t"+a.toString());
		}
	}
	
	static void javaToXmlViaJaxb2(Personne p) throws Exception{
		JAXBContext ctx = JAXBContext.newInstance(Personne.class);
		//    marshaller pour écriture/sérialisation de java vers xml
		Marshaller m = ctx.createMarshaller();
		m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
		m.marshal(p,new FileOutputStream("src/personne1.xml"));
	}
	
	static Personne xmlToJavaViaJaxb2() throws Exception{
		Personne p = new Personne();
		//javax.xml.bind.JAXBContext est le point d'entree de l'api JAXB2
		//NB: la classe passée en paramètre de .newInstance() doit 
		//    comporter @XmlRootElement
		JAXBContext ctx = JAXBContext.newInstance(Personne.class);
		//    unmarshaller pour lecture/dé-serialisation de xml vers java
		p= (Personne) ctx.createUnmarshaller()
				         .unmarshal(new FileInputStream("src/personne.xml"));
        return p;
	}
	
	

}
