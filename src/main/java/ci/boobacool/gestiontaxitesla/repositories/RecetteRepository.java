package ci.boobacool.gestiontaxitesla.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ci.boobacool.gestiontaxitesla.domain.Annee;
import ci.boobacool.gestiontaxitesla.domain.Mois;
import ci.boobacool.gestiontaxitesla.domain.Recette;
import ci.boobacool.gestiontaxitesla.domain.Taxi;

public interface RecetteRepository extends JpaRepository<Recette, Long>{

     List<Recette> findByMoisAndAnnee(Mois mois,Annee annee);
	
	@Query("SELECT SUM(r.montant) FROM Recette r where r.annee=?1 AND r.mois=?2 AND r.contrat.taxi=?3")
	double sumRecetteAnneeMois(Annee annee, Mois mois, Taxi taxi) ;
	
	@Query("SELECT SUM(r.montant) FROM Recette r where r.annee=?1 AND r.contrat.taxi=?2")
	double sumRecetteAnnee(Annee annee, Taxi taxi);
}
