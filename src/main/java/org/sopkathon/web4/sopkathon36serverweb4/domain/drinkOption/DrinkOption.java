package org.sopkathon.web4.sopkathon36serverweb4.domain.drinkOption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.drink.Drink;
import org.sopkathon.web4.sopkathon36serverweb4.domain.options.Option;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.entity.BaseEntity;

@Entity
@Getter
@Table(name = "drink_options")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DrinkOption extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // PK가 명확하지 않으면 임시 PK 추가

  // Drink와 다대일 관계 (N:1)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "drink_id", nullable = false)
  private Drink drink;

  // Option과 다대일 관계 (N:1)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "option_id", nullable = false)
  private Option option;

  @Builder
  public DrinkOption(final Drink drink, final Option option) {
    this.option = option;
    this.drink = drink;
  }
}
