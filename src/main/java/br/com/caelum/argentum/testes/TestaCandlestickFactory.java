package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.model.Candlestick;
import br.com.caelum.argentum.model.Negociacao;
import br.com.caelum.argentum.service.CandlestickFactory;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by macbookpro on 14/09/17.
 */
public class TestaCandlestickFactory {

    public static void main(String[] args) {

        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

        List<Negociacao> negociacaos = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacaos);

        System.out.println(candle.getAbertura());
        System.out.println(candle.getFechamento());
        System.out.println(candle.getMinimo());
        System.out.println(candle.getMaximo());
        System.out.println(candle.getVolume());

        System.out.println(candle.toString());
    }
}
