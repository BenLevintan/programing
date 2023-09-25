package soccerKITA;

public class Forward extends SoccerPlayer{
    private int goalsScored;
    public Forward(String name, int age){
        super(name,age);
        this.goalsScored = 0;
        this.position="Forward";
    }

    public void scoreGoal(){
        ++goalsScored;
    }

    @Override
    public String toString(){
        String str ="";
        str =str + "Player-number:\t" + getPlayerNumber() +
                "\tposition:\t Forward age:\t" + getAge() +
                "\tname:\t" + getName() +
                "\tnumber of goals:" + this.goalsScored;
        return str;
    }

    @Override
    public void play(){
        System.out.println(getName() + " playes as: " + position);
    }

}
