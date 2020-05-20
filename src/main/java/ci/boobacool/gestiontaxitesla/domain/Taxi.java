package ci.boobacool.gestiontaxitesla.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="taxi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Taxi implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5010718625662194966L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String immat;
	private Date dateservice;
	@OneToMany(mappedBy = "taxi")
	private Collection<Contrat> contrats;

}
