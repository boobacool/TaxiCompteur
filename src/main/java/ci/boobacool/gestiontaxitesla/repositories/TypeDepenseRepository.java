package ci.boobacool.gestiontaxitesla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.boobacool.gestiontaxitesla.domain.TypeDepense;

public interface TypeDepenseRepository extends JpaRepository<TypeDepense, Long>{
  TypeDepense findByLibelle(String libelle);
}
