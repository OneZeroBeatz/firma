package xws_pi_bezb.CentralnaBanka.iservices;

import java.util.List;

import xws_pi_bezb.CentralnaBanka.models.PojedinacnoPlacanje;

public interface IPojedinacnoPlacanjeService {

	PojedinacnoPlacanje save(PojedinacnoPlacanje pp);

	void delete(PojedinacnoPlacanje pp);

	List<PojedinacnoPlacanje> findAll();

	PojedinacnoPlacanje findOne(Long id);

}
