package services;

// Classe que implementa o serviço de pagamento online específico do PayPal
public class PaypalService implements OnlinePaymentService {

    /**
     * Calcula a taxa de pagamento com base em 2% do valor total.
     * @param amount Valor base para o cálculo da taxa.
     * @return Valor da taxa aplicada.
     */
    @Override
    public double paymentFee(double amount) {        
        return amount * 0.02; // Aplica uma taxa fixa de 2% sobre o valor.
    }

    /**
     * Calcula os juros mensais com base em 1% por mês.
     * @param amount Valor base sobre o qual os juros serão aplicados.
     * @param months Número de meses para o cálculo dos juros.
     * @return Valor dos juros acumulados.
     */
    @Override
    public double interest(double amount, int months) {        
        return amount * 0.01 * months; // Aplica juros de 1% por mês ao valor base.
    }
}
