package xws_pi_bezb.CentralnaBanka.iservices;

import java.util.List;

import xws_pi_bezb.CentralnaBanka.models.PoslovnaBanka;

public interface IPoslovnaBankaService {

	List<PoslovnaBanka> findAll();
	
	PoslovnaBanka findOne(Long id);
}
