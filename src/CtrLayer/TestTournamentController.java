/**
 * 
 */
package CtrLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DBLayer.DBTournament;
import ModelLayer.Tournament;
import ModelLayer.Tournament.Status;

/**
 * @author Jacob 26/05/2015
 *
 */
public class TestTournamentController {
	
	static DBTournament dbTournament;
	static TournamentController tournamentController;
	static int id1;
	static int id2;
	static String gameName1;
	static String gameName2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gameName1 = "Counter-Strike:GO";
		gameName2 = "League Of Legends";
		dbTournament = new DBTournament();
		tournamentController = new TournamentController();
		//Creates test data to be used
		Tournament tournament1 = new Tournament("CS tournament", gameName1, 5, true, Status.waiting);
		Tournament tournament2 = new Tournament("League Tournament", gameName2, 6, true, Status.waiting);
		//Adds the created test data to the database, and saves it's database id so it can be removed later during test teardown.
		id1 = dbTournament.addTournament(tournament1).getId();
		id2 = dbTournament.addTournament(tournament2).getId();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dbTournament.removeTournament(id1);
		dbTournament.removeTournament(id2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link CtrLayer.TournamentController#getTournaments()}.
	 */
	@Test
	public void testGetTournaments() {
		ArrayList<Tournament> tournaments = tournamentController.getTournaments();
		Tournament tournament1 = null;
		Tournament tournament2 = null;
		//Loops through all the tournaments from the database, and finds the two that were inserted @BeforeClass
		for(int i = 0; i < tournaments.size(); i++) {
			if(tournaments.get(i).getId() == id1) {
				tournament1 = tournaments.get(i);
			}
			else if(tournaments.get(i).getId() == id2) {
				tournament2 = tournaments.get(i);
			}
		}
		//Checks if the retrieved tournaments game names, matches what they're expected to be.
		assertEquals(gameName1, tournament1.getGameName());
		assertEquals(gameName2, tournament2.getGameName());
	}

	/**
	 * Test method for {@link CtrLayer.TournamentController#getTournamet(int)}.
	 */
	@Test
	public void testGetTournamet() {
		Tournament tournament1 = tournamentController.getTournament(id1);
		Tournament tournament2 = tournamentController.getTournament(id2);
		assertEquals(gameName1, tournament1.getGameName());
		assertEquals(gameName2, tournament2.getGameName());
	}

	/**
	 * Test method for {@link CtrLayer.TournamentController#enableSignup(int)}.
	 */
	@Test
	public void testEnableSignup() {
		assertEquals(true, tournamentController.enableSignup(id1));
	}

	/**
	 * Test method for {@link CtrLayer.TournamentController#startTournament(int)}.
	 */
	@Test
	public void testStartTournament() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link CtrLayer.TournamentController#setMatchResults(int, int, int)}.
	 */
	@Test
	public void testSetMatchResults() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link CtrLayer.TournamentController#advanceTournament(int)}.
	 */
	@Test
	public void testAdvanceTournament() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link CtrLayer.TournamentController#endTournament(int)}.
	 */
	@Test
	public void testEndTournament() {
		fail("Not yet implemented"); // TODO
	}

}
