package com.kunjava.controller;

import com.kunjava.domain.Account;
import com.kunjava.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/list")
    public String findAll(Model model){
        System.out.println("Controller：findAll...");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("save")
    public String saveAccount(Account account){
        accountService.saveAccout(account);
        return "forward:/account/list";
    }

}
