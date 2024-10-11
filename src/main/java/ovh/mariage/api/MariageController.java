package ovh.mariage.api;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ovh.mariage.model.User;
import ovh.mariage.services.DB;

@RestController
public class MariageController {

	@GetMapping("/")
	public ModelAndView getRoot(@RequestParam(value = "code") String code) {
		//ModelAndView fail = new ModelAndView("404.html");
		String modelName = "homeFrGr.html";
        try {
            User user = DB.getInstance().loadUserByCode(code);
            switch (user.getLang()) {
			case "fr":
				modelName = (user.isSolo())? (user.getType().equals("M"))?"homeFrSoloM.html":"homeFrSoloF"  :"homeFrGr.html";
				break;
			case "de":
				modelName = "homeDeGr.html";
				break;
			case "en":
				modelName = "homeEnGr.html";

			default:
				break;
			}
            ModelAndView model = new ModelAndView(modelName);
            model.addObject("user", user);
            return model;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return fail;
	}
	
	@GetMapping("/test")
	public String test() {
		return "test OK";
	}
}
