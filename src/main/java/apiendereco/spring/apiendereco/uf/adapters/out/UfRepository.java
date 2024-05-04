package apiendereco.spring.apiendereco.uf.adapters.out;

import apiendereco.spring.apiendereco.uf.domain.model.Uf;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UfRepository implements apiendereco.spring.apiendereco.uf.domain.ports.UfRepository  {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Uf> rowMapper;



    public UfRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
       this.rowMapper = ((rs, rowNum) ->  new Uf(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("sigla"),
                rs.getBoolean("status")
        ));
    }

    @Override
    public List<Uf> carregarUfs() {
        return (List<Uf>) jdbcTemplate.query("SELECT * FROM TB_UF", rowMapper);
    }

    @Override
    public Optional<Uf> carregarUf(Long id) {
        String sql = "SELECT * FROM TB_UF WHERE ID = ?";
        List<Uf> uf = jdbcTemplate.query(sql, rowMapper, id);
        return uf.stream().findFirst();
    }

    @Override
    public void adicionarUf(Uf uf) {
        String sql = "INSERT INTO TB_UF(nome, sigla, status) VALUES(?,?,?)";
        jdbcTemplate.update(sql, uf.getNome(), uf.getSigla(), uf.getStatus());
    }
}
