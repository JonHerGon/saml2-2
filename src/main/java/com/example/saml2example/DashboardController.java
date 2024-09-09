package com.example.saml2example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the home page.
 */
@Controller
@RequestMapping("/")
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "index";  // Devuelve el nombre de la vista (sin la extensión .html)
    }

    @GetMapping("/api/dashboard")
    public String showApiDashboard() {
        return "dashboard";  // Devuelve el nombre de la vista (sin la extensión .html)
    }

    @GetMapping("/logged-out")
    public String showLoggedOutPage() {
        return "logged-out";  // Redirige a una página de despedida
    }
}