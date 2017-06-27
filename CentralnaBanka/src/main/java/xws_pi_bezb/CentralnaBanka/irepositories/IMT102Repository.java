package xws_pi_bezb.CentralnaBanka.irepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xws_pi_bezb.CentralnaBanka.models.MT102;

@Repository
@Transactional
public interface IMT102Repository extends JpaRepository<MT102, Long>{

	List<MT102> findAll();
	MT102 findById(Long id);
	MT102 findByIdPoruke(String idPorukeNaloga);
	MT102 findBySwiftDuznikAndSwiftPoverilacAndPoslat(String swiftKod, String swiftKod2, boolean poslat);
	
	
	
}
