import java.util.Scanner;
import java.util.Random;

public abstract class ContaBanco {


    private final int agencia = 123;
    private int numeroConta;
    private int senha;
    private int senha2;
    private boolean validacaoSenha = false;
    private Cliente cliente;
    private double saldo;
    private double deposito;

    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        setNumeroConta(0);
        return numeroConta;
    }

    public boolean validaSenha() {
        System.out.println("Informe sua senha!");
        int senha2 = scan.nextInt();
        if (this.senha == senha2) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean validaCpf() {
//        System.out.println("Informe seu cpf!");
//        String cpf2 = scan.nextLine();
//        if (getCliente().getCpf() == cpf2) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = random.nextInt(100);
    }

    public int getSenha() {
        return senha;
    }

    public boolean setSenha(int senha) {
        do {
            System.out.println("Defina sua senha");
            this.senha = scan.nextInt();

            System.out.println("Confirme a senha");
            this.senha2 = scan.nextInt();

            if (this.senha2 == this.senha) {
                System.out.println("Senha cadastrada com sucesso");
                validacaoSenha = true;
            } else {
                System.out.println("Senhas não batem");
                validacaoSenha = false;
            }
        } while (validacaoSenha != true);
        return true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    abstract void cadastrarConta();

    public void deposito(Cliente cliente) {
        if (validaSenha() == true) {
            System.out.println("Qual será o valor do depósito");
            deposito = scan.nextDouble();
            this.saldo += deposito;
            System.out.println("O cliente: " + cliente.getNome() + " depositou: " + deposito);
        } else {
            System.out.println("Senha inválida");
        }
    }

    public double getSaldo(Cliente cliente) {
        if (validaSenha() == true) {
            return this.saldo;
        } else {
            System.out.println("Senha inválida");
            return 0;
        }
    }


    public boolean saca(Cliente cliente) {
        if (validaSenha() == true) {
            System.out.println("Qual o valor que você deseja sacar");
            double sacar = scan.nextDouble();
            if (sacar <= this.saldo) {
                this.saldo -= sacar;
                return true;
            } else {
                System.out.println("Você está tentando sacar um valor maior que o saldo");
                return false;
            }
        } else {
            System.out.println("Senha inválida");
            return false;
        }

    }

    public boolean transfere(ContaBanco destino) {
        if (validaSenha() == true) {
            System.out.println("Qual o valor que será transferido");
            double valor = scan.nextDouble();
            if (valor <= this.saldo) {
                this.saldo -= valor;
                destino.saldo += valor;
                return true;
            } else {
                System.out.println("O valor a ser transferido é maior que o saldo atual");
                return false;
            }
        } else {
            System.out.println("Senha inválida");
            return false;
        }
    }


}
