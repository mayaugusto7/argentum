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
public class TestaCandlestickFactoryValorZeradosOuNegativos {

    public static void main(String[] args) {

        Calendar hoje = Calendar.getInstance();

        Negociacao petrobras = new Negociacao(30, -100, hoje);

        //List<Negociacao> negociacaos = Arrays.asList();
        List<Negociacao> negociacaos = Arrays.asList(petrobras);

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
