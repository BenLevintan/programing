package soccerKITA;

public class Goalkeeper extends SoccerPlayer{

    int goalSaved;
    public Goalkeeper(String name, int age){
        super(name,age);
        this.goalSaved = 0;
        this.position="Goalkeeper";
    }


    public void saveGoal(){
        ++goalSaved;
    }

    @Override
    public String toString(){
        String str ="";
        str =str + "Player-number:\t" + getPlayerNumber() +
                "\tposition:\t Goalkeeper age:\t" + getAge() +
                "\tname:\t" + getName() +
                "\tnumber of saves:" + this.goalSaved;
        return str;
    }

    @Override
    public void play(){
        System.out.println(getName() + " playes as: Goalkeeper");
    }
}
