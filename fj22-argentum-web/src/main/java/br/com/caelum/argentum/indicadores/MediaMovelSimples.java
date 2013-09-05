package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private int intervalo;

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao - (intervalo - 1); i <= posicao; i++) {
			soma += serie.getCandle(i).getFechamento();
		}
		return soma / intervalo;
	}

	public String toString() {
		return "MMS de Fechamento";
	}

	public MediaMovelSimples(int intervalo) {
		this.intervalo = intervalo;
	}
}
