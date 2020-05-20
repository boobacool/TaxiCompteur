package ci.boobacool.gestiontaxitesla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.boobacool.gestiontaxitesla.domain.Annee;
import ci.boobacool.gestiontaxitesla.domain.Mois;
import ci.boobacool.gestiontaxitesla.domain.Recette;
import ci.boobacool.gestiontaxitesla.domain.Taxi;
import ci.boobacool.gestiontaxitesla.repositories.RecetteRepository;

@Service
public class RecetteServiceImpl {
	@Autowired
	private RecetteRepository recetteRepository;
	
	public Optional<Recette> findById(Long id){
		return recetteRepository.findById(id);
	}
	
	public List<Recette> listeRecette(){
		return recetteRepository.findAll();
	}
	
	public double recetteAnnee(Annee annee, Taxi taxi) {
		return recetteRepository.sumRecetteAnnee(annee, taxi);
	}
	public double recetteAnneeMois(Annee annee, Mois mois, Taxi taxi) {
		return recetteRepository.sumRecetteAnneeMois(annee, mois, taxi);
	}

}
