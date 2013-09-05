package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	private int intervalo;
	private Indicador outroIndicador;

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		int peso = 1;
		int somaPeso = 0;

		for (int i = posicao - (intervalo - 1); i <= posicao; i++) {
			soma += outroIndicador.calcula(i, serie) * peso;
			somaPeso += peso;
			peso++;

		}

		return soma / ((somaPeso < 0) ? 1 : somaPeso);
	}

	public String toString() {
		return "MMP de " + outroIndicador.toString();
	}

	public MediaMovelPonderada(int intervalo, Indicador indicador) {
		this.intervalo = intervalo;
		this.outroIndicador = indicador;
	}

}
