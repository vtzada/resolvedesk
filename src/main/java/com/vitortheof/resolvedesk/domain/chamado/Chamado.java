package com.vitortheof.resolvedesk.domain.chamado;

import java.util.Objects;
import java.util.UUID;

public class Chamado {

    private final UUID id;
    private final String titulo;
    private final String descricao;
    private final Prioridade prioridade;
    private final UUID clienteId;
    private UUID atendenteId;
    private StatusChamado status;

    public Chamado(String titulo, String descricao, Prioridade prioridade, UUID clienteId) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título é obrigatório");
        }
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = Objects.requireNonNull(prioridade, "Prioridade é obrigatória");
        this.clienteId = Objects.requireNonNull(clienteId, "Cliente é obrigatório");
        this.status = StatusChamado.ABERTO;
    }

    public void assumir(UUID atendenteId) {
        Objects.requireNonNull(atendenteId, "Atendente é obrigatório");
        mudarStatus(StatusChamado.EM_ATENDIMENTO);
        this.atendenteId = atendenteId;
    }

    public void resolver() {
        mudarStatus(StatusChamado.RESOLVIDO);
    }

    public void fechar() {
        mudarStatus(StatusChamado.FECHADO);
    }

    private void mudarStatus(StatusChamado novo) {
        if (!status.podeTransitarPara(novo)) {
            throw new TransicaoDeStatusInvalidaException(status, novo);
        }
        this.status = novo;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public UUID getAtendenteId() {
        return atendenteId;
    }

    public StatusChamado getStatus() {
        return status;
    }
}
