package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

// Classe responsável pelo processamento de contratos e geração de parcelas
public class ContractService {

    // Dependência para o serviço de pagamento online
    private OnlinePaymentService onlinePaymentService;

    /**
     * Construtor que injeta uma implementação do serviço de pagamento online.
     * @param onlinePaymentService Implementação de OnlinePaymentService usada para calcular juros e taxas.
     */
    public ContractService(OnlinePaymentService onlinePaymentService) {        
        this.onlinePaymentService = onlinePaymentService;
    }
    
    /**
     * Processa um contrato dividindo o valor total em parcelas e aplicando taxas e juros.
     * @param contract O contrato a ser processado.
     * @param months Número de parcelas em que o contrato será dividido.
     */
    public void processContract(Contract contract, int months) {
        
        // Calcula o valor básico de cada parcela (sem juros ou taxas)
        double basicQuota = contract.getTotalValue() / months;

        // Itera sobre o número de parcelas
        for (int i = 1; i <= months; i++) {
            // Calcula a data de vencimento para a parcela atual
            LocalDate dueDate = contract.getDate().plusMonths(i);
            
            // Calcula os juros aplicados para o mês atual
            double interest = onlinePaymentService.interest(basicQuota, i);

            // Calcula a taxa de pagamento para o valor com juros
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);

            // Soma o valor básico, os juros e a taxa para obter o valor total da parcela
            double amount = basicQuota + interest + fee;
            
            // Adiciona a parcela calculada ao contrato
            contract.getInstallments().add(new Installment(dueDate, amount));
        }
    }
}
