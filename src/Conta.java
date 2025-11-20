import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private Agencia agencia;
    private double saldo;
    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double saldo) {
        this.cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this.agencia = new Agencia(numAgencia, numConta, gerente);
        this.saldo = saldo;
        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    public void realizarOperacao(char tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);
        atualizarSaldo(op);
    }

    private void atualizarSaldo(Operacao operacao) {
        TipoOperacao tipo = operacao.getTipo();
        double valor = operacao.getValor();
        
        if (tipo == TipoOperacao.DEPOSITO) {
            this.saldo += valor;
        } else if (tipo == TipoOperacao.SAQUE) {
            this.saldo -= valor;
        }
    }

    private String gerarExtrato() {
        StringBuilder extrato = new StringBuilder();
        for (Operacao op : this.operacoes) {
            extrato.append(op.toString()).append("\n");
        }
        return extrato.toString();
    }

    @Override
    public String toString() {
        String dadosCliente = this.cliente.toString();
        String dadosAgencia = this.agencia.toString();
        String dadosExtrato = gerarExtrato();

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosAgencia + "\n" +
                String.format("Saldo: %.2f", this.saldo) +
                "\n\n" +
                "-----EXTRATO-----\n" +
                dadosExtrato +
                "\n";
    }
}
