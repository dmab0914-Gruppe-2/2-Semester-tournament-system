package CtrLayer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ModelLayer.User;

public class UserControllerTest {
	UserController userController;

	@Before
	public void setUp() throws Exception {
		userController = new UserController();
	}

	// @Test
	// public void testAddUser() {
	// fail("Not yet implemented");
	// }

	// @Test
	// public void testAddTeamToUser() {
	// fail("Not yet implemented");
	// }

	@Test
	public void testaddUser() {
		try {
			userController.addUser("handle", "name", "password", true);
		} catch (Exception e) {
			fail("cant insert");
		}
		User u = userController.findUser("name");
		if (u.getName().equals("name")) {

		} else {
			fail("failed cant find new user");
		}
	}

	@Test
	public void testFindUser() {
		if (userController.findUser("Jens") != null) {
		} else
			fail("FAILED");
	}

	@Test
	public void testFindUserByHandle() {
		if (userController.findUserByHandle("superman") != null) {
		} else
			fail("FAILED");
	}

	@Test
	public void testUpdateUser() {
		User u = userController.findUser("Jens");
		
		int i = userController.updateUser(u.getUserID(), "superman", "Jens",
				"password", true);
		if (i == 1) {
		} else
			fail("failed");
	}

	@Test
	public void testDeleteUser() {
		try {
			userController.addUser("test", "test", "password", true);
		} catch (Exception e) {
			fail("cant insert, to delete test");
		}
		
		
		User u = userController.findUser("test");
		int d = userController.deleteUser(u.getUserID());
		if (d == 1) {

		} else
			fail("Not yet implemented");
	}

	@Test
	public void testHashing() throws Exception{
		String password = "password";
		String hashed1 = userController.stringToHash(password);
		String password2 = "password";
		String hashed2 = userController.stringToHash(password2);

		//TEST
		assertEquals(hashed1, hashed2);

		password = "xfjclgghi544ytgoijsl38o92409u*(^&)*(PILOHG75y437tuiflsd785^&I*oij";
		hashed1 = userController.stringToHash(password);
		password2 = "xfjclgghi544ytgoijsl38o92409u*(^&)*(PILOHG75y437tuiflsd785^&I*oij";
		hashed2 = userController.stringToHash(password2);

		//TEST
		assertEquals(hashed1, hashed2);

		password = "guacamole";
		hashed1 = userController.stringToHash(password);
		password2 = "asdf";
		hashed2 = userController.stringToHash(password2);

		//TEST

		assertNotEquals(hashed1, hashed2);
	}

	// @Test
	// public void testGetAllUsers() {
	// fail("Not yet implemented");
	// }

}
