
package model.entidades;


public final class Fatura {
    
    private Double valorBase;
    private Double taxa;

    public Fatura(Double valorBase, Double taxa) {
        this.valorBase = valorBase;
        this.taxa = taxa;
    }

    public Fatura() {
    }
    

    public Double getValorBase() {
        return valorBase;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }
    
    public Double getValorTotal(){
        return getValorBase() + getTaxa();
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Fatura: ").append("\n");
        sb.append("Valor base: ").append(getValorBase()).append("\n");
        sb.append("Taxa: ").append(getTaxa()).append("\n");
        sb.append("Valor total: ").append(getValorTotal());
        
        return sb.toString();
    }
    
    
    
}
