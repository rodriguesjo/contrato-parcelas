package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

    public static void main(String[] args) {
        
        // Define o padrão de localização para os Estados Unidos (formatação de números e datas)
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        // Define o formato de data esperado no programa
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Solicita ao usuário os dados do contrato
        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Numero: ");
        int number = sc.nextInt(); // Lê o número do contrato
        
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt); // Converte a data inserida pelo usuário no formato especificado
        
        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble(); // Lê o valor total do contrato
        
        // Cria uma instância do contrato com os dados fornecidos
        Contract obj = new Contract(number, date, totalValue);
        
        System.out.println();
        
        // Solicita o número de parcelas ao usuário
        System.out.print("Entre com o número de parcelas: ");
        int parcelas = sc.nextInt(); // Lê a quantidade de parcelas do contrato
        
        System.out.println();
        
        // Instancia o serviço de contrato, configurando-o com o serviço de pagamento (Paypal)
        ContractService cs = new ContractService(new PaypalService());
        
        // Processa o contrato, gerando as parcelas
        cs.processContract(obj, parcelas);
        
        // Exibe as parcelas geradas na saída
        System.out.println("Parcelas: ");
        for (Installment installment : obj.getInstallments()) {
            System.out.println(installment); // A chamada ao método toString da classe Installment formata a saída
        }        
        
        // Fecha o scanner para evitar vazamentos de recursos
        sc.close();
    }
}
