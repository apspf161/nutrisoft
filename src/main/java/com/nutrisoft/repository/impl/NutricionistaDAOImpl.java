package com.nutrisoft.repository.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.nutrisoft.model.Nutricionista;
import com.nutrisoft.repository.NutricionistaDAO;
import com.nutrisoft.repository.RepositorioGenericoDados;

@Repository
public class NutricionistaDAOImpl extends RepositorioGenericoDados<Nutricionista, Integer> implements NutricionistaDAO {
				
	public NutricionistaDAOImpl() {
		super(Nutricionista.class);
	}
	
	@Override
	public List<Nutricionista> buscarFiltroListaNutricionista(Nutricionista Nutricionista) {
		Map<String, Object> mapeamentoAtributos = new HashMap<String, Object>();

		List<Nutricionista> listaNutricionista = this.obterPorCriteriosLike(mapeamentoAtributos);

		return listaNutricionista;
	}
}