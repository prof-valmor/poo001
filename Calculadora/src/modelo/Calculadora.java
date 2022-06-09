package modelo;

public class Calculadora {
    public enum OPERACAO {
        ADICAO, SUBTRACAO, DIVISAO, MULTIPLICACAO
    }

    private double operador1;
    private double operador2;
    private OPERACAO operacao;

    public Calculadora() {
        operador2 = 0.0;
        operador1 = 0.0;
        operacao  = OPERACAO.ADICAO;
    }

    public void setOperacao(OPERACAO operacao) {
        this.operacao = operacao;
    }

    public void setOperador1(double operador1) {
        this.operador1 = operador1;
    }

    public void setOperador2(double operador2) {
        this.operador2 = operador2;
    }

    public double calcular() {
        double resposta = 0.0;
        switch(operacao) {
            case ADICAO:
                resposta = operador1+operador2;
                break;
            case SUBTRACAO:
                resposta = operador1-operador2;
                break;
            case MULTIPLICACAO:
                resposta = operador1*operador2;
                break;
            case DIVISAO:
                resposta = operador1/operador2;
                break;
        }
        return resposta;
    }
}
