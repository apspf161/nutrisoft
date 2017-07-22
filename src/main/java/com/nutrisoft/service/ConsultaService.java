package	 com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Consulta;

public interface ConsultaService {
	
	public void addConsulta(Consulta consulta);
	
	public void updateConsulta(Consulta consulta);
	
	public void removeConsulta(int id);
	
	List<Consulta> filtrarListaPagamentos(Consulta consulta);

	void efetuarPagamento(Consulta consulta);

	public List<Consulta> listConsultas();
	
	public Consulta getConsultaById(int id);

}