import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    private static final String INGENUA = "0";
    private static final String ARRANJO = "1";

    public static void main (String [] args) throws IOException {

        long timeInicialTotal = System.currentTimeMillis();


        String arquivoSaidaFinal = "saidas/compilado.txt"; //Para colocar os arquivos na pasta saída

        FileWriter fileWriter2 = new FileWriter(arquivoSaidaFinal);
        
        PrintWriter printWriter2 = new PrintWriter(fileWriter2); 
        for (Integer tarefa = 1000; tarefa <= 99000; tarefa += 1000) {

            String caminhoArquivoEntrada = "entradas/tarefas"+tarefa+".txt"; // Para cada arquivo de entrada

        String arquivoSaida = "saidas/saidaTarefas"+tarefa+".txt"; // Cada saída terá o nome da sua respectiva entrada
        
        String tipoPilha = args[0]; 
        
        File arquivoEntrada = new File(caminhoArquivoEntrada); 
        long timeInicial = System.currentTimeMillis(); 

        try {
            Scanner sc = new Scanner(arquivoEntrada); 
            FileWriter fileWriter = new FileWriter(arquivoSaida); 
            PrintWriter printWriter = new PrintWriter(fileWriter);

            if (tipoPilha.equals(ARRANJO)) { // Se a opção escolhida for o arranjo...

                Pilha<String> pilha = new PilhaArranjo<String>(); // Instancia uma pilha de String

                while (sc.hasNext()) { // enquanto houver linhas para serem lidas no documento...
                    String linha = sc.nextLine(); // variável para receber a linha 
                    if (linha.equals("")) { // se a linha for vazia...
                        String processado = pilha.pop(); // dá um pop e coloca o elemento do retorno no arquivo de saída
                        printWriter.print(processado);
                        printWriter.print("\n");
                        printWriter.flush();
                
                    } else {
                        pilha.push(linha); // senão, apenas acrescenta o elemento na pilha 
                    }
                }
            }
            if (tipoPilha.equals(INGENUA)) { // se o tipo da pilha for ingênua... 

                PilhaIngenua2 pilhaIngenua = new PilhaIngenua2();
                while (sc.hasNext()) { // enquanto houver linhas para serem lidas no documento...
                    String linha= sc.nextLine(); // variável para receber a linha 
                    if (linha.equals("")) { // se a linha for vazia...
                        String processado =  Integer.toString(pilhaIngenua.remove()); // remove o elemento e coloca o elemento do retorno no arquivo de saída
                        printWriter.print(processado);
                        printWriter.print("\n");
                        printWriter.flush();
                        
                    } else {
                        pilhaIngenua.add(Integer.parseInt(linha)); // senão, apenas acrescenta o elemento na pilha 
                    }
                }
            }
            long timeFinal = System.currentTimeMillis();
            long tempoTotal = timeFinal - timeInicial;
            sc.close();
          

            printWriter2.print("Tarefa"+tarefa+" Tempo: "+tempoTotal);
            printWriter2.print("\n");
            printWriter2.flush();

        } catch (IOException ex) {
            //LIDAR COM O ERRO
            System.out.println("Error: " + ex.getMessage());
        }
        
    }
        long timeFinalTotal = System.currentTimeMillis()-timeInicialTotal;
        printWriter2.print("Tempo total "+timeFinalTotal);
        printWriter2.print("\n");
        printWriter2.flush();

    }
}