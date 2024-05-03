package apiendereco.spring.apiendereco.uf.adapters.in.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ufDto {

    @NotBlank(message = "campo inválido.")
    @Size(max = 50)
    private String nome;

    @NotBlank(message = "campo inválido.")
    @Size(min = 2, max = 2, message = "deve contar duas letras")
    private String sigla;

    private Boolean status;

    private Long id;

    public String getNome() {
        return nome;
    }


    public String getSigla() {
        return sigla;
    }

    public Boolean getStatus() {
        return status;
    }


}
