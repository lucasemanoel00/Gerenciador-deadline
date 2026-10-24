import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefa {
    
    private final List <Tarefa> listaTarefas = new ArrayList<>();

    public void mostrarListaCompleta() {

        if(listaTarefas.isEmpty()) {

            System.out.println("Lista de tarefas está vazia");

        }

        for (Tarefa listagem : listaTarefas) {

             System.out.println(listagem);

        }

    }
    public String mostrarTarefaId(int idTarefa) {

        if (listaTarefas.isEmpty()) {

                return "Lista de tarefas vazia";

            }

        for (Tarefa listagem:listaTarefas) {
            
            if (listagem.getIdTarefa() == idTarefa) {

                return "%s".formatted(listagem.toString());

            }

        }

         return "Tarefa com identificador %d não encontrada".formatted(idTarefa);

    }
    public void adicionarTarefa(Tarefa tarefa) {

        listaTarefas.add(tarefa);

    }
    public String removerTarefaId(int idTarefa) {

        if (listaTarefas.isEmpty()) {

                return "Lista de tarefas vazia";

            }

        for (Tarefa listagem:listaTarefas) {

            if (listagem.getIdTarefa() == idTarefa) {

                removerTarefaId(idTarefa);
                return "Tarefa de id %d removida com sucesso!".formatted(idTarefa);

            }
        }

        return "Tarefa de id %d não encontrada".formatted(idTarefa);

    }



}
