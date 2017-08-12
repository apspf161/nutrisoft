package	 com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Consulta;

public interface ConsultaService {
	
	public void addConsulta(Consulta consulta) throws Exception;
	
	public void updateConsulta(Consulta consulta);
	
	public void removeConsulta(int id);
	
	List<Consulta> filtrarListaPagamentos(Consulta consulta);

	void efetuarPagamento(Consulta consulta);

	public List<Consulta> listConsultas();
	
	public Consulta getConsultaById(int id);

	public List<Consulta> listarConsultasAnteriores(Cliente cliente);

	public List<Consulta> filtrarListaRelatorioAtendimento(Consulta consulta);

	public List<Consulta> filtrarListaEvolucaoCliente(Consulta consulta);

}