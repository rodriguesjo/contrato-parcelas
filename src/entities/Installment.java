package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

	/** O DateTimeFormatter é declarado como estático porque o formato de data "dd/MM/yyyy" 
	 * é constante e compartilhado por todas as instâncias da classe Installment. 
	 * Isso evita a necessidade de criar um novo objeto DateTimeFormatter
	 * para cada instância, economizando recursos de memória e processamento. 
	 *  A palavra-chave 'static' indica que este campo pertence à classe, não às instâncias, 
	 *  tornando-o acessível e compartilhado de maneira global dentro da classe Installment.
	 * Formatação padrão para exibição de datas (dia/mês/ano)
	 */
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Data de vencimento da parcela
    private LocalDate dueDate;

    // Valor da parcela
    private Double amount;

    // Construtor que inicializa a data de vencimento e o valor da parcela
    public Installment(LocalDate dueDate, Double amount) {        
        this.dueDate = dueDate;
        this.amount = amount;
    }

    // Retorna a data de vencimento da parcela
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Define a data de vencimento da parcela
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Retorna o valor da parcela
    public Double getAmount() {
        return amount;
    }

    // Define o valor da parcela
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // Sobrescreve o método toString para exibir a parcela como uma string formatada
    // Exemplo: "20/12/2024 - 500.00"
    @Override
    public String toString() {
        return dueDate.format(fmt) + " - " + String.format("%.2f", amount);
    }
}
