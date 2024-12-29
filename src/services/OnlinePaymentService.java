package services;

// Interface que define os serviços de pagamento online
public interface OnlinePaymentService {

    /**
     * Calcula a taxa de pagamento com base no valor total.
     * @param amount Valor total a ser processado.
     * @return Taxa a ser adicionada ao valor total.
     */
    double paymentFee(double amount);

    /**
     * Calcula o valor do juros aplicados com base no valor total e no número de meses.
     * @param amount Valor principal sobre o qual os juros serão aplicados.
     * @param months Número de meses pelos quais os juros serão calculados.
     * @return Valor do juros acumulados.
     */
    double interest(double amount, int months);    
}
