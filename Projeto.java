package br.dev.rogger;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sesi2dib
 */
public class AtivTigre {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
                
                
        Random random = new Random();

        int[] mSorteio = new int[10];

        // Sorteia os 10 numeros sem repetir
        for (int i = 0; i < 10; i++) {
            int numero = random.nextInt(101); // Gera de 0 a 100

            // Checa se o numero ja esta no vetor
            boolean repetido = false;
            for (int j = 0; j < i; j++) {
                if (mSorteio[j] == numero) {
                    repetido = true;
                    break;
                }
            }

            // Se for repetido, volta o 'i' para tentar sortear essa posicao de novo
            if (repetido) {
                i--; 
            } else {
                mSorteio[i] = numero;
            }
        }

        // Pede os 4 numeros para o usuario
        int[] meusNumeros = new int[4];
        System.out.println("--- DIGITE 4 NUMEROS (0 a 100) ---");
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o " + (i + 1) + "º numero: ");
            meusNumeros[i] = scanner.nextInt();
        }

        // Procura os numeros no vetor e conta os acertos
        int acertos = 0;
        System.out.println("\n--- RESULTADO DA BUSCA ---");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                if (meusNumeros[i] == mSorteio[j]) {
                    System.out.println("O numero " + meusNumeros[i] + " foi encontrado na posicao " + j);
                    acertos++;
                }
            }
        }

        // Calcula a porcentagem de ganho
        int porcentagem = 0;
        if (acertos == 1) {
            porcentagem = 25;
        } else if (acertos == 2) {
            porcentagem = 50;
        } else if (acertos == 3) {
            porcentagem = 75;
        } else if (acertos == 4) {
            porcentagem = 100;
        }

        // Exibe o resultado final
        System.out.println("\nTotal de acertos: " + acertos);
        System.out.println("Porcentagem do ganho: " + porcentagem + "%");

        // Imprime o vetor sorteado pra conferir
        System.out.println("\nNumeros que foram sorteados:");
        for (int i = 0; i < 10; i++) {
            System.out.print(mSorteio[i] + " ");  
        
        }
  }
}
