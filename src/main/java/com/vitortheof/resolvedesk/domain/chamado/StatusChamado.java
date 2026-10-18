package com.vitortheof.resolvedesk.domain.chamado;

public enum StatusChamado {
    ABERTO, EM_ATENDIMENTO, RESOLVIDO, FECHADO;

    public boolean podeTransitarPara(StatusChamado destino) {
        return switch (this) {
            case ABERTO -> destino == EM_ATENDIMENTO;
            case EM_ATENDIMENTO ->  destino == RESOLVIDO;
            case RESOLVIDO -> destino == FECHADO || destino == EM_ATENDIMENTO;
            case FECHADO -> false;
        };
    }
}
