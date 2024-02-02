package com.employee.management.system.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.system.com.doa.UserRepo;
import com.employee.management.system.com.entities.Emp;

@Service
public class EmpServiceImple implements EmpService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Emp saveEmp(Emp emp) {

        Emp emp1 = this.userRepo.save(emp);
        return emp1;

    }

    @Override
    public List<Emp> getAllEmp() {

        return (List<Emp>) this.userRepo.findAll();

    }

    @Override
    public boolean delete(int id) {
        Emp e1 = this.userRepo.findById(id).get();

        if (e1 != null) {
            userRepo.delete(e1);
            return true;

        }
        return false;

    }

    @Override
    public Emp getEmpById(int id) {
        return this.userRepo.findById(id).get();
    }

}
