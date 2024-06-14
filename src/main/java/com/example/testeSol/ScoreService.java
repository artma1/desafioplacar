package com.example.testeSol;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class ScoreService {

    private static final Logger logger = LoggerFactory.getLogger(ScoreService.class);

    public int calculateCombinations(String score) {
        Pattern pattern = Pattern.compile("(\\d+)x(\\d+)");
        Matcher matcher = pattern.matcher(score);

        if (matcher.matches()) {
            int totalpontos = Integer.parseInt(matcher.group(1));
            int totalpontos2 = Integer.parseInt(matcher.group(2));

            // Aqui está a lógica para calcular as combinações de pontuações
            // Para simplificação, vamos apenas retornar a soma das pontuações como exemplo
            //estes dois valores virão do json
            //int totalpontos = 17;
            //int totalpontos2 = 6;

            int soma;
            int chances = 0;
            int chances2 = 0;
            int combinations = 0;

            // é possível a soma de apenas 4 números para calcular as combinações:
            // 3 - field goal; 6 - touchdown;
            // 7 touchdown + 1 ponto; 8 - touchdown + 2 pontos
            // adotei a solução de criar arrays com os múltiplos dessas pontuações
            int[] multiplos3 = gerarMultiplos(3, totalpontos);
            int[] multiplos6 = gerarMultiplos(6, totalpontos);
            int[] multiplos7 = gerarMultiplos(7, totalpontos);
            int[] multiplos8 = gerarMultiplos(8, totalpontos);

            // declarando arrays para os pontos do time dois
            int[] multiplos3dois = gerarMultiplos(3, totalpontos2);
            int[] multiplos6dois = gerarMultiplos(6, totalpontos2);
            int[] multiplos7dois = gerarMultiplos(7, totalpontos2);
            int[] multiplos8dois = gerarMultiplos(8, totalpontos2);

            // verificando preenchimento dos arrays com os multiplos
            System.out.println("Time 1: ");
            System.out.println(Arrays.toString(multiplos3));
            System.out.println(Arrays.toString(multiplos6));
            System.out.println(Arrays.toString(multiplos7));
            System.out.println(Arrays.toString(multiplos8));

            System.out.println("Time 2: ");
            System.out.println(Arrays.toString(multiplos3dois));
            System.out.println(Arrays.toString(multiplos6dois));
            System.out.println(Arrays.toString(multiplos7dois));
            System.out.println(Arrays.toString(multiplos8dois));

            // somando todos os multiplos, encontramos uma probabilidade quando
            // o valor é exatamente igual a totalpontos
            for (int i = 0; i < multiplos3.length; i++) {
                for (int j = 0; j < multiplos6.length; j++) {
                    for (int k = 0; k < multiplos7.length; k++) {
                        for (int l = 0; l < multiplos8.length; l++) {
                            soma = multiplos3[i] + multiplos6[j] + multiplos7[k] + multiplos8[l];
                            if (soma == totalpontos) {
                                chances++;
                            }
                        }
                    }
                }
            }
            // repetir o processo para o time 2
            for (int i = 0; i < multiplos3dois.length; i++) {
                for (int j = 0; j < multiplos6dois.length; j++) {
                    for (int k = 0; k < multiplos7dois.length; k++) {
                        for (int l = 0; l < multiplos8dois.length; l++) {
                            soma = multiplos3dois[i] + multiplos6dois[j] + multiplos7dois[k] + multiplos8dois[l];
                            if (soma == totalpontos2) {
                                chances2++;
                            }
                        }
                    }
                }
            }
            System.out.printf("As combinações de cada time são: %d e %d respectivamente.%n", chances, chances2);

            // O resultado final são as probabilidades do time 1 multiplicado pelas do time 2
            combinations = chances * chances2;
            System.out.println("combinations: " + combinations);
            JSONObject json = new JSONObject();
            json.put("combinations", combinations);

            System.out.println(json.toString());
            return combinations; // retorna o JSON combinations com as combinações calculadas
        } else {
            logger.error("Invalid score format: {}", score);
            throw new IllegalArgumentException("Formato de placar inválido");
        }

    }
    // função para popular os arrays com múltiplos
    public static int[] gerarMultiplos ( int multiplo, int limite){
        int tamanho = (limite / multiplo) + 1;
        int[] multiplos = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            multiplos[i] = i * multiplo;
        }
        return multiplos;
    }
}