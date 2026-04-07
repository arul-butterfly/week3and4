import java.util.*;

public class q6 {

    // =========================================================
    // 🔹 LINEAR SEARCH (Unsorted Array)
    // =========================================================
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear: Not Found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    // =========================================================
    // 🔹 BINARY SEARCH INSERTION POSITION
    // (Lower Bound: first index where arr[i] >= target)
    // =========================================================
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;
        int result = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Binary Lower Bound Index: " + result);
        System.out.println("Comparisons: " + comparisons);
        return result;
    }

    // =========================================================
    // 🔹 FLOOR (Largest ≤ target)
    // =========================================================
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floorValue = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Floor: " + arr[mid]);
                System.out.println("Comparisons: " + comparisons);
                return arr[mid];
            }

            if (arr[mid] < target) {
                floorValue = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Floor: " + floorValue);
        System.out.println("Comparisons: " + comparisons);
        return floorValue;
    }

    // =========================================================
    // 🔹 CEILING (Smallest ≥ target)
    // =========================================================
    public static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ceilValue = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Ceiling: " + arr[mid]);
                System.out.println("Comparisons: " + comparisons);
                return arr[mid];
            }

            if (arr[mid] > target) {
                ceilValue = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Ceiling: " + ceilValue);
        System.out.println("Comparisons: " + comparisons);
        return ceilValue;
    }

    // =========================================================
    // 🔹 MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        // Unsorted risk bands
        int[] unsorted = {50, 10, 100, 25};

        // Sorted risk bands
        int[] sorted = {10, 25, 50, 100};

        int target = 30;

        // 🔸 Linear Search
        System.out.println("---- Linear Search ----");
        linearSearch(unsorted, target);

        // 🔸 Binary Search Variants
        System.out.println("\n---- Binary Search ----");
        lowerBound(sorted, target);
        floor(sorted, target);
        ceiling(sorted, target);
    }
}