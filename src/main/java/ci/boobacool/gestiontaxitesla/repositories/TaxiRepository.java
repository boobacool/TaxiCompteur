package ci.boobacool.gestiontaxitesla.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ci.boobacool.gestiontaxitesla.domain.Taxi;

public interface TaxiRepository extends JpaRepository<Taxi, Long>{

	Taxi findByImmat(String immat);
	
	//Page<Taxi> findAll(Pageable pageable);
}
