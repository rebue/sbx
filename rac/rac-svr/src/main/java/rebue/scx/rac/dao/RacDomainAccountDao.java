package rebue.scx.rac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rebue.scx.rac.jo.RacDomainAccountJo;

public interface RacDomainAccountDao extends JpaRepository<RacDomainAccountJo, java.lang.Long> {
}
