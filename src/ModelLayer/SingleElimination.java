package ModelLayer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Andreas on 09-05-2015.
 */
public class SingleElimination {


    public SingleElimination() {

    }//endConstructor

    public ArrayList<Match> generateSERound(ArrayList<Team> teams, ArrayList<Integer> scores) {

        ArrayList<Match> matches = new ArrayList<>();
        if (scores.size() == 0) {

            if (teams.size() % 2 == 0 || teams.size() == 2) {
                System.out.println("Teams are divisible by two, number of teams: " + teams.size());

                while(teams.size() > 0) {


                    int rndNumber = rndNumber(teams.size());
                    Team team1 = teams.get(rndNumber);

                    teams.remove(team1);

                    rndNumber = rndNumber(teams.size());
                    Team team2 = teams.get(rndNumber);

                    teams.remove(team2);
                    Match match = new Match();
                    generateMatch(team1, team2);
                    matches.add(match);

                    System.out.printf("Remaining teams: " + teams.size() +"\n");

                }//endFor

            } else if (teams.size() % 2 != 0) {

                System.out.println("Teams are NOT divisible by two, number of teams: " + teams.size());

                while (teams.size() > 0){

                    if(teams.size() >= 3){
                        System.out.println("Teams - Index <= 3 ");

                        int rndNumber = rndNumber(teams.size());
                        Team team1 = teams.get(rndNumber);
                        teams.remove(team1);

                        rndNumber = rndNumber(teams.size());
                        Team team2 = teams.get(rndNumber);
                        teams.remove(team2);
                        Match match = generateMatch(team1, team2);
                        matches.add(match);

                    }else if(teams.size() >= 1){
                        System.out.println("Teams - Index == 1 ");
                        Match match = new Match();
                        Team team = teams.get(0);
                        match.setTeam1(team);
                        teams.remove(team);
                    }//endIf
                    System.out.printf("Number of teams left: "+teams.size() + "\n");
                }//endFor
            }//endIf

        } else if(scores.size() != 0){
            if(teams.size() == scores.size()){

                boolean complete = false;

                //generates matches
                while (!complete) {

                    int maxScorePos = getMaxScore(scores);


                    if(maxScorePos != -1){
                        Team team1 = teams.get(maxScorePos);
                        Team team2;
                        scores.remove(maxScorePos);
                        teams.remove(maxScorePos);
                        maxScorePos = getMaxScore(scores);

                        if(maxScorePos != -1){
                            team2 = teams.get(maxScorePos);
                            scores.remove(maxScorePos);
                            teams.remove(maxScorePos);
                        } else {
                            throw new IndexOutOfBoundsException();
                        }//endIf

                        Match match = generateMatch(team1, team2);
                        matches.add(match);


                    } else {
                        throw new IndexOutOfBoundsException();
                    }//endIf



                    if(scores.size() == 0 && teams.size() == 0){
                        complete = true;
                    }//endIf

                }//endWhile

            } else {
                throw new WrongDataInputException(
                        "Amount of scores does NOT correlate with the amount of teams!" +
                        "\nScores : " + scores.size() +
                        "\nTeams  : " + teams.size() + "\n");
            }
        }//endIf
        return matches;
    }//end generateSETournament

    /**
     * Designed to generate a random number between 0 and maximum.
     * @param input Maximum
     * @return random Integer between0 and input
     */
    public int rndNumber(int input){
        Random rnd = new Random();
        int i  = rnd.nextInt(input);
        return i;
    }//endRndNumber

    /**
     * Generates a match of two teams
     * @param one team one participating in the tournament
     * @param two team two participating in the tournament
     * @return match with team one and team two battling against each other
     */
    public Match generateMatch(Team one, Team two){
        Match match = new Match();
        match.setTeam1(one);
        match.setTeam2(two);
        match.setStatus(Match.Status.waiting);
        return match;
    }

    public int getMaxScore(ArrayList<Integer> scores){
        boolean max = false;
        int i = 0;
        int maxValue = -1;
        int maxPos = -1;
        while (!max){
            if(scores.get(i) > maxValue){
                maxPos = i;
                maxValue = scores.get(i);

            }//endIf
            i++;
        }//endWhile
        return maxPos;
    }//endMethod
}//endClass
