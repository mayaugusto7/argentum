package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.model.Candlestick;
import br.com.caelum.argentum.service.CandleBuilder;

import java.util.GregorianCalendar;

/**
 * Created by macbookpro on 14/09/17.
 */
public class TestaCandleBuilder {

    public static void main(String[] args) {

        CandleBuilder builder = new CandleBuilder();

        builder
            .comAbertura(40.5)
            .comFechamento(42.3)
            .comMinimo(39.8)
            .comMaximo(45.0)
            .comVolume(145234.20)
            .comData(new GregorianCalendar(2012,8,12,0,0,0));

        Candlestick candle = builder.gerarCandle();
    }
}
