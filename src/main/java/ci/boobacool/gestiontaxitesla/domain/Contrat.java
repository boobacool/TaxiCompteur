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
@Table(name="contrat")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contrat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4648847643487028668L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date datedebut;
	private Date datefin;
	private boolean etat;
	@ManyToOne
	@JoinColumn(name = "taxi", nullable=false)
	private Taxi taxi;
	@ManyToOne
	@JoinColumn(name = "chauffeur", nullable=false)
	private Chauffeur chauffeur;

}
