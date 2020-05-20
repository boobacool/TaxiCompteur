package ci.boobacool.gestiontaxitesla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ci.boobacool.gestiontaxitesla.domain.Taxi;
import ci.boobacool.gestiontaxitesla.repositories.TaxiRepository;
@Service
public class TaxiServiceImpl {
	@Autowired
	private TaxiRepository taxiRepository;
	
	public Optional<Taxi> findById(Long id){
		return taxiRepository.findById(id);
	}
	
	public List<Taxi> findByAll(){
		return taxiRepository.findAll();
	}
	
	public Page<Taxi> findAllPageable(int page, int size) {
		return taxiRepository.findAll(PageRequest.of(page, size));
	}

	public Taxi saveTaxi(Taxi taxi) {
		return taxiRepository.save(taxi);
	}
	public void deleteTaxi(Taxi taxi) {
		taxiRepository.delete(taxi);
	}
	
	public Boolean isExistTaxi(Taxi taxi) {
		return taxiRepository.findByImmat(taxi.getImmat())!=null;
	}
}
