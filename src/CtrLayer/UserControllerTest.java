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

		int i = userController.updateUser(u.getUserID(), "hallooo", "Jens",
				"password", false);
		if (i == 1) {
		} else
			fail("failed");
	}

	@Test
	public void testDeleteUser() {
		User u = userController.findUser("name");
		int d = userController.deleteUser(u.getUserID());
		if (d == 1) {

		} else
			fail("Not yet implemented");
	}

	// @Test
	// public void testGetAllUsers() {
	// fail("Not yet implemented");
	// }

}
