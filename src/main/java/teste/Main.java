package teste;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entidades.Locacao;
import model.entidades.Veiculo;
import model.exceptions.GerarFaturaException;
import model.exceptions.LocacaoException;
import model.servicos.GerarFatura;
import model.servicos.TaxaServicoBrasil;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            String modelo = sc.nextLine();
            LocalDateTime dataInicio = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            LocalDateTime dataFinal = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

            Double valorHora = sc.nextDouble();
            Double valorDia = sc.nextDouble();

            Locacao l = new Locacao(dataInicio, dataFinal, new Veiculo(modelo), valorDia, valorHora);

            GerarFatura gr = new GerarFatura(new TaxaServicoBrasil());
            gr.gerarFatura(l);

            System.out.println(l.getFatura());
        }
        
         catch (LocacaoException | GerarFaturaException e){
             e.printStackTrace();
             System.out.println(e.getMessage());
        }
        
        catch (RuntimeException e) {
            System.out.println("Erro na entrada de dados!");
        }
        
       
        
        finally {
            sc.close();
        }

    }
}
