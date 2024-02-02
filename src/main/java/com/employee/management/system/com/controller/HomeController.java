package com.employee.management.system.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.management.system.com.entities.Emp;
import com.employee.management.system.com.service.EmpService;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {

    @Autowired
    private BCryptPasswordEncoder passwordProvicer;

    @Autowired
    private EmpService empService;

    @GetMapping("/loadEmp")
    public String loadEmpSave(org.springframework.ui.Model model) {
        List<Emp> emp = this.empService.getAllEmp();
        model.addAttribute("emp", emp);
        return "loadEmp";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/showform")
    public String showform() {
        return "showform";
    }

    @PostMapping("/saveEmp")

    public String saveEmp(Model model, Emp emp) {
        emp.setPassword(passwordProvicer.encode(emp.getPassword()));

        Emp emp2 = this.empService.saveEmp(emp);

        return "redirect:/loadEmp";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable int id) {

        boolean empid = empService.delete(id);

        return "redirect:/loadEmp";

    }

    @GetMapping("/updateEmp/{id}")
    public String updateEmp(@PathVariable int id, org.springframework.ui.Model model) {
        Emp emp1 = this.empService.getEmpById(id);
        model.addAttribute("emp1", emp1);

        return "updateEmp";
    }

}
