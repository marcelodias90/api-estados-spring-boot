package apiendereco.spring.apiendereco.uf.domain.model;

public class uf  {
    private Long id;
    private String nome;
    private String sigla;
    private Boolean status;

    @Override
    public String toString() {
        return "uf{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", status=" + status +
                '}';
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }


    public uf(Long id, String nome, String sigla, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.status = status;
    }

    public uf(String nome, String sigla, Boolean status) {
        this.nome = nome;
        this.sigla = sigla;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
