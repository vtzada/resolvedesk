package com.vitortheof.resolvedesk.domain.chamado;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChamadoTest {

    @Test
    void chamadoDeveIniciarEmAberto() {
        Chamado novoChamado = novoChamado();
        assertEquals(StatusChamado.ABERTO, novoChamado.getStatus());
    }

    @Test
    void falharEmFecharUmChamadoEmAberto() {
        Chamado novoChamado = novoChamado();
        assertThrows(TransicaoDeStatusInvalidaException.class, novoChamado::fechar);
    }

    @Test
    void lancarExcecaoQuandoTituloTiverEmBranco() {
        UUID clienteId = UUID.randomUUID();
        var excecao = assertThrows(IllegalArgumentException.class,
                () -> new Chamado("", "Socorro", Prioridade.ALTA, clienteId));
        assertEquals("Título é obrigatório", excecao.getMessage());
    }

    private Chamado novoChamado() {
        return new Chamado("Erro no login", "Não consigo entrar", Prioridade.ALTA, UUID.randomUUID());
    }
}
