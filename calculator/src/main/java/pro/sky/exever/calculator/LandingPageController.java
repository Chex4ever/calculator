package pro.sky.exever.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LandingPageController {
	@GetMapping
	public ModelAndView landing(ModelMap model) {
		return new ModelAndView("redirect:/calculator", model);
	}
}
