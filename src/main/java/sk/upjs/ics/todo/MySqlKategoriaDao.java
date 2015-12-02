package sk.upjs.ics.todo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlKategoriaDao implements KategoriaDao {
    private JdbcTemplate jdbcTemplate;
    
    public MySqlKategoriaDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/todo");
        dataSource.setUser("todo");
        dataSource.setPassword("todo");
        
        jdbcTemplate = new JdbcTemplate(dataSource);        
    }
    
    
    @Override
    public List<Kategoria> dajVsetky() {
        String sql = "SELECT *\n" +
                "FROM kategoria\n" +
                "LEFT OUTER JOIN uloha ON uloha.kategoria_id = kategoria.id";
        
        
        KategoriaRowCallbackHandler handler = new KategoriaRowCallbackHandler();
        jdbcTemplate.query(sql, handler);
        
        return handler.getKategorie();
    }
    
    public static void main(String[] args) {
        List<Kategoria> dajVsetky = new MySqlKategoriaDao().dajVsetky();
        System.out.println(dajVsetky);
        for(Kategoria k : dajVsetky) {
            System.out.println(k.getUlohy().size());
        }
    }
}
