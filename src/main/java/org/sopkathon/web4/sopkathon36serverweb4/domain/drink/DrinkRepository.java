package org.sopkathon.web4.sopkathon36serverweb4.domain.drink;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

  Optional<Drink> findFirstById(Long id);
}
