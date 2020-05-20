package ci.boobacool.gestiontaxitesla.domain;

import java.io.Serializable;
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
@Table(name="chauffeur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chauffeur 	implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 873582011303287859L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenoms;
	private String cni;
	private String contact;
	@OneToMany(mappedBy = "chauffeur")
	private Collection<Contrat> contrats;
	

}
