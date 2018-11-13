package fr.afcepf.al32.web.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al32.dto.Blague;

/* WebService Rest sur blagues pourries
   en s'appyant sur le framework Spring-MVC  
 */
@CrossOrigin(origins = "*")//+  .and().cors() dans MultiHttpSecurityConfig
@RestController //@RestController hérite de @Component de Spring
@RequestMapping(value="/rest/blagues" , headers="Accept=application/json")
public class BlagueRestCtrl {
	
	private Map<Long,Blague> mapBlagues = new HashMap<Long,Blague>();
	private Long cptBlagues;
	
	public BlagueRestCtrl() {
		mapBlagues.put(1L, new Blague(1L,"blague1","blague qui n'a pas super marché",1.0));
		mapBlagues.put(2L, new Blague(2L,"blague2","JSP=je sais pas",2.0));
		mapBlagues.put(3L, new Blague(3L,"Halloween","allo ween ici trouille",2.0));
		cptBlagues=3L;
	}
	
	//URL = http://localhost:8080/tpMvcSpringBootApp/rest/blagues/99
	@GetMapping("/{id}")
	public ResponseEntity<Blague> getBlagueById(@PathVariable("id")Long id) {
		Blague b = mapBlagues.get(id);
		if(b==null)
			return new ResponseEntity<Blague>(HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<Blague>(b,HttpStatus.OK);
	}
	
	//URL = http://localhost:8080/tpMvcSpringBootApp/rest/blagues
	// avec { "titre" : "nouvelleBlague" , "texte" : "blague ..." }
	// dans la partie body invisible de la requête HTTP
	@PostMapping("")
	public Blague postBlague(@RequestBody Blague blague) {
		blague.setId(++cptBlagues);//simuler auto_increment
		mapBlagues.put(blague.getId(), blague);
		return blague;
	}
	
	//URL = http://localhost:8080/tpMvcSpringBootApp/rest/blagues
	// ou   http://localhost:8080/tpMvcSpringBootApp/rest/blagues?noteMini=2
	@GetMapping("")
	public List<Blague> getListeBlagues(
			       @RequestParam(name="noteMini",required=false)Double noteMini){
		List<Blague> toutesLesBlagues = new ArrayList<Blague>(mapBlagues.values());
		if(noteMini==null)
		  return  toutesLesBlagues;
		else 
			return toutesLesBlagues.stream()
					               .filter(b -> b.getNote()!=null ? b.getNote()>=noteMini : false)
					               .collect(Collectors.toList());
	}

	
	
	
	
	
	
	
	
}
