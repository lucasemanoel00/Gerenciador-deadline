import static java.lang.Thread.sleep;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        GerenciadorResponsavel gerenciadorResponsavel = new GerenciadorResponsavel();
        GerenciadorTarefa gerenciadorTarefa = new GerenciadorTarefa();

        int escolha;
        do { 
            
            System.out.println("Digite 0 para sair\nDigite [1] para cadastrar um responsável \nDigite [2] para criar um tarefa \nDigite [3] para ver toda a lista de tarefas \nDigite [4] para ver uma tarefa atráves do id \nDigite [5] para ver todos os responsáveis \nDigite [6] para ver um responsável pelo identificador \nDigite [7] para remover um responsável \nDigite [8] para remover uma tarefa");
            escolha = sc.nextInt();
            sc.nextLine();

            switch(escolha) {

                case 1 ->  {

                    System.out.println("Digite aqui o nome do responsável: ");
                    String nomeResponsavel = sc.nextLine();
                    System.out.println("Digite aqui o cargo do responsável");
                    String cargo = sc.nextLine();
                    System.out.println("Digite aqui o CPF do responsável");
                    String cpf = sc.nextLine();

                    gerenciadorResponsavel.adicionarResponsavel(new Responsavel(nomeResponsavel, cargo, cpf));

                }
                case 2 ->  {

                    System.out.println("Digite aqui o nome da tarefa:");
                    String nomeTarefa = sc.nextLine();

                    System.out.println("Digite aqui o dia que deve iniciar essa tarefa");
                    int dia = sc.nextInt();
                    System.out.println("Digite aqui o mês que deve iniciar essa tarefa");
                    int mes = sc.nextInt();
                    System.out.println("Digite aqui o ano que deve iniciar a tarefa");
                    int ano = sc.nextInt();

                    LocalDate datainicio = LocalDate.of(ano,mes,dia);

                    System.out.println("Digite aqui o dia que deve finalizar essa tarefa");
                    int diaFinal = sc.nextInt();
                    System.out.println("Digite aqui o mês que deve finalizar essa tarefa");
                    int mesFinal = sc.nextInt();
                    System.out.println("Digite aqui o ano que deve finalizar a tarefa");
                    int anoFinal = sc.nextInt();
                    sc.nextLine();

                    LocalDate dataFinal = LocalDate.of(anoFinal,mesFinal,diaFinal);

                    System.out.println("Digite aqui a descrição da atividade: ");
                    String descricao = sc.nextLine();

                    System.out.println("Digite aqui o id do responsável:");
                    int idResponsavel = sc.nextInt();

                    while (gerenciadorResponsavel.mostrarResponsavelId(idResponsavel) == null && idResponsavel != 0) {

                        System.out.println("Id incorreto ou não pertence a um responsável, digite o id do responsáel novamente aqui:");
                        System.out.println("Caso queira cancelar digite [0]:");
                        idResponsavel = sc.nextInt();
                        
                    }
                    if (idResponsavel == 0) {

                        System.out.println("Cadastro cancelado por sua ordem! ");

                    }
                    else {

                    gerenciadorTarefa.adicionarTarefa(new Tarefa(nomeTarefa, datainicio, dataFinal, descricao, gerenciadorResponsavel.mostrarResponsavelId(idResponsavel)));
                        }

                }
                case 3 ->  {

                    gerenciadorTarefa.mostrarListaCompleta();

                }
                case 4 ->  {

                    System.out.println("Digite aqui o numero identificador da tarefa pra exibi-la: ");
                    int idTarefa = sc.nextInt();

                    while (gerenciadorTarefa.mostrarTarefaId(idTarefa) == null && idTarefa != 0) {

                        System.out.println("Id incorreto ou não pertence a uma tarefa, digite o id do responsáel novamente aqui:");
                        System.out.println("Caso queira cancelar digite [0]:");
                        idTarefa = sc.nextInt();
                        
                    }
                    if (idTarefa == 0) {

                        System.out.println("Cadastro cancelado com sucesso!");

                    }
                    else {
                    
                        System.out.println(gerenciadorTarefa.mostrarTarefaId(idTarefa));

                    }

                }
                case 5 ->  {

                    gerenciadorResponsavel.mostrarListaCompleta();

                }
                case 6 ->  {

                    System.out.println("Digite o identificador do responsável para localizarmos");
                    int idResponsavel = sc.nextInt();

                    while (gerenciadorResponsavel.mostrarResponsavelId(idResponsavel) == null && idResponsavel != 0) {

                        System.out.println("Id incorreto ou não pertence a um responsável, digite o id do responsáel novamente aqui:");
                        System.out.println("Caso queira cancelar digite [0]:");
                        idResponsavel = sc.nextInt();
                        
                    }

                    if (idResponsavel == 0) {

                        System.out.println("Cadastro cancelado por sua ordem! ");

                    }

                    else if (gerenciadorResponsavel.mostrarResponsavelId(idResponsavel) == null) {

                        System.out.println("Responsável não encontrado ou inválido!");

                    }
                    


                    else {
                    
                        System.out.println(gerenciadorResponsavel.mostrarResponsavelId(idResponsavel));
                    
                    }

                }
                case 7 ->  {

                    System.out.println("Digite o identificador do responsável para REMOVER: ");
                    int idResponsavel = sc.nextInt();

                    System.out.println(gerenciadorResponsavel.removerResponsavelId(idResponsavel));

                }
                case 8 -> {

                    System.out.println("Digite o identificador da tarefa para REMOVER: ");
                    int idTarefa = sc.nextInt();
                    gerenciadorTarefa.removerTarefaId(idTarefa);

                }

                default -> {

                        System.out.println("Escolha inválida");

                }

                

            }   
            
            if (escolha !=0) { 
            try {
               sleep(2000);
            } 
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }}

        } while (escolha !=0);

        sc.close();

    }

}