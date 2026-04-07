import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    // Constructor
    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    // Display format
    public String toString() {
        return name + ":" + riskScore;
    }
}

public class q2 {

    // 🔹 Bubble Sort (Ascending by Risk Score)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    // Swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            // Optimization: Stop if already sorted
            if (!swapped) break;
        }

        System.out.println("Bubble Sort (Ascending by Risk Score):");
        printArray(arr);
        System.out.println("Total Swaps: " + swaps);
        System.out.println();
    }

    // 🔹 Insertion Sort (Descending by RiskScore + Account Balance)
    public static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            // Sort by riskScore DESC, then accountBalance DESC
            while (j >= 0 && (
                    arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance)
            )) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort (Descending by Risk + Balance):");
        printArray(arr);
        System.out.println();
    }

    // 🔹 Print Top N Clients
    public static void printTopClients(Client[] arr, int topN) {
        System.out.println("Top " + topN + " Highest Risk Clients:");

        for (int i = 0; i < Math.min(topN, arr.length); i++) {
            System.out.println(arr[i].name + " (" + arr[i].riskScore + ")");
        }
    }

    // 🔹 Utility Print Function
    public static void printArray(Client[] arr) {
        for (Client c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        // Sample Input
        Client[] clients = {
                new Client("clientC", 80, 50000),
                new Client("clientA", 20, 30000),
                new Client("clientB", 50, 40000)
        };

        // Clone arrays (to keep original data safe)
        Client[] bubbleArr = clients.clone();
        Client[] insertionArr = clients.clone();

        // Perform Bubble Sort
        bubbleSort(bubbleArr);

        // Perform Insertion Sort
        insertionSort(insertionArr);

        // Print Top 10 High Risk Clients
        printTopClients(insertionArr, 10);
    }
}