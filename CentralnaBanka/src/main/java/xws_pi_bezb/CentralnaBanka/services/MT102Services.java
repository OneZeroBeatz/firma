package xws_pi_bezb.CentralnaBanka.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws_pi_bezb.CentralnaBanka.irepositories.IMT102Repository;
import xws_pi_bezb.CentralnaBanka.iservices.IMT102Services;
import xws_pi_bezb.CentralnaBanka.models.MT102;

@Service
public class MT102Services implements IMT102Services {

	@Autowired
	private IMT102Repository repo;

	@Override
	public void save(MT102 mt102) {
		repo.save(mt102);

	}

	@Override
	public void delete(MT102 mt102) {
		repo.delete(mt102);

	}

	@Override
	public List<MT102> findAll() {

		return repo.findAll();
	}

	@Override
	public MT102 findOne(Long id) {

		return repo.findById(id);
	}

	@Override
	public MT102 findByIdPoruke(String idPorukeNaloga) {
		return repo.findByIdPoruke(idPorukeNaloga);
	}

	@Override
	public List<MT102> findByObradjen(boolean b) {
		return repo.findByObradjen(b);
	}

}
