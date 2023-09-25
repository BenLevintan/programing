package JumpPackage;

public class Athlete {

        private static int counter = 0;
        final int athleteNumber = 100 + counter;
        private String name;
        private String ID;



        public void setName(String name) {
                this.name = name;
                counter++;
        }

        public void setID(String ID){
                this.ID = ID;
        }

        public int getAthleteNumber(){
                return athleteNumber;
        }

        public String toString(){
                String str = "Athlete-number:" + getAthleteNumber() + "\tAthlete name: ";
                str = str + this.name + "\tAthlete ID: " + this.ID;

                return str;


        }

        public static void main (String[] args){

                Athlete a = new Athlete();

                a.setName("Martha Stewart");
                a.setID("2004");

                System.out.println(a.toString());

                Athlete b = new Athlete();

                b.setName("Denzel Washington");
                b.setID("1001");

                System.out.println(b.toString());


        }


} // class Jumper
