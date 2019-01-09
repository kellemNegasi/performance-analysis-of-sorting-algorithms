/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingAlgorithms;


public class HeapSort {
  public static int[] doHeapSort(int input[]){

for(int i=input.length/2-1;i>=0;i--){
  MAX_HEAPIFY(input,input.length,i);
}
int heap_size=input.length;
for ( int i=heap_size- 1; i>= 0 ; i--){
int temp = input[0];
input[0] = input[i];
input[i] = temp;
MAX_HEAPIFY(input, i, 0 );
}

return input;
}
public static void MAX_HEAPIFY(int input[],int heap_size,int i){
int largest = i; // Initialize largest as
int l = 2 *i + 1 ; // left child
int r = 2 *i + 2 ; // right child
if (l<heap_size && input[l] > input[largest]){
largest = l;
}
if (r<heap_size && input[r] > input[largest]){
largest = r;
}
if (largest != i){
int temp =input[i];
input[i] = input[largest];
input[largest] = temp;
MAX_HEAPIFY(input, heap_size, largest);
}
}
  
}
