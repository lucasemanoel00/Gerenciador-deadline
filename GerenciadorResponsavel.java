
import java.util.ArrayList;
import java.util.List;

public class GerenciadorResponsavel {

    private final List <Responsavel> listaResponsavel = new ArrayList<>();

    public void mostrarListaCompleta() {

        if (listaResponsavel.isEmpty()) {

            System.out.println("Lista vazia");

        }

        for (Responsavel listagemResponsavel :listaResponsavel) {

            System.out.println(listagemResponsavel);

        }

    }
    public Responsavel mostrarResponsavelId(int idResponsavel) {

        for (Responsavel listagemResponsavel : listaResponsavel) {
            
            if (listagemResponsavel.getIdResponsavel() == idResponsavel) {

                return listagemResponsavel;

            }
        }

        return null;

    }
    public String adicionarResponsavel(Responsavel responsavel) {

        listaResponsavel.add(responsavel);
        return "Responsável %s adicionado".formatted(responsavel.getNomeResponsavel());

    }
    public String removerResponsavelId(int idResponsavel) {

        if (listaResponsavel.isEmpty()) {

                return "Lista de responsáveis está vazia";

        }

        for (Responsavel listagem :listaResponsavel) {

            if (listagem.getIdResponsavel() == idResponsavel) {

                listaResponsavel.remove(listagem);
                return "Responsável excluido com sucesso";

            }

        }
       
        return "Responsável com o identificador %s não encontrado".formatted(idResponsavel);

    }

}