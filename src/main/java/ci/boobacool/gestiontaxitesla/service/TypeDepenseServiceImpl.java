package ci.boobacool.gestiontaxitesla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ci.boobacool.gestiontaxitesla.domain.TypeDepense;
import ci.boobacool.gestiontaxitesla.repositories.TypeDepenseRepository;

@Service
public class TypeDepenseServiceImpl {
	@Autowired
	private TypeDepenseRepository typeDepenseRepository;
	
	public Optional<TypeDepense> findById(Long id){
		return typeDepenseRepository.findById(id);
	}
	
	public List<TypeDepense> listeTD(){
		return typeDepenseRepository.findAll();
	}
	
	public Page<TypeDepense> findAllPageable(int page, int size) {
		return typeDepenseRepository.findAll(PageRequest.of(page, size));
	}
	
	public TypeDepense saveTD(TypeDepense typeDepense) {
		return typeDepenseRepository.save(typeDepense);
	}
	
	public void deleteTD(TypeDepense typeDepense) {
		typeDepenseRepository.delete(typeDepense);
	}
	
	public Boolean isExistTD(TypeDepense typeDepense) {
		return typeDepenseRepository.findByLibelle(typeDepense.getLibelle()) != null;
	}

}
