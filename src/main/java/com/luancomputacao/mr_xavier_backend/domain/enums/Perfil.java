package com.luancomputacao.mr_xavier_backend.domain.enums;

public enum Perfil {
    ADMIN(1, "ROLE_ADMIN"),
    PROFESSOR(2, "ROLE_CLIENTE"),
    MODERADOR(3, "ROLE_MODERADOR")
    ;

    private int cod;
    private String description;

    Perfil(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static Perfil toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null) {
            return null;
        }

        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalAccessException("Id invalido: " + cod);
    }
}
