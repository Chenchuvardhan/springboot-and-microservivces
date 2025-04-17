package in.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.disney.entity.State;

public interface StateReposiotry extends JpaRepository<State, Integer> {
public abstract List<State> findByCountryCid(Integer cid);
}
