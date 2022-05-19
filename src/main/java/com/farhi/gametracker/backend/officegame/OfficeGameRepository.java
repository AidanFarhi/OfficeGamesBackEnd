package com.farhi.gametracker.backend.officegame;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeGameRepository extends JpaRepository<OfficeGame, Long> {
}
