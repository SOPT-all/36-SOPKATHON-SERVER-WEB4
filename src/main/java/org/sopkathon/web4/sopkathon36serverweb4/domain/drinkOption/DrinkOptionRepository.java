package org.sopkathon.web4.sopkathon36serverweb4.domain.drinkOption;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DrinkOptionRepository extends JpaRepository<DrinkOption, Long> {

  @Query("""
    SELECT d.drink.id AS drinkId, COUNT(d.drink.id) AS cnt
    FROM DrinkOption d
    WHERE d.option.id IN :optionIds
    GROUP BY d.drink.id
    HAVING COUNT(d.drink.id) = 4
    ORDER BY cnt DESC
    """)
  Optional<DrinkOptionCountDto> findFirstByOptionIds(@Param("optionIds") List<Long> optionIds);
}
