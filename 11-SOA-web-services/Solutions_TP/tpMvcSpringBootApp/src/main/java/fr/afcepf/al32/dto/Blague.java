package fr.afcepf.al32.dto;

import lombok.Data;

@Data //equivalent de @Getter @Setter @NoArgsConstructor  @ToString
public class Blague {
	private Long id;
	private String titre;
	private String texte;
	private Double note; //note moyenne (de 0 à 5).
	
	public Blague(Long id, String titre, String texte, Double note) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
		this.note = note;
	}
	
	
}
