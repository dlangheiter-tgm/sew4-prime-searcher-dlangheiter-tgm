package com.davidlangheiter.prime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class Web {

    @GetMapping("/primes")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/primes/searcher");
    }

    @GetMapping("/primes/searcher")
    public String getPrime(Model model) {
        model.addAttribute("started", new Date().toLocaleString());
        model.addAttribute("latestPrime", "13");
        model.addAttribute("foundAt", new Date().toLocaleString());
        return "prime";
    }

}
