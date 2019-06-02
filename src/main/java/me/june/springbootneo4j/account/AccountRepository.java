package me.june.springbootneo4j.account;

import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-06-02
 * Time: 20:55
 **/
public interface AccountRepository extends Neo4jRepository<Account, Long> {
}
