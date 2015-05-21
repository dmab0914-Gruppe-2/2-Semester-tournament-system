package CtrLayer;

import ModelLayer.Match;
import ModelLayer.Team;
import ModelLayer.User;
import ModelLayer.WrongDataInputException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Andreas on 13-05-2015.
 */
public class TestEliminationController {
    EliminationController eliminationController;
    @Before
    public void setUp() throws Exception {
        eliminationController = new EliminationController();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGenerateRoundCase1() throws Exception {


        int i= 0;
        ArrayList<Team> teams = new ArrayList<>();
        while(i!=10){
            String s = "The Awesome Thingy No." + Integer.toString(i);
            Team team = new Team(s, new ArrayList<User>());
            teams.add(team);
            i++;
        }

        ArrayList<Integer> scores = new ArrayList<>();
        i = 0;
        while(i!=10){
            Random rnd = new Random();
            int score = rnd.nextInt(10);
            scores.add(score);
            i++;
        }

        ArrayList<Match> matches = eliminationController.generateRound(teams, scores);

        assertEquals(5, matches.size());



    }

    @Test
    public void testGenerateRoundCase2() throws Exception {


        int i= 0;
        ArrayList<Team> teams = new ArrayList<>();
        while(i!=9){
            String s = "The Awesome Thingy No." + Integer.toString(i);
            Team team = new Team(s, new ArrayList<User>());
            teams.add(team);
            i++;
        }

        ArrayList<Integer> scores = new ArrayList<>();
        i = 0;
        while(i!=9){
            Random rnd = new Random();
            int score = rnd.nextInt(10);
            scores.add(score);
            i++;
        }

        ArrayList<Match> matches = eliminationController.generateRound(teams, scores);

        assertEquals(5, matches.size());
    }


    @Test (expected = WrongDataInputException.class)
    public void testGenerateRoundCase3() throws Exception {
        int i= 0;
        ArrayList<Team> teams = new ArrayList<>();
        while(i<10){
            String s = "The Awesome Thingy No." + Integer.toString(i);
            Team team = new Team(s, new ArrayList<User>());
            teams.add(team);
            i++;
        }

        ArrayList<Integer> scores = new ArrayList<>();
        i = 0;
        while(i<=11){
            Random rnd = new Random();
            int score = rnd.nextInt(10);
            scores.add(score);
            i++;
        }

        eliminationController.generateRound(teams, scores);
    }

    @Test
    public void testGenerateRoundCase4() throws Exception {
        int i= 0;
        ArrayList<Team> teams = new ArrayList<>();
        while(i!=10){
            String s = "The Awesome Thingy No." + Integer.toString(i);
            Team team = new Team(s, new ArrayList<User>());
            teams.add(team);
            i++;
        }
        ArrayList<Match> matches = eliminationController.generateRound(teams, new ArrayList<Integer>());
        assertEquals(5, matches.size());
    }

    @Test
    public void testGenerateRoundCase5() throws Exception {

        int i= 0;
        ArrayList<Team> teams = new ArrayList<>();
        while(i!=9){
            String s = "The Awesome Thingy No." + Integer.toString(i);
            Team team = new Team(s, new ArrayList<User>());
            teams.add(team);
            i++;
        }
        ArrayList<Match> matches = eliminationController.generateRound(teams, new ArrayList<Integer>());
        assertEquals(5, matches.size());
    }
}