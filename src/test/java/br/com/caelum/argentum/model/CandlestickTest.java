package br.com.caelum.argentum.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * Created by macbookpro on 15/09/17.
 */
class CandlestickTest {

    @Test
    void precoMaximoNaoPodeSerMenorQueMinimo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
        });
    }

    @Test
    void candlestickNaoPodeTerValoresNegativos() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Candlestick(-10, -20, -20, -10, -100, Calendar.getInstance());
        });
    }

    @Test
    void candlestickNaoPodeSerNulo() {
        Candlestick candlestick = null;
        Assertions.assertNull(candlestick);
    }
}