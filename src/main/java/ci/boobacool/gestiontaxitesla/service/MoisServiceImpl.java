package ci.boobacool.gestiontaxitesla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ci.boobacool.gestiontaxitesla.domain.Mois;
import ci.boobacool.gestiontaxitesla.repositories.MoisRepository;
@Service
public class MoisServiceImpl {
	@Autowired
	private MoisRepository moisRepository;
	
	public Optional<Mois> findById(Long id){
		return moisRepository.findById(id);
	}
	
	public List<Mois> listeMois(){
		return moisRepository.findAll();
	}
	public Page<Mois> findAllPageable(int page, int size) {
		return moisRepository.findAll(PageRequest.of(page, size));
	}
	
	public Mois saveMois(Mois mois) {
		return moisRepository.save(mois);
	}
	
	public void deleteMois(Mois mois) {
		moisRepository.delete(mois);
	}
	public boolean isMoisExist(Mois mois) {

		if (moisRepository.existsById(mois.getId()) || isMoisByLibelle(mois))
			return true;
		else
			return false;
	}

	public Boolean isMoisByLibelle(Mois mois) {
		Mois m = moisRepository.findByLibelle(mois.getLibelle());
		if (m != null)
			return true;
		else
			return false;

	}

}
