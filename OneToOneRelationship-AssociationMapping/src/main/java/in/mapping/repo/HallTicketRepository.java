package in.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mapping.entity.HallTicket;

public interface HallTicketRepository extends JpaRepository<HallTicket, Integer> {

}
