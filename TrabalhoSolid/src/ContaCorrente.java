
public class ContaCorrente extends ContaBanco {

    Cliente cliente;

    ContaCorrente(Cliente cliente, int agencia, int numeroConta) {
        this.cliente = cliente;
        getAgencia();
        getNumeroConta();
    }

    public void cadastrarConta() {
       // if (validaCpf()) {
            if (setSenha(0) == true) {
                System.out.println("Código da Agência: " + getAgencia());
                System.out.println("Número da Conta: " + getNumeroConta());
                System.out.println("Conta Corrente cadastrada para o cliente:  " + cliente.getNome());
            }
       // } else {
     //       System.out.println("Cpf inválido");
      //  }
    }


}
