// Assignment: 3
// Author: Ben Levintan, ID: 318181831

public class ex7a {

    public static int howMany(String[] arr, String str){

        int count = 0;

        for( int i = 0 ; i < arr.length ; ++i){           //go through all the strings in the array
            if(str.compareTo(arr[i])>0)                   //add to counter 1 if string comes before arr[i]
                ++count;
        }

        return count;                                     //return the count
    }    //returns how many words come before the string

    public static void main (String args[]){

//        String[] arr = {"like","say","but","summer","call","world"};    test
//        String str = "summer";

//        System.out.println(howMany(arr,str));

    }
}
