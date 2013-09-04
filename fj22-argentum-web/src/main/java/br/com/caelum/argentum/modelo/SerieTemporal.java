package br.com.caelum.argentum.modelo;

import java.util.List;

public class SerieTemporal {

	private final List<Candlestick> candles;

	public SerieTemporal(List<Candlestick> candles)
			throws IllegalArgumentException {
		if (candles == null) {
			throw new IllegalArgumentException("a lista não pode ser nula");
		}
		this.candles = candles;
	}

	public Candlestick getCandle(int i) {
		return this.candles.get(i);
	}

	public int getTotal() {
		return this.candles.size();
	}

}
