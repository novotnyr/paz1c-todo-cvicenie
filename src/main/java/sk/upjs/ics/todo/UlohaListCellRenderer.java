package sk.upjs.ics.todo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class UlohaListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
        Uloha uloha = (Uloha) value;
        if(jeSplnena(uloha) && !isSelected) {
            component.setBackground(Color.GREEN);
        }
        return component;
    }

    private boolean jeSplnena(Uloha uloha) {
        return uloha.isSplnena();
    }
    
}
