package demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.model.UserModel;
import demo.repository.Repository;
import demo.service.UserService;

@Controller
public class HomeController {

	@Autowired
	Repository Repository;

	@Autowired
	UserService userservice;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String sample(Model model) {
		model.addAttribute("message", "Welcome to AngularJS...");
		return "home";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("message", "add user");
		return "adduser";
	}

	/*
	 * @RequestMapping(value = "/array", method = RequestMethod.GET) public
	 * String subList(Model model) { model.addAttribute("message",
	 * "add value in form"); return "submitlist"; }
	 */

	/* add user method post */
	@RequestMapping(value = "/addusers", method = RequestMethod.POST)
	@ResponseBody
	public UserModel userRegistration(String fName, String lName, String email) {
		UserModel updated = new UserModel();
		try {
			System.out.println(fName + "" + lName + "" + email);
			updated.setfName(fName);
			updated.setlName(lName);
			updated.setEmail(email);
			userservice.saveUser(updated);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}

	/* Show User Registration view and Table */
	@RequestMapping(value = "/bootform", method = RequestMethod.GET)
	public String bootuser(Model model) {
		model.addAttribute("message", "add value in form");
		return "BootstrapUser";
	}

	/* add user method */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public UserModel userData(String fName, String lName, String email) {
		JSONObject object = new JSONObject();
		UserModel userModel = new UserModel();
		try {
			System.out.println(fName + "" + lName + "" + email);

			userModel.setfName(fName);
			userModel.setlName(lName);
			userModel.setEmail(email);
			Repository.save(userModel);

			object.put("result", "success");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userModel;
	}

	/* return user list */
	@ResponseBody
	@RequestMapping(value = "/userlist", produces = "application/json", method = RequestMethod.GET)
	public Iterable<UserModel> list() {
		Iterable<UserModel> users = userservice.findAllUsers();
		System.out.println(users);
		return users;
	}
}
