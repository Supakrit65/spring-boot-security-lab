package ku.kinkao.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("greeting", "สวัสดีครับ");
        return "home";  // name of a html template: home.html
    }
}
