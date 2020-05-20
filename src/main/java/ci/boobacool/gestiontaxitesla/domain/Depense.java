package ci.boobacool.gestiontaxitesla.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="depense")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Depense implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7766693172247014829L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double montant;
	private Date debutSem;
	private Date finSem;
	@ManyToOne
	@JoinColumn(name="typedepense", nullable=false)
	private TypeDepense typeDepense;
	@ManyToOne
	@JoinColumn(name="mois", nullable=false)
	private Mois mois;
	
	@ManyToOne
	@JoinColumn(name="annee", nullable=false)
	private Annee annee;
	
	@ManyToOne
	@JoinColumn(name="contrat", nullable=false)
	private Contrat contrat;

}
