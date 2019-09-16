package com.luancomputacao.mr_xavier_backend.domain.enums;

public enum QuestionType {
    DISCURSIVA(1),
    OBJETIVA(2);

    private final int questionType;

    QuestionType(int i) {
        this.questionType = i;
    }

    public int getQuestionType() {
        return questionType;
    }

    public static QuestionType fromNumber(int number) {
        switch (number) {
            case 1:
                return QuestionType.DISCURSIVA;
            case 2:
                return QuestionType.OBJETIVA;
            default:
                return QuestionType.OBJETIVA;
        }
    }
}
