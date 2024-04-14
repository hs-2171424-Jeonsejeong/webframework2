package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import kr.ac.hansung.cse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLogin(@RequestParam(value="error", required = false) String error,
                            @RequestParam(value="logout", required = false) String logout,
                            Model model) {

        if(error != null) {
            model.addAttribute("errorMsg","Invalid username or password");
        }

        if(logout != null) {
            model.addAttribute("logoutMsg", "You have been logged out successfully ");
        }

        return "login";
    }

    @GetMapping("/logout")
    public String showLogout() {
        userService.authenticateUser(null, null);
        return "logout";
    }

    @PostMapping("/auth")
    public String performLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        boolean isAuthenticated = userService.authenticateUser(username, password);

        if (isAuthenticated) {
            return "login";
        } else {
            model.addAttribute("errorMsg", "Invalid username or password");
            return "login";
        }
    }
}
