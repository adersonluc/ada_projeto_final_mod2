package br.com.arri.model;

import java.math.BigDecimal;

public enum Categoria {

    ELETRONICOS{
        @Override
        BigDecimal valorTaxa() {
            return new BigDecimal("0.04");
        }
    },
    VESTUARIO{
        @Override
        BigDecimal valorTaxa() {
            return new BigDecimal("0.05");
        }
    },
    ALIMENTICIO{
        @Override
        BigDecimal valorTaxa() {
            return new BigDecimal("0.02");
        }
    },
    BRINQUEDOS{
        @Override
        BigDecimal valorTaxa() {
            return new BigDecimal("0.04");
        }
    };

    abstract BigDecimal valorTaxa();

}
