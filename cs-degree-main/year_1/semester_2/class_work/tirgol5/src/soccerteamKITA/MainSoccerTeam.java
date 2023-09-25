package soccerteamKITA;


public class MainSoccerTeam {


    public static void main(String[] args) {
        SoccerPlayer[] players = getPlayers();

    }

    /**Create an array of SoccerPlayer and insert into that array data of players
     * @return array of SoccerPlayer of length 20(you may change its length)
     */
    public static SoccerPlayer[] getPlayers(){
        SoccerPlayer[] players=new SoccerPlayer[20];

        players[0] = new Forward("Ronaldo", 36);
        players[1] = new Forward("Lewandowski", 34);
        players[2] = new Forward("Dembélé", 25);
        players[3] = new Forward("Fati", 20);
        players[4] = new Forward("Raphinha", 26);
        players[5] = new Midfield("Busquets", 34);
        players[6] = new Midfield("Gavi", 19);
        players[7] = new Midfield("Pedri", 20);
        players[8] = new Midfield("Modric", 35);
        players[9] = new Goalkeeper("Navas", 34);

        players[10] = new Goalkeeper("ter Stegen", 31);
        players[11] = new Defence("Araujo", 24);
        players[12] = new Defence("Christensen", 27);
        players[13] = new Defence("Alonso", 32);
        players[14] = new Defence("Ramos", 35);
        players[15] = new Defence("Kounde", 24);
        players[16] = new SoccerPlayer("Isco", 29);
        players[17] = new SoccerPlayer("Nymar", 31);
        players[18] = new SoccerPlayer("Messi", 36);

        return players;

    }

}
