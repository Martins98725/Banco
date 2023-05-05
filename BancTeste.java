package DesafioBanco.NovoBanco;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
public class BancTeste {
    static Scanner entrada = new Scanner(System.in);
    static Cont c1;
    static ArrayList<Cont> usuarios;

    public static void main(String[] args) {
        usuarios = new ArrayList<>();
        boolean rodando = true;
        while (rodando) {
            c1 = new Cont();
            Pattern patternSenha = Pattern.compile("[a-zA-Z0-9]{4,6}");
            Pattern patternNome = Pattern.compile("[a-zA-Z]{3,10}");
            Pattern pattern = Pattern.compile("\\d");
            System.out.println("[1] Abrir conta ");
            System.out.println("[2] Entrar na conta ");
            System.out.println("[3] Sair");
            String senha, dono;
            String opcao = entrada.nextLine();
            switch (opcao) {
                case "1": {
                    System.out.println("----------Aba do usuario-------------");
                    System.out.print("Digite seu nome: ");
                    dono = entrada.nextLine();
                    while (!patternNome.matcher(dono).matches()) {
                        System.out.println("Nome inválido. Tente novamente");
                        dono = entrada.nextLine();
                    }
                    System.out.print("Sua senha: ");
                    senha = entrada.nextLine();
                    while (!patternSenha.matcher(senha).matches()) {
                        System.out.println("Senha inválida. Tente novamente: ");
                        senha = entrada.nextLine();
                    }
                    System.out.print("Qual o tipo? (cc/cp)");
                    String tipeConta = entrada.nextLine();
                    c1.setDono(dono);
                    c1.setSenha(senha);
                    if (tipeConta.equalsIgnoreCase("cc")) {
                        c1.setTipo(tipeConta);
                        c1.abrirConta(tipeConta);
                        usuarios.add(c1);
                        System.out.printf("%n Conta cadastrada com sucesso %n");
                        c1.statusAtual();
                    } else if (tipeConta.equalsIgnoreCase("CP")) {
                        System.out.println("Tipo valido");
                        c1.setTipo(tipeConta);
                        c1.abrirConta(tipeConta);
                        usuarios.add(c1);
                        System.out.printf("%n Conta cadastrada com sucesso %n");
                        c1.statusAtual();
                    } else {
                        System.out.println("Impossivel abrir a conta ");
                        System.out.println("Tipo invalido");
                    }
                    break;
                }
                case "2": {
                    if (usuarios.size() == 0) {
                        System.out.println("Sem contas cadastradas ");
                    } else {
                        int a = usuarios.size();
                        for (int i = 0; i < a; i++) {
                            Cont temp = usuarios.get(i);
                            System.out.println("[" + i + "]");
                            System.out.println("Conta: " + temp.getDono());
                        }
                        String referencia = entrada.nextLine();
                        int ref = Integer.parseInt(referencia);
                        c1 = usuarios.get(ref);
                        System.out.println("Senha da conta: ");
                        senha = entrada.nextLine();
                        while (!senha.equals(c1.getSenha())) {
                            System.out.println("Senha inválida. Tente novamente");
                            senha = entrada.nextLine();
                        }
                        c1.statusAtual();
                        boolean rod = true;
                        while (rod) {
                            System.out.println("[1] Depositar");
                            System.out.println("[2] Sacar");
                            System.out.println("[3] Contas cadastradas");
                            System.out.println("[4] Fechar conta");
                            System.out.println("[5] Atualizar conta");
                            System.out.println("[6] Transferir");
                            System.out.println("[7] sair");
                            System.out.println("Digite a operação que você que fazer: ");
                            String op = entrada.nextLine();
                            switch (op) {
                                case "1": {
                                    a = usuarios.size();
                                    for (int i = 0; i < a; i++) {
                                        Cont utemp = usuarios.get(i);
                                        System.out.println("[" + i + "]" + utemp.getDono());
                                    }
                                    if (usuarios.size() == 0) {
                                        System.out.println("Não há contas cadastradas. Favor criar uma conta");
                                    } else {
                                        System.out.println("Qual conta você quer depositar? ");
                                        referencia = entrada.nextLine();
                                        while (!pattern.matcher(referencia).matches()) {
                                            System.out.println("Referência inválida. Tente novamente");
                                            referencia = entrada.nextLine();
                                        }
                                        ref = Integer.parseInt(referencia);
                                        if (ref >= a) {
                                            System.out.println("Índice da conta não foi encontrado. Crie uma ou tente novamente");
                                        } else {
                                            System.out.print("A senha da conta selecionada: ");
                                            senha = entrada.nextLine();
                                            while (!senha.equals(c1.getSenha())) {
                                                System.out.println("Senha inválida. Tente novamente");
                                                senha = entrada.nextLine();
                                            }
                                            c1 = usuarios.get(ref);
                                            System.out.println("Infome o valor depositado (Valores acima ou iguais a 20 reais): ");
                                            double deposito = entrada.nextDouble();
                                            while (deposito < 20.0) {
                                                System.out.println("Deposito invalido. Tente novamente");
                                                deposito = entrada.nextDouble();
                                            }
                                            c1.depositar(deposito);
                                            c1.statusAtual();
                                        }
                                    }
                                    break;
                                }
                                case "2": {
                                    a = usuarios.size();
                                    for (int i = 0; i < a; i++) {
                                        Cont utemp = usuarios.get(i);
                                        System.out.println("[" + i + "]" + utemp.getDono());
                                    }
                                    if (usuarios.size() == 0) {
                                        System.out.println("Não há contas cadastradas. Favor criar uma conta");
                                    } else {
                                        System.out.println("Qual conta você quer sacar? ");
                                        referencia = entrada.nextLine();
                                        while (!pattern.matcher(referencia).matches()) {
                                            System.out.println("Referência inválida. Tente novamente");
                                            referencia = entrada.nextLine();
                                        }
                                        ref = Integer.parseInt(referencia);
                                        if (ref >= a) {
                                            System.out.println("Não há contas cadastradas com esse índice");
                                        } else {
                                            System.out.print("A senha da conta selecionada: ");
                                            senha = entrada.nextLine();
                                            while (!senha.equals(c1.getSenha())) {
                                                System.out.println("Senha inválida. Tente novamente");
                                                senha = entrada.nextLine();
                                            }
                                            System.out.println("Informe o valor de saque (Valores acima ou iguais a 20 reais): R$ ");
                                            double saque = entrada.nextDouble();
                                            while (saque < 20) {
                                                System.out.println("Deposito invalido. Tente novamente");
                                                saque = entrada.nextDouble();
                                            }
                                            c1 = usuarios.get(ref);
                                            c1.sacar(saque);
                                            if (saque > c1.getSaldo()) {
                                                System.out.print(" ");
                                            } else {
                                                System.out.print(" ");
                                            }
                                            c1.statusAtual();
                                        }
                                    }
                                    break;
                                }
                                case "3": {
                                    for (int i = 0; i < usuarios.size(); i++) {
                                        System.out.println("======Contas cadastradas==========");
                                        Cont temp = usuarios.get(i);
                                        System.out.println("Conta: " + i);
                                        System.out.println("\tDono: " + temp.getDono());
                                        System.out.println("\tTipo: " + temp.getTipo());
                                    }
                                    if (usuarios.size() == 0) {
                                        System.out.println("Sem contas para ver. Crie uma conta");
                                    }
                                    break;
                                }
                                case "4": {
                                    a = usuarios.size();
                                    for (int i = 0; i < a; i++) {
                                        Cont utemp = usuarios.get(i);
                                        System.out.println("[" + i + "]" + utemp.getDono());
                                    }
                                    if (usuarios.size() == 0) {
                                        System.out.println("Sem contas para fechar.");
                                    } else {
                                        System.out.println("Qual conta você quer fechar? ");
                                        referencia = entrada.nextLine();
                                        while (!pattern.matcher(referencia).matches()) {
                                            System.out.println("Referência inválida. Tente novamente");
                                            referencia = entrada.nextLine();
                                        }
                                        ref = Integer.parseInt(referencia);
                                        if (ref >= a) {
                                            System.out.println("Não há contas cadastradas com esse índice");
                                        } else {
                                            System.out.print("A senha da conta selecionada: ");
                                            senha = entrada.nextLine();
                                            while (!senha.equals(c1.getSenha())) {
                                                System.out.println("Senha inválida. Tente novamente");
                                                senha = entrada.nextLine();
                                            }
                                            c1 = usuarios.get(ref);
                                            if (c1.getSaldo() > 0) {
                                                c1.fecharConta();
                                            } else {
                                                c1.fecharConta();
                                                usuarios.remove(c1);
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "5": {
                                    a = usuarios.size();
                                    for (int i = 0; i < a; i++) {
                                        System.out.println("=============Atualizar conta==============");
                                        Cont utemp = usuarios.get(i);
                                        System.out.println("[" + i + "]" + utemp.getDono());
                                    }
                                    if (usuarios.size() == 0) {
                                        System.out.println("Sem contas para atualizar. Crie uma conta para atualiza-lá");
                                    } else {
                                        System.out.println("Digite o valor de referência: ");
                                        referencia = entrada.nextLine();
                                        while (!pattern.matcher(referencia).matches()) {
                                            System.out.println("Referência inválida. Tente novamente");
                                            referencia = entrada.nextLine();
                                        }
                                        ref = Integer.parseInt(referencia);
                                        if (ref >= a) {
                                            System.out.println("Não há contas cadastradas com esse índice");
                                        } else {
                                            System.out.print("A senha da conta selecionada: ");
                                            senha = entrada.nextLine();
                                            while (!senha.equals(c1.getSenha())) {
                                                System.out.println("Senha inválida. Tente novamente");
                                                senha = entrada.nextLine();
                                            }
                                            System.out.println("Digite o novo nome: ");
                                            String novoNome = entrada.nextLine();
                                            System.out.println("Sua nova senha: ");
                                            String novaSenha = entrada.nextLine();
                                            c1 = usuarios.get(ref);
                                            c1.setDono(novoNome);
                                            c1.setSenha(novaSenha);
                                        }
                                    }
                                    break;
                                }
                                case "6": {
                                    a = usuarios.size();
                                    if (a < 2) {
                                        System.out.println("Precisa de duas contas para realizar esta ação");
                                    } else {
                                        for (int i = 0; i < a; i++) {
                                            Cont temp = usuarios.get(i);
                                            System.out.println("[" + i + "]");
                                            System.out.println("Conta: " + temp.getDono());
                                            System.out.println("Saldo: " + temp.getSaldo());
                                            System.out.println("Tipo: " + temp.getTipo());
                                        }
                                        System.out.println("Escolha a conta remetente");
                                        String contaRemetente = entrada.nextLine();
                                        while (!pattern.matcher(contaRemetente).matches()) {
                                            System.out.println("Referência inválida. Tente novamente");
                                            contaRemetente = entrada.nextLine();
                                        }
                                        int contReme = Integer.parseInt(contaRemetente);
                                        if (contReme >= a) {
                                            System.out.println("Sem contas");
                                        } else {
                                            System.out.println("Digite a senha da conta");
                                            senha = entrada.nextLine();
                                            while (!senha.equals(c1.getSenha())) {
                                                System.out.println("Senha inválida. Tente novamente");
                                                senha = entrada.nextLine();
                                            }
                                            c1 = usuarios.get(contReme);
                                            System.out.println("Conta destinatário: ");
                                            String contaDestinatario = entrada.nextLine();
                                            while (!pattern.matcher(contaDestinatario).matches()) {
                                                System.out.println("Referência inválida. Tente novamente");
                                                contaDestinatario = entrada.nextLine();
                                            }
                                            int contDest = Integer.parseInt(contaDestinatario);
                                            System.out.println("Digite o valor de transferência: ");
                                            double tranferencia = entrada.nextDouble();
                                            if (tranferencia > c1.getSaldo()) {
                                                System.out.println("Saldo insufiente");
                                            } else {
                                                c1.setSaldo(c1.getSaldo() - tranferencia);
                                                if (contDest >= a) {
                                                    System.out.println("Sem contas");
                                                } else {
                                                    c1 = usuarios.get(contDest);
                                                    c1.setSaldo(c1.getSaldo() + tranferencia);
                                                    c1.statusAtual();
                                                }
                                            }
                                        }
                                    }
                                }
                                case "7": {
                                    System.out.println("Voltando para o menu principal");
                                    rod = false;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
                case "3":{
                    System.out.println("Adeus, meu caro pigmeu");
                    rodando = false;
                }
            }
        }
        entrada.close();
    }
}
/*
  System.out.println("Senha da conta destinátaria");
          senha = entrada.nextLine();
          while (!senha.equals(c1.getSenha())){
          System.out.println("Senha inválida. Tente novamente");
          senha = entrada.nextLine();
          }*/
