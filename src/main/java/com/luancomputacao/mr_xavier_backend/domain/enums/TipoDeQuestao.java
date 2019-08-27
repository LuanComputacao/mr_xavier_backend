package com.luancomputacao.mr_xavier_backend.domain.enums;

public enum TipoDeQuestao {
    DISCURSIVA(1),
    OBJETIVA(2);

    private final int tipoDeQuestao;

    TipoDeQuestao(int i) {
        this.tipoDeQuestao = i;
    }

    public int getTipoDeQuestao() {
        return tipoDeQuestao;
    }

    public static TipoDeQuestao fromNumber(int number) {
        switch (number) {
            case 1:
                return TipoDeQuestao.DISCURSIVA;
            case 2:
                return TipoDeQuestao.OBJETIVA;
            default:
                return TipoDeQuestao.OBJETIVA;
        }
    }
}
