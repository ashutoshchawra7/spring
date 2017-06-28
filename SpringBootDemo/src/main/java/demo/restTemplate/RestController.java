package demo.restTemplate;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import demo.model.UserModel;

public class RestController {

	public static void main(String[] args) {

		// userList();
		addUserHere();
	}

	
      /*get user list*/	
	public static String userList() {

		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8888/userlist";
		String result = template.getForObject(url, String.class);
	  // String result = template.postForObject(url, null, String.class);
		System.out.println(result);
		return result;
	}

	/*add user method*/
	public static UserModel addUserHere() {
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8888/addusers";
		UserModel result = new UserModel();
		
		MultiValueMap<String, String> urivariable = new LinkedMultiValueMap<>();
		urivariable.add("fName", "Sachin");
		urivariable.add("lName", "new");
		urivariable.add("email", "sachin.new@gmail.com");
		result = template.postForObject(url, urivariable, UserModel.class);
		
		System.out.println(result);
		return result;
	}
}
