package xws_pi_bezb.CentralnaBanka.iservices;

import java.util.List;

import xws_pi_bezb.CentralnaBanka.models.MT102;


public interface IMT102Services {

	void save(MT102 mt102);

	void delete(MT102 mt102);

	List<MT102> findAll();

	MT102 findOne(Long id);

	MT102 findByIdPoruke(String idPorukeNaloga);

	MT102 findBySwiftDuznikAndSwiftPoverilacAndPoslat(String swiftKod, String swiftKod2, boolean poslat);

}
