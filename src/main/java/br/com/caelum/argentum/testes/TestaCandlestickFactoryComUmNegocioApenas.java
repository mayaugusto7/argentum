package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.model.Candlestick;
import br.com.caelum.argentum.model.Negociacao;
import br.com.caelum.argentum.service.CandlestickFactory;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by macbookpro on 15/09/17.
 */
public class TestaCandlestickFactoryComUmNegocioApenas {

    public static void main(String[] args) {

        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);

        List<Negociacao> negociacaos = Arrays.asList(negociacao1);

        CandlestickFactory fabrica = new CandlestickFactory();

        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacaos);

        System.out.println(candle.getAbertura());
        System.out.println(candle.getFechamento());
        System.out.println(candle.getMinimo());
        System.out.println(candle.getMaximo());
        System.out.println(candle.getVolume());
    }
}
