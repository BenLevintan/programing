// Assignment: 5
// Author: Ben Levintan , ID: 318181831

// ppl who need glasses code in Java because they can't c#

public class hw5 {

    //ex1
    public static int linerSearch (String[] arr, String str){

        for(int i = 0 ; i < arr.length ; ++i ){

            if (arr[i]==str) {
                System.out.println(" The amount of unsuccessful comparisons I've made is: " + i);
                return i;
            }

        }

        return  -1;

    }

    //ex2
    public static int jumpSearch(int arr[],int key){

        int range=(int)(Math.sqrt(arr.length-1));       // the range of which we segment the array

        return jumpSearch(arr,range,0,key,0);  // signature is (the array, index of the start, the number we are looking for, count of unsuccessful comparisons)

    }
    public static int jumpSearch(int arr[], int range,int l, int key,int count){

        if(range<l || range>arr.length-1)              // if we reached the end of the array or sub, end with nothing found
            return -1;

        if(arr[range]<key)                            // if key is bigger, look for it in the next range
            return jumpSearch(arr, (range + (int)Math.floor(Math.sqrt(arr.length-1))) , (l + (int)Math.floor(Math.sqrt(arr.length-1))), key, count+1);

        if(arr[range]>key)                            // if key is smaller, look for it in the prior range
            return jumpSearch(arr,range-1,l,key,count);

        else {                                        // if we found the key, return it
            System.out.println("The amount of unsuccessful comparisons I've made is " + count);
            return range;
        }

    }

    //xe3
    public static int ternarySearch(int[] arr, int key){

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int index = l + (r - l) / 3;

            if (arr[index] == key)              //checks if the jump landed on a key
                return index;

            if (arr[index] < key)               //if arr in that cell greater, ignore the left of that cell
                l = index + 1;

            else                                //if arr in that cell smaller, ignore the right of that cell
                r = index - 1;
        }

        return -1;                              //key wasn't found, return -1
    }

    //ex4
    public static int interpolationSearch (char[] arr, char key) {

        int lowEnd = (arr.length - 1);   //defining low and high to fit a descending order
        int highEnd = 0;
        int count = 0;

        while (key >= arr[lowEnd] && key <= arr[highEnd] && lowEnd >= highEnd) {       //stop when high and low cross, don't enter if key is not in range

            int probe = lowEnd + (highEnd - lowEnd) * (key - arr[lowEnd]) / (arr[highEnd] - arr[lowEnd]);

            if (highEnd == lowEnd)
                if (arr[lowEnd] == key)                                               //if we found the key, return it
                    return lowEnd;
                else
                    return -1;                                                        //end loop here (low and high crossed), shorter run + don't add to the counter

            if (arr[probe] == key) {
                System.out.println("The amount of unsuccessful equalizations I've made is " + count);
                return probe;
            }

            ++count;                    //add to count if we about to change the probe

            if (arr[probe] < key)       //change probe by 1 depending on the key
                lowEnd = probe - 1;
            else
                highEnd = probe + 1;
        }

        return -1;

        }

    //ex5
    public static void insertionSort (int[] arr ){

        int count = 0;
        int size = arr.length;

        for (int i = 1; i < size; i++){

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key > arr[j]){
                arr[j + 1] = arr[j];
                --j;
                count++;
            }
            arr[j + 1] = key;
        }

        System.out.println("The amount of exchanges I made between organs in the array is " + count);

    }

    //ex6
    static int bubbleSort(int arr[], int n) {

        if (n == 1)                //we got the base state
            return 0;

        int count = 0;

        for (int i=0; i<n-1; i++)

            if (arr[i] > arr[i+1]){    // swapping if prior is higher than next value
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                count = count+1;      // add to count if we made a swap

            }

        if (count == 0)              // if we made no swaps we can stop here and return
            return 0;

        return count + bubbleSort(arr, n-1);    //add up the count, and call for the next iteration

    }

    static void bubbleSort(int arr[]){

        System.out.println(bubbleSort(arr, arr.length));

    }

        public static void main (String args[]){


            }
    }
