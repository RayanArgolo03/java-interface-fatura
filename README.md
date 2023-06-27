# Projeto Locação de Veículos

Este projeto consiste em um sistema de locação de veículos voltado a implementação de interface, onde é possível registrar locações, gerar faturas e calcular taxas de acordo com as regras estabelecidas. Exercício do curso Java Básico da Udemy.


## Exemplo de Uso

Aqui está um exemplo de uso das classes e métodos do projeto:

```java
// Criação de objetos
Veiculo veiculo = new Veiculo("Carro A");
LocalDateTime dataInicio = LocalDateTime.now();
LocalDateTime dataFinal = dataInicio.plusHours(3);
Double valorDia = 100.0;
Double valorHora = 20.0;

// Criação de uma locação
Locacao locacao = new Locacao(dataInicio, dataFinal, veiculo, valorDia, valorHora);

// Criação de um serviço de taxa para o Brasil
TaxaServico taxaServico = new TaxaServicoBrasil();

// Criação de um gerador de faturas com o serviço de taxa
GerarFatura gerarFatura = new GerarFatura(taxaServico);

// Geração da fatura da locação
gerarFatura.gerarFatura(locacao);

// Acesso aos atributos da fatura
Double valorBase = locacao.getFatura().getValorBase();
Double taxa = locacao.getFatura().getTaxa();
Double valorTotal = locacao.getFatura().getValorTotal();

System.out.println("Valor Base: " + valorBase);
System.out.println("Taxa: " + taxa);
System.out.println("Valor Total: " + valorTotal);
