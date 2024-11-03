package ovh.mariage.api;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ovh.mariage.model.RequestUserForm;
import ovh.mariage.model.User;
import ovh.mariage.services.DB;

@RestController
public class MariageController {

	@GetMapping("/")
	public ModelAndView getRoot(@RequestParam(value = "code") String code, HttpSession session) {
		//ModelAndView fail = new ModelAndView("404.html");
		String modelName = "homeFrGr.html";
        try {
            User user = DB.getInstance().loadUserByCode(code);
            session.setAttribute("user", user);
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
	
	@GetMapping("/response")
	public ModelAndView response(@RequestParam(value = "rep", required = false) String rep, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		if (user == null)
			throw new RuntimeException("Session user is null!");
		try {
			DB.getInstance().storeResponse(user.getId(), rep);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!rep.equalsIgnoreCase("yes")) {
			return new ModelAndView("seeYouSoon.html");
		}
		ModelAndView model = null;
		switch (user.getLang()){
		case "de": model = new ModelAndView("formDe.html");break;
		case "en": model = new ModelAndView("formEn.html");break;
		default : model = new ModelAndView("formFr.html");break;
		}
		model.addObject("user", user);
		model.addObject("userForm", new RequestUserForm());
		return model;
	}
	
	@PostMapping("/userform")
	public ModelAndView userForm(@ModelAttribute RequestUserForm userForm, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null)
			throw new RuntimeException("Session user is null!");
		try {
			DB.getInstance().storeHotelResponse(user.getId(), userForm.isTakeHotel());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/info?lang="+user.getLang());
	}
	
	@GetMapping("/info")
	public ModelAndView info(@RequestParam(value = "lang", required = false) String rep) {
		switch (rep){
		case "de": return new ModelAndView("infoDe.html");
		case "en": return new ModelAndView("infoFr.html");
		default : return new ModelAndView("infoFr.html");
		}
	}
	
}
