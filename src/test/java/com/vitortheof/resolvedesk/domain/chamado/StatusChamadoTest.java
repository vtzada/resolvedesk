package com.vitortheof.resolvedesk.domain.chamado;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatusChamadoTest {

    @Test
    void abertoPodeIrParaEmAtendimento() {
        assertTrue(StatusChamado.ABERTO.podeTransitarPara(StatusChamado.EM_ATENDIMENTO));
    }

    @Test
    void fechadoNaoPodeMudarDeStatus() {
        for (StatusChamado destino : StatusChamado.values()) {
            assertFalse(StatusChamado.FECHADO.podeTransitarPara(destino));
        }
    }

    @Test
    void abertoNaoPodeMudarParaResolvido() {
        assertFalse(StatusChamado.ABERTO.podeTransitarPara(StatusChamado.RESOLVIDO));
    }
}
