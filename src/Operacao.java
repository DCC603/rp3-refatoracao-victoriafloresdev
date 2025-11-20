public class Operacao {

    private TipoOperacao tipo;
    private double valor;

    public Operacao(char codigoTipo, double valor) {
        this.tipo = TipoOperacao.fromCodigo(codigoTipo);
        this.valor = valor;
    }

    public Operacao(TipoOperacao tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoOperacao getTipo() {
        return this.tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return this.tipo.getDescricao() + ":\t" + this.valor;
    }
}
