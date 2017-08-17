package com.nutrisoft.util;

import java.text.SimpleDateFormat;
import java.util.List;

import com.nutrisoft.model.Consulta;
import com.nutrisoft.service.ClienteService;
import com.nutrisoft.service.ConsultaService;

import be.ceau.chart.LineChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.LineData;
import be.ceau.chart.dataset.LineDataset;

public class GraficoComposicaoCorporal extends GraficoBase {

	public GraficoComposicaoCorporal(ClienteService clienteService, ConsultaService consultaService) {
		super(clienteService, consultaService);
		// TODO Auto-generated constructor stub
	}

	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public LineChart formatarDados(List<Consulta> lista) {

		if(lista.isEmpty() || lista.size() < 2)
		{
			return null;
		}

		String[] datas = new String[lista.size()];
		double[] percentual = new double[lista.size()];


		for (int i = 0; i < lista.size(); i++) {
			Consulta consulta = (Consulta) lista.get(i);
			datas[i] = sdf1.format(consulta.getAgendamento().getDataAgendamento());
			percentual[i] = consulta.getAntropometria().getPeitoral();
		}

		
		LineDataset dataSetDesejavel = new LineDataset()
				.setLabel("Percentual (%) de Gordura")
				.setData(percentual)
				.setFill(false)
				 .setBorderColor(Color.RED)
				.setBackgroundColor(Color.RED);
		
		LineData data = new LineData()
				.addLabels(datas)
				.addDataset(dataSetDesejavel);

		return new LineChart(data);
	
	}

}
