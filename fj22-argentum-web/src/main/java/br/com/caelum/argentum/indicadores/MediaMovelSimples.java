package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private int intervalo;
	private Indicador outroIndicador;

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao - (intervalo - 1); i <= posicao; i++) {
			soma += outroIndicador.calcula(i, serie);
		}
		return soma / intervalo;
	}

	public String toString() {
		return "MMS de " + outroIndicador.toString();
	}

	public MediaMovelSimples(int intervalo, Indicador indicador) {
		this.intervalo = intervalo;
		this.outroIndicador = indicador;
	}

}
