package com.vitortheof.resolvedesk.domain.chamado;

public class TransicaoDeStatusInvalidaException extends RuntimeException {
    public TransicaoDeStatusInvalidaException(StatusChamado atual, StatusChamado destino) {
        super("Não é possível mudar de %s para %s".formatted(atual, destino));
    }
}
