package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    // Número identificador do contrato
    private Integer number;

    // Data em que o contrato foi firmado
    private LocalDate date;

    // Valor total do contrato
    private Double totalValue;

    // Lista de parcelas associadas ao contrato
    private List<Installment> installments = new ArrayList<>();

    // Construtor padrão, necessário para instanciar objetos sem definir atributos iniciais
    public Contract() {        
    }

    // Construtor que permite inicializar o contrato com número, data e valor total
    public Contract(Integer number, LocalDate date, Double totalValue) {        
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    // Retorna o número do contrato
    public Integer getNumber() {
        return number;
    }

    // Define o número do contrato
    public void setNumber(Integer number) {
        this.number = number;
    }

    // Retorna a data do contrato
    public LocalDate getDate() {
        return date;
    }

    // Define a data do contrato
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Retorna o valor total do contrato
    public Double getTotalValue() {
        return totalValue;
    }

    // Define o valor total do contrato
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    // Retorna a lista de parcelas associadas ao contrato
    public List<Installment> getInstallments() {
        return installments;
    }    
    
    // Nota: não há setter para 'installments' porque a manipulação da lista é feita diretamente
    // usando métodos como add(), remove(), etc., garantindo maior controle sobre os dados.
}
