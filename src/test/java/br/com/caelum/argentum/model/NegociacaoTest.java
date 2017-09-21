package br.com.caelum.argentum.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

class NegociacaoTest {

    @Test
    void quantidadeNegativa() {

        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao = new Negociacao(10, 10, hoje);

        Assertions.assertEquals(10, negociacao.getQuantidade());
    }

    @Test
    void precoNegativo() {

        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao = new Negociacao(1000, -10, hoje);

        Assertions.assertEquals(1000, negociacao.getPreco());
    }

    @Test
    void dataDaNegociacaoEhImutavel() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        Negociacao negociacao = new Negociacao(10,5, calendar);

        negociacao.getData().set(Calendar.DAY_OF_MONTH, 20);

        Assertions.assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void naoCriaNegociacaoComDataNula() {
       Assertions.assertThrows(IllegalArgumentException.class, () -> {
           new Negociacao(20, 5, null);
       });
    }

    @Test
    void mesmoMilissegundoEhDoMesmoDia() {

        Calendar agora = Calendar.getInstance();
        Calendar mesmoMomento = (Calendar) agora.clone();

        Negociacao negociacao = new Negociacao(40.0, 100, agora);

        Assertions.assertTrue(negociacao.isMesmoDia(mesmoMomento));
    }

    @Test
    void comHorarioDiferentesEhNoMesmoDia() {

        // usando GregorianCalendar(ano, mes, dia, hora, minuto)

        Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
        Calendar tarte = new GregorianCalendar(2011, 10, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, manha );
        Assertions.assertTrue(negociacao.isMesmoDia(tarte));
    }

    @Test
    void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {

        Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
        Calendar tarte = new GregorianCalendar(2011, 11, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, manha );
        Assertions.assertFalse(negociacao.isMesmoDia(tarte));
    }

    @Test
    void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {

        Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
        Calendar tarte = new GregorianCalendar(2012, 10, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, manha );
        Assertions.assertFalse(negociacao.isMesmoDia(tarte));
    }
}