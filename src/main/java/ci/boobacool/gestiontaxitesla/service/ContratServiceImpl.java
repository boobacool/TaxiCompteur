package ci.boobacool.gestiontaxitesla.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.boobacool.gestiontaxitesla.domain.Chauffeur;
import ci.boobacool.gestiontaxitesla.domain.Contrat;
import ci.boobacool.gestiontaxitesla.repositories.ContratRepository;
@Service
public class ContratServiceImpl {
	
	@Autowired
	private ContratRepository contratRepository;
	
	public Optional<Contrat> findById(Long id){
		return contratRepository.findById(id);
	}
	
	public  List<Contrat> listeContrats(){
		return contratRepository.findAll();
	}
	
	public Contrat saveContrat(Contrat contrat) {
		return contratRepository.save(contrat);
	}
	
	public void deleteContrat(Contrat contrat) {
		contratRepository.delete(contrat);
	}
	
	public boolean isContratExist(Contrat contrat,Chauffeur chauffeur) {

		if (contratRepository.existsById(contrat.getId()) || isContratByChauffeur(chauffeur))
			return true;
		else
			return false;
	}

	public Boolean isContratByChauffeur(Chauffeur chauffeur) {
		List<Contrat>contrats = contratRepository.findByChauffeur(chauffeur); 
		if ( contrats.size()!= 0)
			return true;
		else
			return false;

	}

}
