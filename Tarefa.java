
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Tarefa {
    
    private String nomeTarefa;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private LocalDate dataTermino;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String descricao;
    @SuppressWarnings("unused")
    private String prioridadeTarefa;
    private Responsavel responsavel;
    private static int contadorId = 1;
    private final int idTarefa = contadorId++;
    private boolean concluida;

    public Tarefa(String nomeTarefa,LocalDate dataInicio,LocalDate dataFinal,String descricao,Responsavel responsavel) {


        this.nomeTarefa = nomeTarefa;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.concluida = false;

    }

    public void setNomeTarefa(String nomeTarefa) {

        this.nomeTarefa = nomeTarefa;

    }
    public void setDataInicio(LocalDate dataInicio) {

        this.dataInicio = dataInicio;

    }
    public void setDataFinal(LocalDate dataFinal) {

        this.dataFinal = dataFinal;

    }
    public void setDataTermino(LocalDate dataTermino) {

        this.dataTermino = dataTermino;

    }
    public void setDescricao(String descricao) {

        this.descricao = descricao;

    }
    public void setPrioridadeTarefa(String prioridadeTarefa) {

        this.prioridadeTarefa = prioridadeTarefa;

    }
    public void setResponsavel(Responsavel responsavel) {

        this.responsavel = responsavel;

    }
    public void tarefaConcluida() {

        this.dataTermino = LocalDate.now();
        this.concluida = true;

    }
    public void tarefaCancelada() {

        this.concluida = false;

    }
    public String getNomeTarefa() {

        return this.nomeTarefa;

    }
    public LocalDate getDataInicio() {

        return this.dataInicio;

    }
    public LocalDate getDataTermino() {

        return this.dataTermino;

    }
    public LocalDate getDataFinal() {

        return this.dataFinal;

    }
    public String mostrarDataInicial() {

        return this.dataInicio.format(FORMATO);

    }
    public String mostrarDataFinal() {

        return this.dataFinal.format(FORMATO);

    }
    public String mostrarDataTermino() {

        if (this.dataTermino == null) {
        
            return "Data de termino não definida";
        
        }

        return this.dataTermino.format(FORMATO);

    }
    public String getDescricao() {

        return this.descricao;

    }
    public Responsavel getResponsavel() {

        return this.responsavel;

    }
    public int getIdTarefa() {

        return this.idTarefa;

    }
    public boolean isConcluida() {

        return this.concluida;

    }
    public long calcularDiasRestantes() {

        return ChronoUnit.DAYS.between(LocalDate.now(), getDataFinal());

    }
    public long calcularTempoTotal() {

        return ChronoUnit.DAYS.between(getDataInicio(),getDataFinal());

    }
    public String getPrioridadeTarefa() {

        if (calcularDiasRestantes()<0) {

            return "Alta prioridade, mas com atraso de %d".formatted(calcularDiasRestantes());

        }
        else if (calcularDiasRestantes()<=7) {

            return "Alta prioridade com prazo até %s".formatted(mostrarDataFinal());

        }
        else if (calcularDiasRestantes()>7 && calcularDiasRestantes()<15) {

            return "Média prioridade com prazo até %s".formatted(mostrarDataFinal());

        }
        else if (calcularDiasRestantes()>=15) {

            return "Baixa prioridade com prazo até %s".formatted(mostrarDataFinal());

        }

        return "Erro, prioridade não definida";

    }
    @Override 
    public String toString() {

        if (isConcluida()){
            
            return "Nome da tarefa: %s \nIdentificador: %d \n%s \nDate de inicio: %s \nData de término: %s \nDescrição: %s \n%s \n".formatted(getNomeTarefa(),getIdTarefa(),getResponsavel(),mostrarDataTermino(),mostrarDataFinal(),getDescricao(),getResponsavel());
        
        }

        return "Nome da tarefa: %s \nIdentificador: %d \nData de início: %s \nPrazo final: %s \nDias restantes: %s \nPrioridade: %s \n%s \n".formatted(getNomeTarefa(),getIdTarefa(),mostrarDataInicial(),mostrarDataFinal(),calcularDiasRestantes(),getPrioridadeTarefa(),getResponsavel());

    }

}