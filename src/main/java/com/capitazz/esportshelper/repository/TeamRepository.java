package com.capitazz.esportshelper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitazz.esportshelper.model.Team;

/**
 * Репозиторий для работы с командами {@link Team}.
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByNameContaining(String filter);

}
