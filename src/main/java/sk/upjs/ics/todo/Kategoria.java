package sk.upjs.ics.todo;

import java.util.LinkedList;
import java.util.List;

public class Kategoria {
    private Long id;
    
    private String nazov;
    
    private List<Uloha> ulohy = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public List<Uloha> getUlohy() {
        return ulohy;
    }

    public void setUlohy(List<Uloha> ulohy) {
        this.ulohy = ulohy;
    }
            
    
}
