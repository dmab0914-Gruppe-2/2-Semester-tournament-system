package ModelLayer;

/**
 * Created by Andreas on 11-05-2015.
 */
public class Match {

    enum Status {
        waiting, playing, done, cancelled
    }

    private int id;
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;
    private int roundNumber;
    private Status status;




    public Match() {

    }



    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public int getRoundNbr() {
        return roundNumber;
    }

    public void setRoundNbr(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
