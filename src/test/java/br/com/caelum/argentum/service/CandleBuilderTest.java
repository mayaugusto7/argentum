package br.com.caelum.argentum.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CandleBuilderTest {

    @Test
    void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {

        CandleBuilder candleBuilder = new CandleBuilder();

        candleBuilder
                .comAbertura(-10)
                .comFechamento(1)
                .comMaximo(10)
                .comMinimo(20)
                .comVolume(-10)
                .comData(null);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            candleBuilder.gerarCandle();
        });


    }

}