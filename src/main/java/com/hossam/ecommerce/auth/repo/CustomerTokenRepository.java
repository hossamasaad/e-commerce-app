package com.hossam.ecommerce.auth.repo;

import com.hossam.ecommerce.auth.model.CustomerToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerTokenRepository extends JpaRepository<CustomerToken, Integer> {

    @Query(value = """
      select t from CustomerToken t inner join Customer u\s
      on t.customer.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<CustomerToken> findAllValidTokenByCustomer(Integer id);

    Optional<CustomerToken> findByToken(String token);
}
