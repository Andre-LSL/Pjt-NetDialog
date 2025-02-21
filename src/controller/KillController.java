
package controller;
import java.io.*;

public class KillController {
    public KillController() {
        super();
    }

    private String os() {
        return System.getProperty("os.name");
    }

    public void listaProcessos() {
        String SO = os(), comando = "";
        
        if (SO.contains("Windows")) {
            comando = "TASKLIST /FO TABLE";
        } else if (SO.contains("Linux")) {
            comando ="ps -ef";
        } 
        String[] procComando = comando.split(" ");
        try {
            Process p = Runtime.getRuntime().exec(procComando);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            while(linha != null) {
                System.out.println(linha);
                linha = buffer.readLine();
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {

        }

    }

    public void encerrarNome (String nome) {
        String SO = os(), comando = "";

        if (SO.contains("Windows")) {
            comando = "TASKKILL /IM " + nome;
        } else if (SO.contains("Linux")) {
            comando ="pkill -f " + nome;
        } 
        String[] encComando = comando.split(" ");
        try {
            Runtime.getRuntime().exec(encComando);
        } catch (Exception e) {

        }
        
    }

    public void encerrarPID (String nome) {
        String SO = os(), comando = "";

        if (SO.contains("Windows")) {
            comando = "TASKKILL /PID " + nome;
        } else if (SO.contains("Linux")) {
            comando ="kill -9 " + nome;
        } 
        String[] encComando = comando.split(" ");
        try {
            Runtime.getRuntime().exec(encComando);
        } catch (Exception e) {

        }
        
    }

}
