package in.counceller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.counceller.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {
    @Query(nativeQuery =true,value="select * from enquiry where cid=?1")
	public List<Enquiry> findAllByCid(int cid);
}
