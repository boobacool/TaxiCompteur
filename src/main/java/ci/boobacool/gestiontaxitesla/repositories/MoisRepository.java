package ci.boobacool.gestiontaxitesla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.boobacool.gestiontaxitesla.domain.Mois;

public interface MoisRepository extends JpaRepository<Mois, Long>{
    Mois findByLibelle(String libelle);

}
