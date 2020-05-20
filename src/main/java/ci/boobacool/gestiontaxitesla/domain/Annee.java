package ci.boobacool.gestiontaxitesla.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="annee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Annee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	@OneToMany(mappedBy = "annee")
	private Collection<Recette> recettes;
	@OneToMany(mappedBy = "annee")
	private Collection<Depense> depenses;

}
