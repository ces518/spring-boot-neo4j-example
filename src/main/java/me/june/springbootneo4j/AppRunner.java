package me.june.springbootneo4j;

import me.june.springbootneo4j.account.Account;
import me.june.springbootneo4j.account.AccountRepository;
import me.june.springbootneo4j.account.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-06-02
 * Time: 20:49
 **/
@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Session session = sessionFactory.openSession();

        Account account = new Account();
        account.setUsername("pjy");
        account.setPassword("june");


        Role role = new Role();
        role.setName("ADMIN");

        account.getRoles().add(role);

        session.save(account);
        session.clear(); // session의 캐싱된 객체를 클리어
        sessionFactory.close();

        System.out.println("====== DONE =======");
    }
}
