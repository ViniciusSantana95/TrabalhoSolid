import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcao = 99;
        boolean clienteCadastrado = false;
        boolean contaCorrenteCadastrada = false;
        boolean contaPoupancaCadastrada = false;

        Cliente cliente = new Cliente("", "");
        ContaCorrente cc = new ContaCorrente(cliente, 0, 0);
        ContaPoupanca cp = new ContaPoupanca(cliente, 0, 0);

        Scanner scan = new Scanner(System.in);


        do {

            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar conta corrente");
            System.out.println("3 - Cadastrar conta poupanca");
            System.out.println("4 - Efetuar Deposito");
            System.out.println("5 - Efetuar Saque");
            System.out.println("6 - Efetuar tranferência");
            System.out.println("7 - Mostrar saldo");
            opcao = scan.nextInt();

            System.out.println();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    if (clienteCadastrado == true) {
                        System.out.println("Cliente já cadastrado!\n");
                    } else {
                        cliente.cadastrarCliente();
                        clienteCadastrado = true;
                    }
                    break;
                case 2:
                    if (clienteCadastrado == true & contaCorrenteCadastrada == false) {
                        cc.cadastrarConta();
                        contaCorrenteCadastrada = true;
                    } else if (clienteCadastrado == true & contaCorrenteCadastrada == true) {
                        System.out.println("A Conta já foi cadastrada anteriormente! \n");
                    } else {
                        System.out.println("Ainda não existe cliente cadastrado, cadastre um cliente antes de criar uma conta! \n");
                    }
                    break;
                case 3:
                    if (clienteCadastrado == true & contaPoupancaCadastrada == false) {
                        cp.cadastrarConta();
                        contaPoupancaCadastrada = true;
                    } else if (clienteCadastrado == true & contaPoupancaCadastrada == true) {
                        System.out.println("A Conta já foi cadastrada anteriormente! \n");
                    } else {
                        System.out.println("Ainda não existe cliente cadastrado, cadastre um cliente antes de criar uma conta! \n");
                    }
                    break;
                case 4:
                    if (clienteCadastrado == true) {
                        System.out.println("Em qual conta será feito o deposito");
                        System.out.println("1 - Conta Corrente");
                        System.out.println("2 - Conta Poupança");
                        int escolha = scan.nextInt();
                        if (escolha == 1 && contaCorrenteCadastrada == true) {
                            cc.deposito(cliente);
                        } else if (escolha == 2 && contaPoupancaCadastrada == true) {
                            cp.deposito(cliente);
                        } else {
                            System.out.println("Opção inválida! Verifique se foi digitado a opção correta e se o cliente já possuí esse tipo de conta cadastrada ");
                        }
                    } else {
                        System.out.println("Ainda não existe cliente cadastrado, cadastre um cliente antes de realizar um depósito! \n");
                    }
                    break;
                case 5:
                    if (clienteCadastrado == true) {
                        System.out.println("De qual conta será feito o saque");
                        System.out.println("1 - Conta Corrente");
                        System.out.println("2 - Conta Poupança");
                        int escolha = scan.nextInt();
                        if (escolha == 1 && contaCorrenteCadastrada == true) {
                            cc.saca(cliente);
                        } else if (escolha == 2 && contaPoupancaCadastrada == true) {
                            cp.saca(cliente);
                        } else {
                            System.out.println("Opção inválida! Verifique se foi digitado a opção correta e se o cliente já possuí esse tipo de conta cadastrada ");
                        }
                    } else {
                        System.out.println("Ainda não existe cliente cadastrado, cadastre um cliente antes de realizar um depósito! \n");
                    }

                    break;
                case 6:
                    if (clienteCadastrado == true) {
                        System.out.println("De qual conta será retirado o valor");
                        System.out.println("1 - Conta Corrente para conta poupança");
                        System.out.println("2 - Conta Poupança para conta corrente");
                        int escolha = scan.nextInt();
                        if (escolha == 1 && contaCorrenteCadastrada == true) {
                            cc.transfere(cp);
                        } else if (escolha == 2 && contaPoupancaCadastrada == true) {
                            cp.transfere(cc);
                        } else {
                            System.out.println("Opção inválida! Verifique se foi digitado a opção correta e se o cliente já possuí esse tipo de conta cadastrada ");
                        }
                    } else {
                        System.out.println("Ainda não existe cliente cadastrado, cadastre um cliente antes de realizar um depósito! \n");
                    }
                    break;
                case 7:
                    if (clienteCadastrado == true) {
                        System.out.println("De qual conta você quer saber o saldo");
                        System.out.println("1 - Conta Corrente");
                        System.out.println("2 - Conta Poupança");
                        int escolha = scan.nextInt();
                        if (escolha == 1 && contaCorrenteCadastrada == true) {
                            System.out.println("Seu saldo é: " + cc.getSaldo(cliente));
                        } else if (escolha == 2 && contaPoupancaCadastrada == true) {
                            System.out.println("Seu saldo é: " + cp.getSaldo(cliente));
                        } else if (contaCorrenteCadastrada == false || contaPoupancaCadastrada == false) {
                            System.out.println("Conta ainda não cadastrada");
                        } else {
                            System.out.println("Opção inválida");
                        }
                    } else {
                        System.out.println("Ainda não existe cliente cadastrado, cadastre um cliente antes de verificar o saldo! \n");
                    }
                    break;
                default:

                    System.out.println("Opção inválida");
                    break;
            }

        } while (opcao != 0);


    }
}