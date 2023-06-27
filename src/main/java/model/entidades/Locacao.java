
package model.entidades;

import java.time.LocalDateTime;
import model.exceptions.LocacaoException;


public class Locacao {
    
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinal;
    private Double valorDia;
    private Double valorHora;
    
    private Veiculo veiculo;
    private Fatura fatura;

    public Locacao(LocalDateTime dataInicio, LocalDateTime dataFinal, Veiculo veiculo,  Double valorDia,  Double valorHora) {
        
        if (dataFinal.isBefore(dataInicio)){
            throw new LocacaoException("Erro ao gerar locação: Data de retirada do veiculo anterior a data de busca!");
        }
        if (valorDia <= 0){
            throw new LocacaoException("Erro ao gerar locação: Valor por hora inválido!");
        }
        
        if (valorHora <= 0){
            throw new LocacaoException("Erro ao gerar locação: Valor diário inválido!");
        }
        
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.veiculo = veiculo;
        this.fatura = null;
        this.valorDia = valorDia;
        this.valorHora = valorHora;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public Double getValorDia() {
        return valorDia;
    }

    public void setValorDia(Double valorDia) {
        this.valorDia = valorDia;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }
    
    
    
}
