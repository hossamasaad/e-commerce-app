package com.hossam.ecommerce.auth.repo;

import com.hossam.ecommerce.auth.model.AdminToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface AdminTokenRepository extends JpaRepository<AdminToken, Integer> {

    @Query(value = """
      select t from AdminToken t inner join Admin u\s
      on t.admin.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<AdminToken> findAllValidTokenByAdmin(Integer id);

    Optional<AdminToken> findByToken(String token);
}