package br.com.caelum.argentum.reader;

import br.com.caelum.argentum.model.Negociacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeitorXMLTest {

    @Test
    void carregaXmlComUmaNegociacaoEmListaUnitaria() {

        StringBuilder xmlDeTeste = new StringBuilder();

        xmlDeTeste.append("<list>")
                    .append("<negociacao>")
                    .append("<preco>43.5</preco>")
                    .append("<quantidade>1000</quantidade> ")
                    .append(" <data> <time>1322233344455</time></data>")
                    .append("</negociacao>")
                    .append("</list>");

        LeitorXML leitor = new LeitorXML();

        InputStream xml = new ByteArrayInputStream(xmlDeTeste.toString().getBytes());

        List<Negociacao> negociacoes = leitor.carrega(xml);

        Assertions.assertEquals(1, negociacoes.size());
        Assertions.assertEquals(43.5, negociacoes.get(0).getPreco());
        Assertions.assertEquals(1000, negociacoes.get(0).getQuantidade());
        Assertions.assertEquals(false, negociacoes.isEmpty());
        Assertions.assertEquals(42.5, negociacoes.get(0).getPreco());
        Assertions.assertEquals(999, negociacoes.get(0).getQuantidade());
    }

}