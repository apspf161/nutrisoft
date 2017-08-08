package com.nutrisoft.repository;

import java.util.List;

import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Consulta;

public interface ConsultaDAO {

	public void salvar(Consulta consulta);

	public void excluir(Consulta consulta);

	public void alterar(Consulta consulta);

	public Consulta obterPorIdConsulta(Integer id);

	public List<Consulta> obterTodasAsConsultas();

	public List<Consulta> filtrarPagamentos(Consulta consulta);
	
	public List<Consulta> listarConsultasAnteriores(Cliente cliente);

	public List<Consulta> listarRelatorioAtendimento(Consulta consulta);
}