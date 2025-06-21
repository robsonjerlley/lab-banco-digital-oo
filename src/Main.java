import Exceptions.ServiceException;

public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("cliente");
		
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

        try {
            cc.depositar(0);
        } catch (ServiceException e) {
			System.out.println(e.getMessage());
        }

        try {
            cc.sacar(50);
        } catch (ServiceException e) {
			System.out.println(e.getMessage());
        }

        try {
            cc.transferir(100, poupanca);
        } catch (ServiceException e) {
			System.out.println(e.getMessage());
        }

        cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
