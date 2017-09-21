package br.com.caelum.argentum.model;

import java.util.Calendar;

public final class Negociacao {

    private final double preco;

    private final int quantidade;

    private final Calendar data;

    public Negociacao(double preco, int quantidade, Calendar data) {

        if (data == null) {
            throw new IllegalArgumentException("data não pode ser nula");
        }

        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Calendar getData() {
        return (Calendar) this.data.clone();
    }

    public double getVolume() {
        return this.preco * this.quantidade;
    }

    public boolean isMesmoDia(Calendar outraData) {
        //return this.data.equals(outraData);
        return this.data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH) &&
                this.data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH) &&
                this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
    }
}
