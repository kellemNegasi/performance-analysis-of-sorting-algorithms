/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmassignment;

import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author Kelly
 * *kelem negasi
 */
public class RandomGenerator {
    private static final Random rand = new Random();
    private static IntStream intstream;//Int stream object
   /* this method returns the required array based on the given size, presortedness and value range.
    e.g if the range is between 0 and 50 each element has a value between 
        0 and 50
    */
   public static int[] generateArray(double presortedness, int size, int start, int stop){
       if (presortedness == 0){
           return generateReversed(size,start, stop);
       }
       else if(presortedness == 1){
           return generateSorted(size,start, stop);
       }
       else if(presortedness == 0.5){
           return generateUnsorted(size,start, stop);
       }
       else 
           return null;
   }
    //this method returns array of sorted inputs(presortedness = 1)
    private static int[] generateSorted(int size, int form, int to){
        intstream = rand.ints(size,form,to);//generate stream of integers between form and to 
        return intstream.sorted().toArray();//return the array version of the generated intstream
    }
    // this method generates reversly sorted inputs(presortedness = 0)
    private static int[] generateReversed(int size, int from, int to){
        return revStream(size,from, to).toArray();//returns the corrosponding array of the reversed stream
        
    }
    // this method generates randomly distributed(presortedness =0.5) inputs
    private static int[] generateUnsorted(int size,int from, int to){
        intstream = rand.ints(size,from,to);//generates randomly shuffled elements
        return intstream.toArray();
    }
    private static IntStream revStream(int size, int from, int to){
        return rand.ints(size,from,to).sorted().map(i -> to - i + from - 1);//sorts the stream and the reverse maps each input 
    }
}
