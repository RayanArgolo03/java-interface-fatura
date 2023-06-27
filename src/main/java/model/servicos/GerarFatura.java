
package model.servicos;

import java.time.Duration;
import model.entidades.Fatura;
import model.entidades.Locacao;
import model.exceptions.GerarFaturaException;


public class GerarFatura {
    
    
    private TaxaServico taxaServico;

    public GerarFatura(TaxaServico taxaServico) {
        this.taxaServico = taxaServico;
    }
    
    public void gerarFatura(Locacao locacao){
        
        double minutos = Duration.between(locacao.getDataInicio(), locacao.getDataFinal()).toMinutes();
        double horas = minutos / 60;
        
        if (!temHora(horas)){
            throw new GerarFaturaException("Erro ao gerar fatura: Não completou uma hora de locação!");
        }
        
        Double valorBase = 0.0;
        
        if (horas <=  12){
            valorBase = Math.ceil(horas) *  locacao.getValorHora();
        } else {
            valorBase = Math.ceil(horas / 24) * locacao.getValorDia();
        }
        
        Double taxa = taxaServico.taxa(valorBase);
        
        locacao.setFatura(new Fatura(valorBase, taxa));
        
    }
    
    private boolean temHora(double hora){
        return hora >= 1;
    }
    
}
