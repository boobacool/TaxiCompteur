package ci.boobacool.gestiontaxitesla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ci.boobacool.gestiontaxitesla.domain.Chauffeur;
import ci.boobacool.gestiontaxitesla.repositories.ChauffeurRepository;

@Service
public class ChauffeurServiceImpl {

	@Autowired
	private ChauffeurRepository chauffeurRepository;

	public Chauffeur saveChauffeur(Chauffeur chauffeur) {
		return chauffeurRepository.save(chauffeur);
	}

	public List<Chauffeur> listeChauffeur() {
		return chauffeurRepository.findAll();
	}

	public void deleteChauffeur(Chauffeur chauffeur) {
		chauffeurRepository.delete(chauffeur);
	}

	public Boolean isChauffeurExist(Chauffeur chauffeur) {
		return chauffeurRepository.existsById(chauffeur.getId()) || isChauffeurCNI(chauffeur)
				|| isChauffeurContact(chauffeur);

	}

	public Boolean isChauffeurCNI(Chauffeur chauffeur) {
		Chauffeur ch = chauffeurRepository.findByCni(chauffeur.getCni());
		if (ch != null)
			return true;
		return false;
	}

	public Boolean isChauffeurContact(Chauffeur chauffeur) {
		Chauffeur ch = chauffeurRepository.findByContact(chauffeur.getContact());
		if (ch != null)
			return true;
		return false;
	}
	
	public Page<Chauffeur> pageChauffeur(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "keyword", defaultValue = "") String mc) {
		return chauffeurRepository.findAll(PageRequest.of(page, size));
	}

}
