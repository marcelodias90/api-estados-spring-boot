package apiendereco.spring.apiendereco.uf.domain.model;


public class EstadoModelApi  {

    private Integer id;
    private String sigla;
    private String nome;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }


    public EstadoModelApi(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }


    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
