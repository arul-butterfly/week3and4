import java.util.*;

public class q5 {

    // =========================================================
    // 🔹 LINEAR SEARCH (First Occurrence)
    // =========================================================
    public static int linearFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Not Found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    // =========================================================
    // 🔹 LINEAR SEARCH (Last Occurrence)
    // =========================================================
    public static int linearLast(String[] arr, String target) {
        int comparisons = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear Last Index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Not Found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    // =========================================================
    // 🔹 BINARY SEARCH (Any One Occurrence)
    // =========================================================
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Found Index: " + mid);
                System.out.println("Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not Found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    // =========================================================
    // 🔹 COUNT OCCURRENCES USING BINARY SEARCH
    // =========================================================
    public static int countOccurrences(String[] arr, String target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        if (first == -1) return 0;
        return last - first + 1;
    }

    // First occurrence (Binary)
    public static int firstOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1; // move left
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // Last occurrence (Binary)
    public static int lastOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1; // move right
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // =========================================================
    // 🔹 MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        // Input logs (unsorted)
        String[] logs = {"accB", "accA", "accB", "accC"};

        // 🔸 LINEAR SEARCH (on unsorted)
        System.out.println("---- Linear Search ----");
        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        // 🔸 SORT before Binary Search
        Arrays.sort(logs);
        System.out.println("\nSorted Logs: " + Arrays.toString(logs));

        // 🔸 BINARY SEARCH
        System.out.println("\n---- Binary Search ----");
        binarySearch(logs, "accB");

        int count = countOccurrences(logs, "accB");
        System.out.println("Total Occurrences: " + count);
    }
}