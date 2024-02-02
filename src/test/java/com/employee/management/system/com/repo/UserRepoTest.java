package com.employee.management.system.com.repo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.management.system.com.doa.UserRepo;
import com.employee.management.system.com.entities.Emp;

@SpringBootTest
public class UserRepoTest {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private Emp emp;

    @Test
    void testGetEmpByEmpName() {
        // emp = new Emp("shipi", "cse", "d1", "2020-10-10", "23400",
        // "efevevev@gamil.com", "123321", "user");
        // userRepo.save(emp);
        // Optional<Emp> ans = userRepo.findById(10102);
        // assertThat(ans).isEmpty();
        Emp e1 = userRepo.getEmpByEmpName("shekhar@gmail.com");
        System.out.println(e1);
        assertThat(e1).isNotNull();

    }
}

// this.id = id;
// this.name = name;
// this.department = department;
// this.dp = dp;
// this.jd = jd;
// this.salary = salary;
// this.email = email;
// this.password = password;
// this.role = rol