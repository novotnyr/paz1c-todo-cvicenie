package sk.upjs.ics.todo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class KategoriaTableModel extends AbstractTableModel {
    private static final int STLPEC_POCET_ULOH = 1;

    private static final int STLPEC_NAZOV = 0;
    
    private KategoriaDao kategoriaDao = new MySqlKategoriaDao();
    
    private UlohaDao ulohaDao = UlohaDaoFactory.INSTANCE.getUlohaDao();
    
    private static final String[] NAZVY_STLPCOV = { "Názov", "Počet úloh" }; 

    private static final int RIADOK_PRE_VSETKY_ULOHY = 1;

    @Override
    public int getRowCount() {        
        return kategoriaDao.dajVsetky().size() + RIADOK_PRE_VSETKY_ULOHY; 
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kategoria kategoria = null;
        if(rowIndex == 0) {
            kategoria = new Kategoria();
            kategoria.setNazov("Všetky");            
            kategoria.setUlohy(ulohaDao.dajVsetky());
        } else {        
            kategoria = kategoriaDao.dajVsetky().get(rowIndex - RIADOK_PRE_VSETKY_ULOHY);
        }
        switch(columnIndex) {
            case STLPEC_NAZOV:
                return kategoria.getNazov();
            case STLPEC_POCET_ULOH:
                return kategoria.getUlohy().size();
            default:
                return "???";   
        }
    }

    @Override
    public String getColumnName(int column) {
        return NAZVY_STLPCOV[column];
    }
    
    public Kategoria getKategoria(int index) {
        if(index == 0) {
            Kategoria kategoria = new Kategoria();
            kategoria.setNazov("Všetky");            
            kategoria.setUlohy(ulohaDao.dajVsetky());            
            return kategoria;
        } else {        
            return kategoriaDao.dajVsetky().get(index - RIADOK_PRE_VSETKY_ULOHY);
        }
    }
        
}
