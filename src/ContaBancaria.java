import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int escolha = 0;
        String nomeCliente = "Felipe Spinola de Proença";
        String tipoConta = "Corrente";
        String dadosClientesFormato;
        String exibirDadosClientes;
        double saldo = 100.00;

        dadosClientesFormato = """
                ******************************************
                Dados iniciais do cliente:
                
                Nome :           %s
                Tipo Conta:      %s
                Saldo %s:   R$ %.2f
                ******************************************
                """;
       exibirDadosClientes = String.format(dadosClientesFormato, nomeCliente, tipoConta, "inicial", saldo);

        String operadores = ("""
                
                Operadores
                
                1- Consultar Saldos
                2- Receber Valor
                3- Transferir Valor
                4- Conlsultar dados
                5- Sair
                
                Digite a opção Desejada:
                """);
        System.out.println(exibirDadosClientes);
       while (escolha != 5) {
            System.out.println(operadores);
            escolha = scan.nextInt();

            if (escolha == 1) {
                System.out.println("Seu saldo é de: " + saldo);
            } else if (escolha == 2) {
                System.out.println("Qual valor você vai receber?");
                double receberValor = scan.nextDouble();
                saldo += receberValor;
                if (receberValor < 0) {
                    System.out.println("O valor adicionado é negativo, se você pretende transferir algo, escolha a opção 3");
                } else {
                    System.out.println("seu saldo agora é de: " + saldo);
                }
            } else if (escolha == 3) {
                System.out.println("Qual valor você vai transferir?");
                double transferirValor = scan.nextDouble();
                saldo -= transferirValor;
                if (saldo < transferirValor) {
                    System.out.println("não há dinheiro suficiente para transferir.");
                } else {
                    System.out.println("Seu saldo agora é de: " + saldo);
                }
            } else if (escolha == 4) {
                exibirDadosClientes = String.format(dadosClientesFormato, nomeCliente, tipoConta, "Atual", saldo);
                System.out.println(exibirDadosClientes);
            } else {
                System.out.println("escolha uma opção válida: ");
            }
        }
    }
}
