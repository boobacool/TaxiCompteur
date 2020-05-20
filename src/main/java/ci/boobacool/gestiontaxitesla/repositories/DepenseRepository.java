package ci.boobacool.gestiontaxitesla.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ci.boobacool.gestiontaxitesla.domain.Annee;
import ci.boobacool.gestiontaxitesla.domain.Depense;
import ci.boobacool.gestiontaxitesla.domain.Mois;
import ci.boobacool.gestiontaxitesla.domain.Taxi;

public interface DepenseRepository extends JpaRepository<Depense, Long>{

	List<Depense> findByMoisAndAnnee(Mois mois,Annee annee);
	
	@Query("SELECT SUM(d.montant) FROM Depense d where d.annee=?1 AND d.mois=?2 AND d.contrat.taxi=?3")
	double sumDepenseAnneeMois(Annee annee, Mois mois, Taxi taxi);
	
	@Query("SELECT SUM(d.montant) FROM Depense d where d.annee=?1 AND d.contrat.taxi=?2")
	double sumDepenseAnnee(Annee annee, Taxi taxi);
	
}
