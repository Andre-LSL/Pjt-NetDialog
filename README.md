# NET DIAG

**NET DIAG** é uma aplicação Java para diagnóstico e gerenciamento do sistema operacional via linha de comando. Ele executa comandos nativos do sistema para obter informações e realizar ações, como listar e encerrar processos, verificar informações de rede e testar conectividade.

## Funcionalidades

1. **Exibir informações do sistema**  
   - Obtém detalhes do SO (apenas Linux) exibindo o conteúdo de `/etc/os-release`.

2. **Listar processos**  
   - Exibe os processos em execução:  
     - Windows: `TASKLIST /FO TABLE`
     - Linux: `ps -ef`

3. **Encerrar processos**  
   - Pelo **nome**:
     - Windows: `TASKKILL /IM <nome>`
     - Linux: `pkill -f <nome>`
   - Pelo **PID**:
     - Windows: `TASKKILL /PID <pid>`
     - Linux: `kill -9 <pid>`

4. **Exibir informações de rede**  
   - Obtém detalhes da rede:  
     - Windows: `ipconfig`
     - Linux: `ifconfig`

5. **Testar conectividade (ping)**  
   - Executa `ping` para testar a latência até o Google:  
     - Windows: `ping -4 -n 10 www.google.com.br`
     - Linux: `ping -4 -c 10 www.google.com.br`

## Estrutura

```
📦 net-diag-cli
├── 📂 src
│   ├── 📂 controller
│   │   ├── DistoController.java
│   │   ├── KillController.java
│   │   ├── RedesController.java
│   ├── 📂 view
│   │   ├── CLIController.java
│   │   ├── Main.java

