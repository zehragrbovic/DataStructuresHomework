package task1;

public class BinarySearch {
    // track the number of iterations needed for a search to complete
    public static int numSteps = 0;

    public static int search(Student[] students, int key) {
        // implement the actual logic (remove next line)

        int low = 0;
        int high = students.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (students[mid].getStudentId() == key) {
                return mid;
            } else if (students[mid].getStudentId() < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            numSteps++;
        }

        return -1;
    }
}
