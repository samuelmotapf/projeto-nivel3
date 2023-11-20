package classes;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado, String email, String cnpj) {
   
        this.cnpj = cnpj;
    }

    // Getters e Setters para o campo cnpj
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Sobrescrever o método exibir() para mostrar informações específicas de PessoaJuridica
    
    public void exibir() {
        System.out.println("Informações da Pessoa Jurídica:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Logradouro: " + getLogradouro());
        System.out.println("Cidade: " + getCidade());
        System.out.println("Estado: " + getEstado());
        System.out.println("Email: " + getEmail());
        System.out.println("CNPJ: " + getCnpj());
    }
}
