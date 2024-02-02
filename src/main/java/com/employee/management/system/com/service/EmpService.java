package com.employee.management.system.com.service;

import java.util.List;

import com.employee.management.system.com.entities.Emp;

public interface EmpService {

    public Emp saveEmp(Emp emp);

    List<Emp> getAllEmp();

    public boolean delete(int id);

    public Emp getEmpById(int id);
}
