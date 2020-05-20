package ci.boobacool.gestiontaxitesla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.boobacool.gestiontaxitesla.domain.Annee;
import ci.boobacool.gestiontaxitesla.domain.Depense;
import ci.boobacool.gestiontaxitesla.domain.Mois;
import ci.boobacool.gestiontaxitesla.domain.Taxi;
import ci.boobacool.gestiontaxitesla.repositories.DepenseRepository;

@Service
public class DepenseServiceImpl {
	@Autowired
	private DepenseRepository depenseRepository;
	
	public Optional<Depense> findById(Long id){
		return depenseRepository.findById(id);
	}
	
	public List<Depense> listeDepense(){
		return depenseRepository.findAll();
	}
	
	public void deleteDepense(Depense depense) {
		depenseRepository.delete(depense);
	}
	
	public double depenseAnnee(Annee annee, Taxi taxi) {
		return depenseRepository.sumDepenseAnnee(annee, taxi);
	}
	
	
	public double depenseAnneeMois(Annee annee, Mois mois, Taxi taxi) {
		return depenseRepository.sumDepenseAnneeMois(annee, mois, taxi);
	}
	
	
	

}
