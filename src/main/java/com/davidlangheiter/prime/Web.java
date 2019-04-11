package com.davidlangheiter.prime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Web {

    @GetMapping("/primes")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/primes/searcher");
    }

    @GetMapping("/primes/searcher")
    public String getPrime() {
        return "index";
    }

}
