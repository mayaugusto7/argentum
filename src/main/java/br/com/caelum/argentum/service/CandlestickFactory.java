package br.com.caelum.argentum.service;

import br.com.caelum.argentum.model.Candlestick;
import br.com.caelum.argentum.model.Negociacao;

import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

    public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacaos) {

        //double maximo = negociacaos.get(0).getPreco();
        //double minimo = negociacaos.get(0).getPreco();

        //double maximo = Double.MIN_VALUE;
        //double minimo = Double.MAX_VALUE;

        double maximo = negociacaos.isEmpty() ? 0 : negociacaos.get(0).getPreco();
        double minimo = negociacaos.isEmpty() ? 0 : negociacaos.get(0).getPreco();
        double volume = negociacaos.isEmpty() ? 0 : negociacaos.get(0).getVolume();

        for (Negociacao negociacao : negociacaos) {

            volume += negociacao.getVolume();

            if (negociacao.getPreco() > maximo) {
                maximo = negociacao.getPreco();
            } else if (negociacao.getPreco() < minimo) {
                minimo = negociacao.getPreco();
            }

        }


        double abertura = negociacaos.isEmpty() ? 0 :  negociacaos.get(0).getPreco();
        double fechamento = negociacaos.isEmpty() ? 0 : negociacaos.get(negociacaos.size()-1).getPreco();

        return new Candlestick(abertura, fechamento, minimo, maximo,
                volume, data);
    }
}
