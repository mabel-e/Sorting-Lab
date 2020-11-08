import java.util.*;
import  java.io.*;
public class SortingLab
{

    public SortingLab()
    {
    	
    }

    static int[] makeRandomArray(int size, int min, int max)
    {
        int i[] = new int[size];
        Random random = new Random();
        for(int j = 0; j < i.length; j++)
        {
            int r = random.nextInt(max - min) + min;
            i[j] = r;
        }
        return i;
    }

    static int[] copyArray(int[] original)
    {
        int newArr[] = new int[original.length];
        for(int i = 0; i < newArr.length; i++)
        {
            newArr[i] = original[i];
        }
        return newArr;
    }

    static void bubbleSort(int[] array)
    {
        int n = array.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n - i - 1; j++)
            {
                if(array[j] > array[j+1])
                {
                    int a = array[j+1];
                    array[j+1] = array[j];
                    array[j] = a;
                }
            }
        }
    }

    static void selectionSort(int[] array)
    {
        int n = array.length;
        int minIndex = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n - i - 1; j++)
            {
                if(array[j+1] < array[minIndex])
                {
                    minIndex = j+1;

                }
                if(j + 1 == minIndex)
                {
                    int a = array[j];
                    array[j] = array[minIndex];
                    array[j + 1] = a;
                }
            }

        }
    }

    static void insertionSort(int[] array)
    {
        int n = array.length;
        int k = array[1];
        for(int i = 1; i < n; i++)
        {
            int temp = array[i];
            int j = i-1;
            while(j >= 0 && array[j] < temp)
            {
               array[j+1] = array[j];
               j--;
                
                
                
                
            }
            array[j + 1] = temp;
        }
    }

    static void quickSort(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
            int size = 1024 * 64;
            int[] i = makeRandomArray(size, 0, 5000);
            int[] bubblecopy = copyArray(i);
            int[] selectioncopy = copyArray(i);
            int[] insertioncopy = copyArray(i);
            int[] quickcopy = copyArray(i);

            long bubbleStartTime = System.currentTimeMillis();
            bubbleSort(bubblecopy);
            long bubbleEndTime = System.currentTimeMillis();

            long selectionStartTime = System.currentTimeMillis();
            selectionSort(selectioncopy); 
            long selectionEndTime = System.currentTimeMillis();

            long insertionStartTime = System.currentTimeMillis();
            insertionSort(insertioncopy);
            long insertionEndTime = System.currentTimeMillis();

            long quickStartTime = System.currentTimeMillis();
            quickSort(quickcopy, 1, quickcopy.length - 1);
            long quickEndTime = System.currentTimeMillis();

            System.out.println("Size: " + 64 + "K");
            System.out.println((bubbleEndTime - bubbleStartTime) + " " + "Bubble Sort");
            System.out.println((selectionEndTime - selectionStartTime) + " " + "Selection Sort");
            System.out.println((insertionEndTime - insertionStartTime) + " " + "Insertion Sort");
            System.out.println((quickEndTime - quickStartTime) + " " + "Quick Sort");
            System.out.println(" ");
        
    }
}