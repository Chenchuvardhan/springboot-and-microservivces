package in.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.general.entity.Hosteller;

public interface HostellerRepository extends JpaRepository<Hosteller, Integer> {

}
