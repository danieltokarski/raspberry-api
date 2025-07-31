package com.outeseratest.raspberry.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.outeseratest.raspberry.infrastructure.entity.MovieEntity;

@Repository
public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {
	
	List<MovieEntity> findByWinner(boolean winner);
	
}