package com.employee.management.system.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.employee.management.system.com.doa.UserRepo;
import com.employee.management.system.com.entities.Emp;

public class EmpDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Emp e1 = this.userRepo.getEmpByEmpName(username);

        if (e1 == null) {
            throw new UsernameNotFoundException("could not found user");
        }

        EmpDetails empDetails = new EmpDetails(e1);
        return empDetails;
    }

}
