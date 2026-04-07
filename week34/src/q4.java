import java.util.*;

// 🔹 Asset Class
class Asset {
    String name;
    double returnRate;   // %
    double volatility;   // risk measure

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return name + ":" + returnRate + "%";
    }
}

public class q4 {

    // =========================================================
    // 🔹 MERGE SORT (Ascending by returnRate) - STABLE
    // =========================================================
    public static void mergeSort(Asset[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(Asset[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Asset[] L = new Asset[n1];
        Asset[] R = new Asset[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Stable merge (preserves order for equal returnRate)
        while (i < n1 && j < n2) {
            if (L[i].returnRate <= R[j].returnRate) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // =========================================================
    // 🔹 QUICK SORT (DESC returnRate + ASC volatility)
    // =========================================================
    public static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {

            // Hybrid: Use Insertion Sort for small partitions
            if (high - low < 10) {
                insertionSort(arr, low, high);
                return;
            }

            int pivotIndex = medianOfThree(arr, low, high);
            swap(arr, pivotIndex, high);

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 🔹 Partition (Lomuto)
    public static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot)) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // 🔹 Comparison Logic
    // DESC returnRate, if equal → ASC volatility
    public static boolean compare(Asset a, Asset b) {
        if (a.returnRate > b.returnRate) return true;
        if (a.returnRate == b.returnRate && a.volatility < b.volatility) return true;
        return false;
    }

    // =========================================================
    // 🔹 Median-of-Three Pivot Selection
    // =========================================================
    public static int medianOfThree(Asset[] arr, int low, int high) {
        int mid = (low + high) / 2;

        Asset a = arr[low];
        Asset b = arr[mid];
        Asset c = arr[high];

        if ((a.returnRate > b.returnRate && a.returnRate < c.returnRate) ||
                (a.returnRate < b.returnRate && a.returnRate > c.returnRate))
            return low;

        if ((b.returnRate > a.returnRate && b.returnRate < c.returnRate) ||
                (b.returnRate < a.returnRate && b.returnRate > c.returnRate))
            return mid;

        return high;
    }

    // =========================================================
    // 🔹 Random Pivot (Alternative)
    // =========================================================
    public static int randomPivot(int low, int high) {
        return new Random().nextInt(high - low + 1) + low;
    }

    // =========================================================
    // 🔹 Insertion Sort (for small partitions)
    // =========================================================
    public static void insertionSort(Asset[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            Asset key = arr[i];
            int j = i - 1;

            while (j >= low && compare(key, arr[j])) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // =========================================================
    // 🔹 Utility Functions
    // =========================================================
    public static void swap(Asset[] arr, int i, int j) {
        Asset temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(Asset[] arr) {
        for (Asset a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    // =========================================================
    // 🔹 MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        Asset[] assets = {
                new Asset("AAPL", 12, 5),
                new Asset("TSLA", 8, 9),
                new Asset("GOOG", 15, 4)
        };

        // Clone arrays
        Asset[] mergeArr = assets.clone();
        Asset[] quickArr = assets.clone();

        // 🔸 Merge Sort (Ascending)
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        System.out.println("Merge Sort (Ascending by Return):");
        printArray(mergeArr);

        // 🔸 Quick Sort (Descending + Volatility)
        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("Quick Sort (DESC Return + ASC Volatility):");
        printArray(quickArr);
    }
}