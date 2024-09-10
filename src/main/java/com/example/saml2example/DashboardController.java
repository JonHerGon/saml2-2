package com.example.saml2example;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the home page.
 */
@Controller
@RequestMapping("/")
public class DashboardController {

    @GetMapping("/index")
    public String showDashboard() {
        return "index";  // Devuelve el nombre de la vista (sin la extensión .html)
    }

    @GetMapping("/api/dashboard")
    public String showApiDashboard(Model model, @AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
        String email = principal.getFirstAttribute("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/emailaddress");  // Atributo personalizado
        String username = principal.getFirstAttribute("http://schemas.auth0.com/nickname");  // Atributo personalizado
        model.addAttribute("attributes", principal.getAttributes());
        model.addAttribute("username", username);
        model.addAttribute("email", email);

        return "dashboard";  // Devuelve el nombre de la vista (sin la extensión .html)
    }

    @GetMapping("/logged-out")
    public String showLoggedOutPage() {
        return "logged-out";  // Redirige a una página de despedida
    }
}