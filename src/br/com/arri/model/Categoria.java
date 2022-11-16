package br.com.arri.model;

import java.math.BigDecimal;

public enum Categoria {

    ELETRONICOS{
        @Override
        public BigDecimal valorTaxa() {
            return new BigDecimal("0.04");
        }
    },
    VESTUARIO{
        @Override
        public BigDecimal valorTaxa() {
            return new BigDecimal("0.05");
        }
    },
    ALIMENTICIO{
        @Override
        public BigDecimal valorTaxa() {
            return new BigDecimal("0.02");
        }
    },
    BRINQUEDOS{
        @Override
        public BigDecimal valorTaxa() {
            return new BigDecimal("0.04");
        }
    };

    public abstract BigDecimal valorTaxa();

}
