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
    public static int encontrarMaior(int vetor[]){
        int maior = 0;
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i]>maior){
                maior = vetor[i];
            }
        }
        return maior;
    }
    
    public static void countingSort(int vetor[]){
        int maior = encontrarMaior(vetor);
        int vetor2[] = new int[maior+1];
        for (int i = 0; i < vetor.length; i++) {
            vetor2[vetor[i]]+=1;
        }
        int indice = 0;
        for (int i = 0; i < vetor2.length; i++) {
            while(vetor2[i]>0){
                vetor[indice] = i;
                indice++;
                vetor2[i]--;
            }
        }
                
    }
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

    public static void heapSort(int vetor[], int tamanho) {
        criaHeap(vetor, tamanho);
        int fim = tamanho - 1;
        while (fim > 0) {
            troca(vetor, 0, fim);
            fim = fim - 1;
            arrumaHeap(vetor, 0, fim);
        }
    }

    public static void troca(int vetor[], int inicio, int fim) {
        int temp = vetor[inicio];
        vetor[inicio] = vetor[fim];
        vetor[fim] = temp;
    }

    public static void arrumaHeap(int vetor[], int inicio, int fim) {
        int raiz = inicio;
        while (raiz * 2 + 1 <= fim) {
            int filho = raiz * 2 + 1;
            int trocar = raiz;
            if (vetor[trocar] < vetor[filho]) {
                trocar = filho;
            }
            if (filho + 1 <= fim && vetor[trocar] < vetor[filho + 1]) {
                trocar = filho + 1;
            }
            if (trocar == raiz) {
                return;
            } else {
                troca(vetor, raiz, trocar);
                raiz = trocar;
            }
        }
    }

    public static void criaHeap(int vetor[], int tamanho) {
        int inicio = ((tamanho - 2) / 2);

        while (inicio >= 0) {
            arrumaHeap(vetor, inicio, tamanho - 1);
            inicio = inicio - 1;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int vetor[] = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            vetor[i] = random.nextInt(2);
        }

        heapSort(vetor, n);
        imprimir(vetor);

    }

}
