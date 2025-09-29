import java.util.Scanner;
import java.util.Random;

class QuickSort {

    public static void swap(int[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(int[] array, int esq, int dir) { // QuickSort generico
        int i = esq, j = dir, pivo = array[(esq + dir) / 2];
        while (i <= j) {
            while (array[i] < pivo) {
                i++;
            }
            while (array[j] > pivo) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j) {
            quickSort(array, esq, j);
        }
        if (i < dir) {
            quickSort(array, i, dir);
        }
    }

    public static void quickSortFirtPivot(int[] array, int esq, int dir) { // QuickSort Pivo no Primeiro
        int i = esq, j = dir, pivo = array[esq];
        while (i <= j) {
            while (array[i] < pivo) {
                i++;
            }
            while (array[j] > pivo) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j) {
            quickSort(array, esq, j);
        }
        if (i < dir) {
            quickSort(array, i, dir);
        }
    }

    public static void quickSortLastPivot(int[] array, int esq, int dir) { // QuickSort Pivo no Ultimo
        int i = esq, j = dir, pivo = array[dir];
        while (i <= j) {
            while (array[i] < pivo) {
                i++;
            }
            while (array[j] > pivo) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j) {
            quickSort(array, esq, j);
        }
        if (i < dir) {
            quickSort(array, i, dir);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random();

        int[] array1 = new int[10];

        for (int i = 0; i < array1.length; i++) { // Gerar numeros aleatorios
            array1[i] = aleatorio.nextInt(100);
        }
        /**
         * int[] array2 = new int[100];
         * int[] array3 = new int[1000];
         * int[] array4 = new int[10000];
         */

        quickSort(array1, 0, array1.length - 1);

        System.out.print("Generico: ");
        for (int x = 0; x < array1.length; x++) {
            System.out.print(array1[x] + " ");
        }
        System.out.println("\n\n");

        // -----------------------------------------------

        quickSortFirtPivot(array1, 0, array1.length - 1);

        System.out.print("FirstPivot: ");
        for (int x = 0; x < array1.length; x++) {
            System.out.print(array1[x] + " ");
        }
        System.out.println("\n\n");

        // -----------------------------------------------

        quickSortLastPivot(array1, 0, array1.length - 1);

        System.out.print("LastPivot: ");
        for (int x = 0; x < array1.length; x++) {
            System.out.print(array1[x] + " ");
        }
        System.out.println("\n\n");

        sc.close();
    }
}
