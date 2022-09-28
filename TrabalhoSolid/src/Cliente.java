import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Cliente {


    Scanner scan = new Scanner(System.in);
    List<Cliente> clientes = new ArrayList<>();

    private String nome;
    private String cpf;

    Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void cadastrarCliente() {
        setNome("");
        setCpf("");
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        System.out.println("Informe o nome do cliente");
        this.nome = scan.nextLine();
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        System.out.println("Informe o cpf do cliente");
        this.cpf = scan.nextLine();
    }

}




