package ci.boobacool.gestiontaxitesla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.boobacool.gestiontaxitesla.domain.Chauffeur;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long>{
	
	Chauffeur findByCni(String cni);
	Chauffeur findByContact(String contact);
	
	

}
