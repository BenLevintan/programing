// Assignment: 3
// Author: Ben Levintan, ID: 318181831

public class ex7b {

    public static int howMany(String[] arr, String str){

        int count = 0;

        for( int i = 0 ; i < arr.length ; ++i){           //go through all the strings in the array
            if(str.compareTo(arr[i])>0)                   //add to counter 1 if string comes before arr[i]
                ++count;
        }

        return count;                                     //return the count
    }    //returns how many words come before the string
    public static String[] whatComesBefore(String[] arr, String str){

        String[] result = new String[howMany(arr,str)];         //using 'howMany' method to know the size of the array we need to build
        int count = 0;
        int j=0;

        for( int i = 0 ; i < arr.length ; ++i){                 //go through all the words
            if(str.compareTo(arr[i])>0) {
                result[j] = arr[i];                             //if word comes before in the dictionary, that word will be pointed to by the array
                ++j;
            }
        }

        return result;
    }    //returns how many words come before the string

    public static void main(String args[]){

//        String[] arr = {"like","say","but","summer","call","world","banana","tea","light","mouse"};   //test
//        String str = "summer";
//
//        String[] result = whatComesBefore(arr,str);
//
//        for(int i =0 ; i < result.length ; ++i )
//          System.out.println(result[i]);

    }
}
