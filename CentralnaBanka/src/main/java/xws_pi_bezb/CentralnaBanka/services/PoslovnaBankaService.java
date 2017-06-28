package xws_pi_bezb.CentralnaBanka.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws_pi_bezb.CentralnaBanka.irepositories.IPoslovnaBankaRepository;
import xws_pi_bezb.CentralnaBanka.iservices.IPoslovnaBankaService;
import xws_pi_bezb.CentralnaBanka.models.PoslovnaBanka;

@Service
public class PoslovnaBankaService implements IPoslovnaBankaService{

	@Autowired
	private IPoslovnaBankaRepository bankaRepository;
	
	@Override
	public List<PoslovnaBanka> findAll() {
		return bankaRepository.findAll();
	}

	@Override
	public PoslovnaBanka findOne(Long id) {
		return bankaRepository.findById(id);
	}

	@Override
	public PoslovnaBanka findBySwiftKod(String swiftDuznik) {
		return bankaRepository.findBySwiftKod(swiftDuznik);
	}

	@Override
	public void save(PoslovnaBanka banka) {
		bankaRepository.save(banka);
	}

}
