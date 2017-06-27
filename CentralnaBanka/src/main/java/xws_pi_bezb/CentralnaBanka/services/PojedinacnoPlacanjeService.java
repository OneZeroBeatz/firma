package xws_pi_bezb.CentralnaBanka.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws_pi_bezb.CentralnaBanka.irepositories.IPojedinacnoPlacanje;
import xws_pi_bezb.CentralnaBanka.iservices.IPojedinacnoPlacanjeService;
import xws_pi_bezb.CentralnaBanka.models.PojedinacnoPlacanje;

@Service
public class PojedinacnoPlacanjeService implements IPojedinacnoPlacanjeService{

	
	@Autowired
	private IPojedinacnoPlacanje repo;
	
	
	@Override
	public PojedinacnoPlacanje save(PojedinacnoPlacanje pp) {
		return repo.save(pp);
	}

	@Override
	public void delete(PojedinacnoPlacanje pp) {
		repo.delete(pp);
		
	}

	@Override
	public List<PojedinacnoPlacanje> findAll() {
		
		return repo.findAll();
	}

	@Override
	public PojedinacnoPlacanje findOne(Long id) {
		
		return repo.findById(id);
	}

}
