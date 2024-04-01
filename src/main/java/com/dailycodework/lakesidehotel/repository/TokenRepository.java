package com.dailycodework.lakesidehotel.repository;

import com.dailycodework.lakesidehotel.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query(value = "select t from Token t inner join User u on t.user.id = u.id" +
            "      where u.id = :id and (t.expired = false or t.revoked = false)")
    List<Token> findAllValidTokenByUser(Integer id);

    @Query(value = "select t from Token  t where t.token = :token")
    Optional<Token> findByToken(String token);
}
