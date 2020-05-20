package ci.boobacool.gestiontaxitesla.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.boobacool.gestiontaxitesla.domain.Chauffeur;
import ci.boobacool.gestiontaxitesla.domain.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long>{
 
	List<Contrat> findByChauffeur(Chauffeur chauffeur);
	
}
