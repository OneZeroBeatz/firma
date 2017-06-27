package xws_pi_bezb.CentralnaBanka.irepositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws_pi_bezb.CentralnaBanka.models.PoslovnaBanka;

@Repository
@Transactional
public interface IPoslovnaBankaRepository extends JpaRepository<PoslovnaBanka, Long>{	
	PoslovnaBanka findById(Long id);	
}