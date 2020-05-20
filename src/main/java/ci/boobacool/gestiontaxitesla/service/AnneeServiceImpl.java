package ci.boobacool.gestiontaxitesla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ci.boobacool.gestiontaxitesla.domain.Annee;
import ci.boobacool.gestiontaxitesla.repositories.AnneeRepository;
@Service
public class AnneeServiceImpl {

	@Autowired
	private AnneeRepository anneeRepository;

	public List<Annee> listeAnnees() {
		return anneeRepository.findAll();
	}
	public Page<Annee> findAllPageable(int page, int size) {
		return anneeRepository.findAll(PageRequest.of(page, size));
	}

	public Optional<Annee> findById(Long id) {
		return anneeRepository.findById(id);
	}

	public Annee saveAnnee(Annee annee) {
		return anneeRepository.save(annee);
	}

	public boolean isAnneeExist(Annee annee) {

		if (anneeRepository.existsById(annee.getId()) || isAnneeByLibelle(annee))
			return true;
		else
			return false;
	}

	public Boolean isAnneeByLibelle(Annee annee) {
		Annee an = anneeRepository.findByLibelle(annee.getLibelle());
		if (an != null)
			return true;
		else
			return false;

	}
	
	public void deleteAnnee(Annee annee) {
		anneeRepository.delete(annee);
	}

}
