package Exercise3;



public class Football implements Team {

    //Declaring variables
    String TeamName;
    int points;
    String sponser;

    //Constructor
    public Football(String teamName, int points,String sponser ) {
        this.TeamName = teamName;
        this.points = points;
        this.sponser = sponser;
    }

    //Overriding methods of Interface
    @Override
    public int getPoints() {
        return points;
    }
    @Override  //Method to update points in point table
    public void updatePoints(String result) {
        if(result.equals("Win")) points+=3;
        else if(result.equals("Drawn")) points+=1;
    }
    @Override
    public String getTeamName() {
        return TeamName;
    }
    public String getSponser(){
        return sponser;
    }

}
