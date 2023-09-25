package soccerKITA;

public class Midfield extends SoccerPlayer{

    int passes;
    public Midfield(String name, int age){
        super(name,age);
        this.passes = 0;
        this.position="Midfielder";
    }

    @Override
    public String toString(){
        String result="Player-number:\t"+super.getPlayerNumber();
        result+="\tposition: midfield  ";
        result+="\tage:"+"\t"+super.age;
        result+="\tname:"+"\t"+super.name;
        result+="\t\tnumber of passes:"+statistics;
        return result;
    }
}
