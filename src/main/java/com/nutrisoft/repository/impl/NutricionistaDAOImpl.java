package com.nutrisoft.repository.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.nutrisoft.model.Nutricionista;
import com.nutrisoft.repository.NutricionistaDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;
import com.nutrisoft.repository.impl.NutricionistaDAOImpl;

@Repository
public class NutricionistaDAOImpl extends RepositorioGenericoDados<Nutricionista, Integer> implements NutricionistaDAO {
				
	public NutricionistaDAOImpl() {
		super(Nutricionista.class);
	}
	
	@Override
	public void salvar(Nutricionista Nutricionista){
		super.salvar(Nutricionista);
	}
	
	@Override
	public void excluir(Nutricionista Nutricionista){
		super.excluir(Nutricionista);
	}
	
	@Override
	public void alterar(Nutricionista Nutricionista){
		super.alterar(Nutricionista);
	}
	
	@Override
	public List<Nutricionista> obterTodasAsNutricionistas(){
		return this.obterTodos();
	}
	
	@Override
	public List<Nutricionista> buscarFiltroListaNutricionista(Nutricionista Nutricionista) {
		Map<String, Object> mapeamentoAtributos = new HashMap<String, Object>();

	/*	if(Nutricionista.getDescricao() != null)
		{
			mapeamentoAtributos.put(ATRIBUTO_Nutricionista_DESCRICAO, Nutricionista.getDescricao());
		}*/

		List<Nutricionista> listaNutricionista = this.obterPorCriteriosLike(mapeamentoAtributos);

		return listaNutricionista;
	}

	@Override
	public Nutricionista obterPorId(Integer id) {
		return obterPorId(id);
	}
}
