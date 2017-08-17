package com.nutrisoft.util;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nutrisoft.model.Consulta;
import com.nutrisoft.service.ClienteService;
import com.nutrisoft.service.ConsultaService;

import be.ceau.chart.LineChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.LineData;
import be.ceau.chart.dataset.LineDataset;

@Component 
public class GraficoMetaDePeso extends GraficoBase {
	
	 @Autowired
	 public GraficoMetaDePeso(ClienteService clienteService, ConsultaService consultaService) {
		super(clienteService, consultaService);
	}

	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public LineChart formatarDados(List<Consulta> lista) {

		if(lista.isEmpty() || lista.size() < 2)
		{
			return null;
		}

		String[] datas = new String[lista.size()];
		double[] pesoDesejado = new double[lista.size()];
		double[] pesoUsual = new double[lista.size()];


		for (int i = 0; i < lista.size(); i++) {
			Consulta consulta = (Consulta) lista.get(i);
			datas[i] = sdf1.format(consulta.getAgendamento().getDataAgendamento());
			pesoDesejado[i] = consulta.getAntropometria().getPesoDesejavel();
			pesoUsual[i] = consulta.getAntropometria().getPesoUsual();
		}

		
		LineDataset dataSetDesejavel = new LineDataset()
				.setLabel("Peso Desejável")
				.setData(pesoDesejado)
				.setFill(false)
				 .setBorderColor(Color.RED)
				.setBackgroundColor(Color.RED);

		LineDataset dataSetAtual = new LineDataset()
				.setLabel("Peso Atual")
				.setData(pesoUsual)
				.setFill(false)
				.setBorderColor(Color.BLUE)
				.setBackgroundColor(Color.BLUE);
		
		
		LineData data = new LineData()
				.addLabels(datas)
				.addDataset(dataSetDesejavel)
				.addDataset(dataSetAtual);

		return new LineChart(data);
}

}
