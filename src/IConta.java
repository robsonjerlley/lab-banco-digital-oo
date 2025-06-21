import Exceptions.ServiceException;

public interface IConta {
	
	void sacar(double valor) throws ServiceException;
	
	void depositar(double valor) throws ServiceException;
	
	void transferir(double valor, IConta contaDestino) throws ServiceException;
	
	void imprimirExtrato();
}
