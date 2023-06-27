package model.servicos;

public class TaxaServicoBrasil implements TaxaServico {

    @Override
    public Double taxa(Double valor) {

        if (valor <= 100) {
            return valor * 0.2;
        }

        return valor * 0.15;
    }

}
