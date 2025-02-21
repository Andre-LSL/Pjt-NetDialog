package controller;
import java.io.*;
public class RedesController {

    public RedesController() {
        super();
    }

    private String os() {
        return System.getProperty("os.name");
    }

    public void ip() {
        String SO = os();
        String cd = "";
        if (SO.contains("Windows")) {
            cd = "ipconfig";
            System.err.println(cd);
        } else if (SO.contains("Linux")) {
            cd = "ifconfig";
            System.err.println(cd);
        }
        String[] procDados = cd.split(" ");
        System.err.println(procDados);
        try {
            Process p = Runtime.getRuntime().exec(procDados);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            while(linha != null) {
                if (linha.contains("IPv4")) {
                    System.out.println(linha);
                }
                linha = buffer.readLine();
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void ping() {
        String SO = os();
        String cd = "";
        if (SO.contains("Windows")) {
            cd = "ping -4 -n 10 www.google.com.br";
        } else if (SO.contains("Linux")) {
            cd = "ping -4 -c 10 www.google.com.br";
        }
    String[] procDados = cd.split(" ");
        try {
            Process p = Runtime.getRuntime().exec(procDados);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            while(linha != null) {
                if (linha.contains("dia") || linha.contains("avg")) {
                    System.out.println(linha);
                }
                linha = buffer.readLine();
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}