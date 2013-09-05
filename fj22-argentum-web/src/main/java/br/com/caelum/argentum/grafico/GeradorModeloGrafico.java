package br.com.caelum.argentum.grafico;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorModeloGrafico {

	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private CartesianChartModel modeloGrafico;

	public SerieTemporal getSerie() {
		return serie;
	}

	public int getComeco() {
		return comeco;
	}

	public int getFim() {
		return fim;
	}

	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.modeloGrafico = new CartesianChartModel();
	}

	public void plotaMediaMovel(Indicador indicador) {
		LineChartSeries chartSerie = new LineChartSeries(indicador.toString());

		for (int i = comeco; i <= fim; i++) {
			double valor = indicador.calcula(i, serie);
			chartSerie.set(i, valor);
		}

		this.modeloGrafico.addSeries(chartSerie);

	}

}
