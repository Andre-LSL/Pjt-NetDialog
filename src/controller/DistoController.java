package controller;
import java.io.*;

public class DistoController {
    public DistoController() {
        super();
    }

    private String so() {
        return System.getProperty("os.name");
    }

    public void exibeRegistro () {
        String SO = so(), cd = "";

        if (SO.contains("Windows")) {
            System.out.println("Sistema Windows. Execute no SO Linux.");
        }  else if (SO.contains("Linux")) {
            cd = "cat /etc/os-release";
        }
            String[] comandoArr = cd.split(" ");
        	try {
			Process processo = Runtime.getRuntime().exec(comandoArr);
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha.trim());
				linha = buffer.readLine();
			}
	    buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {

        }
    } 
}