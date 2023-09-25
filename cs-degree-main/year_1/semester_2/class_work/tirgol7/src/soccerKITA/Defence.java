package soccerKITA;

public class Defence extends SoccerPlayer{

    private int tackleMade;
    public Defence(String name, int age){
        super(name,age);
        this.tackleMade = 0;
        this.position="Defender";
    }

    public void makeTackle(){
        ++tackleMade;
    }

    @Override
    public String toString(){
        String str ="";
        str =str + "Player-number:\t" + getPlayerNumber() +
                "\tposition:\t Forward age:\t" + getAge() +
                "\tname:\t" + getName() +
                "\tnumber of tackles:" + this.tackleMade;
        return str;
    }

    @Override
    public void play(){
        System.out.println(getName() + " playes as: " + position);
    }

}