package sk.upjs.ics.todo;

public enum UlohaDaoFactory {
    INSTANCE;
    
    public UlohaDao getUlohaDao() {
        String profil = System.getProperty("profil");
        if("db".equals(profil)) {
            return new MySqlUlohaDao();
        } else {
            return new PamatovyUlohaDao();
        }
    }
}
