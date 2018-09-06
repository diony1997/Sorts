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
        for (int i = 1; i < vetor.length ; i++) 
        {
                    for (int j = i; j > 0&& vetor[j - 1] > vetor[j]; j--) 
                {
                   
                      vetor[j] = vetor[j] + vetor[j - 1];
                      vetor[j - 1] = vetor[j] - vetor[j - 1];
                      vetor[j] = vetor[j] - vetor[j - 1];
                    
                }
            }
        long fim = System.currentTimeMillis()-start;
        System.out.println("Tempo Insert "+fim);
       }

    public static void shell(int[] vetor){
        int valor;
        int gap = 1;
        long start = System.currentTimeMillis();
        while(gap < vetor.length){
            gap = 3 * gap + 1;
        }
        while(gap > 1){
            gap /= 3;
            for (int i = gap; i < vetor.length; i++) {
                valor = vetor[i];
                int j = i;
                while(j >= gap && valor < vetor[j - gap]){
                    vetor[j] = vetor[j - gap];
                    j = j - gap;
                }
                vetor[j] = valor;
            }
        }
        long fim = System.currentTimeMillis()-start;

        System.out.println("Tempo Shell "+fim);
    }

    public static void main(String[] args) 
    {
        int n = 100000;
        int vetor[] = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            vetor[i]= random.nextInt();
        }
        
        shell(vetor);
        for (int i = 0; i < n; i++) {
            vetor[i]= random.nextInt();
        }
        insert(vetor);
        for (int i = 0; i < n; i++) {
            vetor[i]= random.nextInt();
        }
        bobbleSort2(vetor);
      
        
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
        long fim = System.currentTimeMillis()-start;
        System.out.println("Tempo Bobble "+fim);
    }

}
