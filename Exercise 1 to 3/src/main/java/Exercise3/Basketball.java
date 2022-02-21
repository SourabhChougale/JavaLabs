package Exercise3;


public class Basketball implements Team {

    //Declaring variables
    String TeamName;
    int points;
    String sponser;

    // Constructor
    public Basketball(String teamName, int points) {
        this.TeamName = teamName;
        this.points = points;
    }
    //Overriding methods of Interface
    @Override
    public int getPoints() {
        return points;

    }
    @Override //Method to update points in point table
    public void updatePoints(String result) {
        if(result.equals("Win")) points+=2;
    }
    @Override
    public String getTeamName() {
        return TeamName;
    }

    @Override
    public String getSponser() {
        return sponser;
    }
}
