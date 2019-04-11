package com.davidlangheiter.prime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Web {

    @Autowired
    SearchRunner searchRunner;

    @GetMapping("/primes")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/primes/searcher");
    }

    @GetMapping("/primes/searcher")
    public String getPrime(Model model) {
        model.addAttribute("started", searchRunner.getStart());
        model.addAttribute("latestPrime", searchRunner.getLastPrime());
        model.addAttribute("foundAt", searchRunner.getLastFound());
        return "prime";
    }

}
