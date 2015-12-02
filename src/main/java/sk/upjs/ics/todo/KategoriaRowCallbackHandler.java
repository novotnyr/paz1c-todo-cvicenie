package sk.upjs.ics.todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.jdbc.core.RowCallbackHandler;

public class KategoriaRowCallbackHandler implements RowCallbackHandler {
    private Long predosleId;
    
    private List<Kategoria> kategorie = new LinkedList<Kategoria>();
    
    @Override
    public void processRow(ResultSet rs) throws SQLException {
        long kategoriaId = rs.getLong(1);
        if(zmeniloSa(predosleId, kategoriaId)) {
            predosleId = kategoriaId;
            
            Kategoria kategoria = new Kategoria();
            kategoria.setId(kategoriaId);
            kategoria.setNazov(rs.getString(2));
            
            kategorie.add(kategoria);
            
            Long ulohaId = rs.getLong(3);
            if(ulohaId != 0) {
                Uloha uloha = new Uloha();
                uloha.setId(rs.getLong(3));
                uloha.setNazov(rs.getString(4));
                uloha.setDate(rs.getDate(5));
                uloha.setSplnena(rs.getBoolean(6));

                kategoria.getUlohy().add(uloha);
            }
        } else {
            Uloha uloha = new Uloha();
            uloha.setId(rs.getLong(3));
            uloha.setNazov(rs.getString(4));
            uloha.setDate(rs.getDate(5));
            uloha.setSplnena(rs.getBoolean(6));
            
            kategorie.get(kategorie.size() - 1).getUlohy().add(uloha);
        }
    }

    private boolean zmeniloSa(Long predosleId, long kategoriaId) {
        if(predosleId == null) {
            return true;
        } else {
            return predosleId != kategoriaId;
        }
        
    }

    public List<Kategoria> getKategorie() {
        return kategorie;
    }
    
    
    
}
