public class Responsavel {
    
    private String nomeResponsavel;
    private String cargo;
    private String cpf;
    private static int contadorIdRespo = 1;
    private final int idResponsavel = contadorIdRespo++;

    public Responsavel(String nomeResponsavel,String cargo,String cpf) {

        this.nomeResponsavel = nomeResponsavel;
        this.cargo = cargo;
        this.cpf = cpf;
        
    }
    public String getNomeResponsavel() {

        return this.nomeResponsavel;

    }
    public String getCargo() {

        return this.cargo;

    } 
    public String getCpf() {

        return this.cpf;

    }
    public int getIdResponsavel() {

        return this.idResponsavel;
    
    }
    public void setNomeResponsavel(String nomeResponsavel) {

        this.nomeResponsavel = nomeResponsavel;

    }
    public void setCargo(String cargo) {

        this.cargo = cargo;

    }
    public void setCpf(String cpf) {
        
        this.cpf = cpf;
        
    }
    @Override 
    public String toString() {

        return "Nome do responsavel: %s \nCargo: %s \nNum Identificador: %d \nCPF: %s \n".formatted(getNomeResponsavel(),getCargo(),getIdResponsavel(),getCpf());

    }
    
    


}   
