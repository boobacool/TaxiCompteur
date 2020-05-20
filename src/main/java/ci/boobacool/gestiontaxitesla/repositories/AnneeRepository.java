package ci.boobacool.gestiontaxitesla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.boobacool.gestiontaxitesla.domain.Annee;

public interface AnneeRepository extends JpaRepository<Annee, Long>{
	
	Annee findByLibelle(String libelle);
	

}
