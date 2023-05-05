package DesafioBanco.NovoBanco;
public class Cont {
    private static int numconta = 1;
    private String tipo;
    private String dono;
    private String senha;
    protected double saldo;
    private boolean status;
    public void statusAtual(){
        String stats = "Conta Ativa ";
        String stts = "Conta inativa ";
        System.out.println("-------------Informações---------------");
        System.out.printf("Dono: %s%n", this.getDono());
        System.out.printf("Tipo da conta : %s%n", this.getTipo());
        System.out.printf("Saldo: %.2f%n", this.getSaldo());
        if (isStatus() == true){
            System.out.printf("Status: %s%n", stats);
        }
        else {
            System.out.printf("Status: %s%n", stts);
        }
    }
    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);
        if (t.equalsIgnoreCase("CC")){
            this.setSaldo(50);
        }
        else if (t.equalsIgnoreCase("CP")) {
            this.setSaldo(150);
        }
    }
    public void fecharConta(){
        if (this.saldo > 0){
            System.out.println("Tem dinheiro, não posso fechar a conta ");
        } else if (this.saldo < 0) {
            System.out.println("Conta em débito. Impossivel fechar a conta ");

        }
        else {
            setStatus(false);
            System.out.println("Conta fechada de " + getDono());
        }
    }
    public void depositar(double valor){
        if (this.status == true){
            System.out.println("Deposito realizado com sucesso de R$ " + valor + " na conta de " + this.getDono());
            setSaldo(getSaldo() + valor);
        } else if (valor < 0 ) {
            System.out.println("Deposito imposisvel");
        } else {
            System.out.println("Impossivel depositar");
        }
    }
    public void sacar(double valor){
        if (this.status == true){
            if (getSaldo() >= valor){
                setSaldo(getSaldo() - valor);
                System.out.println("Um saque foi realizado de R$ " + valor + " Na conta de " + this.getDono());
            }
            else {
                System.out.println("Saldo insuficiente para saque " + "\nesse é o saldo disponivel "  + this.getSaldo());
            }
        }
        else {
            System.out.println("Impossivel sacar ");
        }
    }
    public void pagamentoMensal(){
        var v = 0;
        if (tipo.equalsIgnoreCase("CC")){
            v = 12;
        } else if (tipo.equalsIgnoreCase("CP")) {
            v = 20;
        }
        if (this.status == true){
            if (saldo > v){
                setSaldo(getSaldo() - v);
            }
            else {
                System.out.println("Saldo insuficiente ");
            }
        }
        else {
            System.out.println("Impossivel pagar ");
        }
    }
    public void construto(){
        saldo = 0;
        status = false;
    }
    public void setNumconta(int numconta) {
        this.numconta = numconta;
    }
    public int getNumconta() {
        return numconta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getSaldo() {

        return saldo;
    }
    public void setSaldo(double saldo) {

        this.saldo = saldo;
    }
    public String getDono() {

        return dono;
    }
    public void setDono(String dono) {

        this.dono = dono;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean isStatus() {
        return status;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}