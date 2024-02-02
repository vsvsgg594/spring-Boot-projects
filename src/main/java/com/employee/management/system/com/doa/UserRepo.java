package com.employee.management.system.com.doa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.employee.management.system.com.entities.Emp;

public interface UserRepo extends CrudRepository<Emp, Integer> {

    @Query("select u from Emp u where u.email=:email")
    public Emp getEmpByEmpName(@Param("email") String email);

}
