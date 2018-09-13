/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertsort;

import java.util.Random;

/**
 *
 * @author lab804
 */
public class InsertSort {

    /**
     * @param args the command line arguments
     */
    static void insert(int[] vetor) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < vetor.length; i++) {
            for (int j = i; j > 0 && vetor[j - 1] > vetor[j]; j--) {

                vetor[j] = vetor[j] + vetor[j - 1];
                vetor[j - 1] = vetor[j] - vetor[j - 1];
                vetor[j] = vetor[j] - vetor[j - 1];

            }
        }
        long fim = System.currentTimeMillis() - start;
        System.out.println("Tempo Insert " + fim);
    }

    static void imprimir(int vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " - ");
        }
        System.out.println("");
    }

    public static void shell(int[] vetor) {
        int valor;
        int gap = 1;
        long start = System.currentTimeMillis();
        while (gap < vetor.length) {
            gap = 3 * gap + 1;
        }
        while (gap > 1) {
            gap /= 3;
            for (int i = gap; i < vetor.length; i++) {
                valor = vetor[i];
                int j = i;
                while (j >= gap && valor < vetor[j - gap]) {
                    vetor[j] = vetor[j - gap];
                    j = j - gap;
                }
                vetor[j] = valor;
            }
        }
        long fim = System.currentTimeMillis() - start;

        System.out.println("Tempo Shell " + fim);
    }

    static void selection(int vetor[]) {
        int min;
        for (int i = 0; i < vetor.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[min]) {
                    min = j;
                }
            }

            int temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;
        }
    }

    static void merge(int vetor[], int inicial, int fim) {
        if (inicial < fim) {
            int meio = (inicial + fim) / 2;
            merge(vetor, inicial, meio);
            merge(vetor, meio + 1, fim);
            intercala(vetor, inicial, meio, fim);
        }

    }

    private static void intercala(int[] vetor, int inicial, int meio, int fim) {
        int[] vetorB = vetor.clone();
        int i, j;

        for (i = inicial; i <= meio; i++) {
            vetorB[i] = vetor[i];
        }

        for (j = meio + 1; j <= fim; j++) {
            vetorB[fim + meio + 1 - j] = vetor[j];
        }

        i = inicial;
        j = fim;

        for (int k = inicial; k <= fim; k++) {
            if (vetorB[i] <= vetorB[j]) {
                vetor[k] = vetorB[i];
                i++;
            } else {
                vetor[k] = vetorB[j];
                j--;
            }
        }
    }

    public static void bobbleSort2(int vetor[]) {
        long start = System.currentTimeMillis();
        int n = vetor.length;
        int novoN;
        do {
            novoN = 0;
            for (int i = 1; i <= n - 1; i++) {
                if (vetor[i - 1] > vetor[i]) {

                    vetor[i] = vetor[i - 1] + vetor[i];
                    vetor[i - 1] = vetor[i] - vetor[i - 1];
                    vetor[i] = vetor[i] - vetor[i - 1];

                    novoN = i;
                }
            }
            n = novoN;
        } while (n > 0);
        long fim = System.currentTimeMillis() - start;
        System.out.println("Tempo Bobble " + fim);
    }

    public static void main(String[] args) {
        int n = 100000;
        int vetor[] = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            vetor[i] = random.nextInt();
        }

        shell(vetor);
        for (int i = 0; i < n; i++) {
            vetor[i] = random.nextInt();
        }
        insert(vetor);
        for (int i = 0; i < n; i++) {
            vetor[i] = random.nextInt();
        }
        bobbleSort2(vetor);

    }

}
