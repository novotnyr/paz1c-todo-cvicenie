package sk.upjs.ics.todo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlUlohaDao implements UlohaDao {
    private JdbcTemplate jdbcTemplate;
    
    public MySqlUlohaDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/todo");
        dataSource.setUser("todo");
        dataSource.setPassword("todo");
        
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    

    @Override
    public void pridat(Uloha uloha) {
        String sql = "INSERT INTO uloha VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, null, uloha.getNazov(), uloha.getDate());
    }

    @Override
    public List<Uloha> dajVsetky() {
        String sql = "SELECT * FROM uloha";
        
        BeanPropertyRowMapper<Uloha> mapper = BeanPropertyRowMapper.newInstance(Uloha.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public void odstranit(Uloha uloha) {
        String sql = "DELETE FROM uloha WHERE id = ?";
        jdbcTemplate.update(sql, uloha.getId());
    }
    
}
