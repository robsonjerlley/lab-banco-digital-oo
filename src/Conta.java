import Exceptions.ServiceException;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) throws ServiceException {
		if(valor <= this.saldo)
		saldo -= valor;
		else{
			throw new ServiceException("Saldo Insuficiente para realizar a operação");

        }

	}

	@Override
	public void depositar(double valor) throws ServiceException {
		if(valor >0)
		saldo += valor;
		else {
			throw new ServiceException("O valor do depósito deve ser maior que [0.0]");
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) throws ServiceException {
		if(valor <= this.saldo) {
			this.sacar(valor);
			contaDestino.depositar(valor);

		}else{
			throw new ServiceException("Saldo Insuficiente para realizar a operação");

		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
