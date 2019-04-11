package com.davidlangheiter.prime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class Web {

    @Autowired
    Searcher searcher;

    @GetMapping("/primes")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/primes/searcher");
    }

    @GetMapping("/primes/searcher")
    public String getPrime(Model model) {
        model.addAttribute("started", searcher.getStart());
        //model.addAttribute("latestPrime", searcher.getPrime().toString());
        //model.addAttribute("foundAt", searcher.getLastFound().toString());
        return "prime";
    }

}
