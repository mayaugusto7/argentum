package br.com.caelum.argentum.service;

import br.com.caelum.argentum.model.Candlestick;
import br.com.caelum.argentum.model.Negociacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

class CandlestickFactoryTest {

    @Test
    void sequenciaSimplesDeNegocios() {

        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

        List<Negociacao> negociacaos = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandlestickFactory fabrica = new CandlestickFactory();

        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacaos);

        Assertions.assertEquals(40.5, candle.getAbertura(), 0.00001);
        Assertions.assertEquals(42.3, candle.getFechamento(), 0.00001);
        Assertions.assertEquals(39.8, candle.getMinimo(), 0.00001);
        Assertions.assertEquals(45.0, candle.getMaximo(), 0.00001);
        Assertions.assertEquals(16760.0, candle.getVolume(), 0.00001);
    }

    @Test
    void semNegociosGeraCandleComZeros() {

        Calendar hoje = Calendar.getInstance();

        List<Negociacao> negociacaos = Arrays.asList();

        CandlestickFactory fabrica = new CandlestickFactory();

        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacaos);

        Assertions.assertEquals(0.0, candle.getAbertura(), 0.00001);
        Assertions.assertEquals(0.0, candle.getFechamento(), 0.00001);
        Assertions.assertEquals(0.0, candle.getMinimo(), 0.00001);
        Assertions.assertEquals(0.0, candle.getMaximo(), 0.00001);
        Assertions.assertEquals(0.0, candle.getVolume(), 0.00001);
    }

    @Test
    void apenasUmNegocioGeraCandleComValoresIguais() {

        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);

        List<Negociacao> negociacaos = Arrays.asList(negociacao1);

        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacaos);

        Assertions.assertEquals(40.5, candle.getAbertura(), 0.00001);
        Assertions.assertEquals(40.5, candle.getFechamento(), 0.00001);
        Assertions.assertEquals(40.5, candle.getMinimo(), 0.00001);
        Assertions.assertEquals(40.5, candle.getMaximo(), 0.00001);
        Assertions.assertEquals(4050.0, candle.getVolume(), 0.00001);
    }

}