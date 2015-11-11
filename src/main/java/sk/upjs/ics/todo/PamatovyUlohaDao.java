package sk.upjs.ics.todo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PamatovyUlohaDao implements UlohaDao {

    private List<Uloha> ulohy = new ArrayList<>();

    public PamatovyUlohaDao() {
        Uloha uloha1 = new Uloha();
        uloha1.setId(1L);
        uloha1.setNazov("Vytvoriť team pre projekt");
        uloha1.setDate(new Date(2015 - 1900, Calendar.OCTOBER, 10));
        ulohy.add(uloha1);
        Uloha uloha2 = new Uloha();
        uloha2.setId(2L);
        uloha2.setNazov("Písať test");
        uloha2.setDate(new Date(2015 - 1900, Calendar.DECEMBER, 16));
        ulohy.add(uloha2);
    }

    @Override
    public void pridat(Uloha uloha) {
        ulohy.add(uloha);
    }

    @Override
    public List<Uloha> dajVsetky() {
        return ulohy;
    }

    @Override
    public void odstranit(Uloha uloha) {
        ulohy.remove(uloha);
    }

    @Override
    public void upravit(Uloha uloha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
