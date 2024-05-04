package apiendereco.spring.apiendereco.uf.adapters.in.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdicionarUfDto {

    @NotBlank(message = "campo obrigatório")
    @Size(max = 50, message = "máximo 50 caracteres")
    private String nome;

    @NotBlank(message = "campo obrigatório")
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
