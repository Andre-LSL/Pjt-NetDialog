package view;

import java.util.Scanner;
import controller.DistoController;
import controller.KillController;
import controller.RedesController;

public class CLIController {
    private final DistoController disto;
    private final KillController kill;
    private final RedesController redes;
    private final Scanner scanner;

    public CLIController() {
        this.disto = new DistoController();
        this.kill = new KillController();
        this.redes = new RedesController();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    disto.exibeRegistro();
                    break;
                case 2:
                    kill.listaProcessos();
                    break;
                case 3:
                    System.out.print("Digite o nome do processo: ");
                    String nome = scanner.nextLine();
                    kill.encerrarNome(nome);
                    break;
                case 4:
                    System.out.print("Digite o PID do processo: ");
                    String pid = scanner.nextLine();
                    kill.encerrarPID(pid);
                    break;
                case 5:
                    redes.ip();
                    break;
                case 6:
                    redes.ping();
                    break;
                case 0:
                    System.out.println("\nSaindo do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\n\033[1;36m=== NET DIAG - CLI ===\033[0m");
        System.out.println("1  Exibir informações do sistema");
        System.out.println("2  Listar processos");
        System.out.println("3  Encerrar processo por nome");
        System.out.println("4  Encerrar processo por PID");
        System.out.println("5  Exibir informações de rede");
        System.out.println("6  Testar ping");
        System.out.println("0  Sair");
        System.out.print("\n\033[1;33mEscolha uma opção: \033[0m");
    }

    private int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha
            return opcao;
        } catch (Exception e) {
            scanner.nextLine(); // Consumir entrada inválida
            return -1;
        }
    }
}
