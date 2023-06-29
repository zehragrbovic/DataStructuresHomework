package task1;

public class MergeSort {

    public static void sort(Student[] students) {
        // implement the actual logic
        mergeSort(students, 0, students.length - 1);
    }

    private static void mergeSort(Student[] students, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;   // middle point
            mergeSort(students, low, mid);      // left subarray
            mergeSort(students, mid + 1, high); // right subarray
            merge(students, low, mid, high);    
        }
    }

    private static void merge(Student[] students, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        // temporary arrays to store the divided subarrays
        Student[] leftSubarray = new Student[leftSize];
        Student[] rightSubarray = new Student[rightSize];

        // data from the original array copied to the temporary subarrays
        System.arraycopy(students, low, leftSubarray, 0, leftSize);
        System.arraycopy(students, mid + 1, rightSubarray, 0, rightSize);

        // the subarrays merged back into the original array in a sorted manner
        int i = 0, j = 0, k = low;
        while (i < leftSize && j < rightSize) {
            if (leftSubarray[i].compareTo(rightSubarray[j]) <= 0) {
                students[k] = leftSubarray[i];
                i++;
            } else {
                students[k] = rightSubarray[j];
                j++;
            }
            k++;
        }

        // copying the remaining elements of the left subarray, if any
        while (i < leftSize) {
            students[k] = leftSubarray[i];
            i++;
            k++;
        }

        // copying the remaining elements of the right subarray, if any
        while (j < rightSize) {
            students[k] = rightSubarray[j];
            j++;
            k++;
        }
    }

}
