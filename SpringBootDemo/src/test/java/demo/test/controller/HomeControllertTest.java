package demo.test.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import demo.controller.HomeController;
import demo.model.UserModel;
import demo.repository.Repository;
import demo.service.UserService;

public class HomeControllertTest {

	/*
	 * @Rule public WireMockRule wiremock = new WireMockRule()
	 */;

	@InjectMocks
	private HomeController homeController;

	@Mock
	private UserService service;

	@Mock
	private UserModel userModel;

	private UserModel model;
	private List<UserModel> list;


	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
		userModel.setfName("ashutosh");
		userModel.setlName("chawra");
		userModel.setEmail("ashutosh@gmail.com");

	/*	UserModel u1 = new UserModel();
		u1.setfName("kabir");
		u1.setlName("sharma");
		u1.setEmail("kabir@gmail.com");

		list = new ArrayList<UserModel>();
		list.add(userModel);
		list.add(u1);
*/
	}

	/*
	 * @Test public void testUserRegister() {
	 * when(repository.save(any(UserModel.class))).thenReturn(userModel);
	 * UserModel user = service.saveUser(userModel); assertThat(user,
	 * is(equalTo(userModel)));
	 * 
	 * }
	 */

	@Test
	public void testUserRegisteration() {
		when(service.saveUser(any(UserModel.class))).thenReturn(userModel);
		//System.out.println(userModel.toString());
		UserModel model = homeController.userRegistration("ashutosh", "chawra", "ashutosh@gmail.com");
		assertEquals(model.getfName(), userModel.getfName());
		assertEquals(model.getlName(), userModel.getlName());
		assertEquals(model.getEmail(), userModel.getEmail());
		System.out.println(userModel.getfName());
		System.out.println(model.getfName());
	

	}

	@Ignore
	@Test
	public void testUserList() {
		List<UserModel> l;
		when(service.findAllUsers()).thenReturn(list);
		l = (List<UserModel>) homeController.list();
		model = new UserModel();
		model.setfName("ashutosh");
		model.setlName("chawra");
		model.setEmail("ashutosh@gmail.com");
		UserModel model1 = new UserModel();
		model1.setfName("kabir");
		model1.setlName("sharma");
		model1.setEmail("kabir@gmail.com");
		l.add(model);
		l.add(model1);

		assertThat(userModel.getfName(), is(equalTo(model.getfName())));
	}

}
