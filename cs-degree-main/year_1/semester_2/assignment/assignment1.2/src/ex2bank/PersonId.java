// Assignment: 1
// Author: Ben Levintan, ID: 318181831

package ex2bank;

public class PersonId {
    public long idNumber;
    public String firstName;
    public String sirName;
    public String address;

    public PersonId(long idNumber, String firstName, String sirName, String address) {
        this.idNumber = Math.abs(idNumber);
        this.firstName = firstName;
        this.sirName = sirName;
        this.address = address;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return sirName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){

        String sb = "Person id: ";
        String id = Long.toString(this.idNumber);
        sb+= id + ", ";
        sb+= "name: " + firstName + " " + sirName + ", address: " + address;
        return sb;
    }

    public boolean equals(PersonId client){
        if(this.idNumber == client.getIdNumber())
            return true;
        return false;
    }

}
