#include <stdio.h>
#include <stdlib.h>
void swap(int* xp, int* yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
 
// Function to perform Selection Sort
void selectionSort(int arr[], int n)
{
    int i, j, min_idx;
 
    // One by one move boundary of unsorted subarray
    for (i = 0; i < n - 1; i++) {
 
        // Find the minimum element in unsorted array
        min_idx = i;
        for (j = i + 1; j < n; j++)
            if (arr[j] < arr[min_idx])
                min_idx = j;
 
        // Swap the found minimum element
        // with the first element
        swap(&arr[min_idx], &arr[i]);
    }
}
 
// Function to print an array
void printArray(int arr[], int size)
{
    
    for (int i = 0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}
 
// Driver code
int main()
{
 //  int *arr;
   int arr[1000];
   int b;
   int count=0;
   while (scanf("%d",&b)!= EOF){
     
     arr[count]= b;
     count++;

   }
    //int n = sizeof(arr) / sizeof(arr[0]);
   int n = count;
  
 
    selectionSort(arr, n);
    printArray(arr, n);
 
    return 0;
}