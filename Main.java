import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        GerenciadorResponsavel gerenciadorResponsavel = new GerenciadorResponsavel();
        GerenciadorTarefa gerenciadorTarefa = new GerenciadorTarefa();

        int escolha;
        do { 
            
            System.out.println("Digite [1] para cadastrar um responsável \nDigite [2] para criar um tarefa \nDigite [3] para ver toda a lista de tarefas \nDigite [4] para ver uma tarefa atráves do id \nDigite [5] para ver todos os responsáveis \nDigite [6] para ver um responsável pelo identificador ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch(escolha) {

                case 1: {

                    System.out.println("Digite aqui o nome do responsável: ");
                    String nomeResponsavel = sc.nextLine();
                    System.out.println("Digite aqui o cargo do responsável");
                    String cargo = sc.nextLine();
                    System.out.println("Digite aqui o CPF do responsável");
                    String cpf = sc.nextLine();

                    gerenciadorResponsavel.adicionarResponsavel(new Responsavel(nomeResponsavel, cargo, cpf));
                    break;

                }
                case 2: {

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

                    gerenciadorTarefa.adicionarTarefa(new Tarefa(nomeTarefa, datainicio, dataFinal, descricao, gerenciadorResponsavel.mostrarResponsavelId(idResponsavel)));
                    break;

                }
                case 3: {

                    gerenciadorTarefa.mostrarListaCompleta();
                    break;

                }
                case 4: {

                    System.out.println("Digite aqui o numero identificador da tarefa pra exibi-la: ");
                    int idTarefa = sc.nextInt();
                    System.out.println(gerenciadorTarefa.mostrarTarefaId(idTarefa));
                    break;

                }
                case 5: {

                    gerenciadorResponsavel.mostrarListaCompleta();
                    break;

                }

            } 



        } while (escolha !=0);

    }

}