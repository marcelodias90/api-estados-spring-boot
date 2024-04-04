package apiendereco.spring.apiendereco.uf.adapters.out;

import apiendereco.spring.apiendereco.uf.domain.model.uf;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UfRepository implements apiendereco.spring.apiendereco.uf.domain.ports.UfRepository  {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<uf> rowMapper;



    public UfRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
       this.rowMapper = ((rs, rowNum) ->  new uf(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("sigla"),
                rs.getBoolean("status")
        ));
    }

    @Override
    public List<uf> carregarUfs() {
        return (List<uf>) jdbcTemplate.query("SELECT * FROM TB_UF", rowMapper);
    }

    @Override
    public Optional<uf> carregarUf(Long id) {
        String sql = "SELECT * FROM TB_UF WHERE ID = ?";
        List<uf> uf = jdbcTemplate.query(sql, rowMapper, id);
        return uf.stream().findFirst();
    }

    @Override
    public int adicionarUf(uf uf) {
        String sql = "INSERT INTO TB_UF(nome, sigla, status) VALUES(?,?,?)";
        return  jdbcTemplate.update(sql, uf.getNome(), uf.getSigla(), uf.getStatus());
    }
}
