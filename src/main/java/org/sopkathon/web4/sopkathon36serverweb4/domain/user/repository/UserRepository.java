package org.sopkathon.web4.sopkathon36serverweb4.domain.user.repository;

import org.sopkathon.web4.sopkathon36serverweb4.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
