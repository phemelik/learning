package uni.aufgabe2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aufgabe2 extends JFrame{

    Container c;
    private JComboBox<String> formatAuswahl;
    private JLabel beschriftung;
    private JLabel datumsAnzeige;
    private Date datum = new Date();
    private JButton aktualisierung;
    final static SimpleDateFormat kurz = new SimpleDateFormat("EE' , 'd'. 'MMMMM, h:mm");
    final static SimpleDateFormat mittel = new SimpleDateFormat("d. MMMMM, h:mm:ss");
    final static SimpleDateFormat lang = new SimpleDateFormat( "d.MM.yyyy '('hh:mm')'");
    public static SimpleDateFormat gewaehlt = lang;

    public Aufgabe2() {

        c = getContentPane();
        c.setLayout(new BorderLayout());
        String[] format = new String[] { "Datum mit Jahr und Uhrzeit", "Datum und Uhrzeit mit Sekunden", "Tag, Datum und Uhrzeit" };
        formatAuswahl = new JComboBox<>(format);
        beschriftung = new JLabel("Datum und Uhrzeit:");
        datumsAnzeige = new JLabel(gewaehlt.format(datum));
        aktualisierung = new JButton("Anzeige aktualisieren");
        c.add(formatAuswahl, BorderLayout.NORTH);
        c.add(beschriftung, BorderLayout.WEST);
        c.add(datumsAnzeige, BorderLayout.EAST);
        c.add(aktualisierung, BorderLayout.SOUTH);
        AnzeigeListener aL = new AnzeigeListener();
        formatAuswahl.addItemListener(aL);
        KnopfHorcher kH = new KnopfHorcher(datumsAnzeige);
        aktualisierung.addActionListener(kH);

    }

    public static void main(String[] args) {
        JFrame a = new Aufgabe2();

        a.setTitle("Zeitangabe");
        a.setSize(250, 150);
        a.setVisible(true);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public class AnzeigeListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (formatAuswahl.getSelectedIndex() == 0){
                datumsAnzeige.setText(lang.format(datum));
                gewaehlt = lang;
            } else if(formatAuswahl.getSelectedIndex() == 1){
                datumsAnzeige.setText(mittel.format(datum));
                gewaehlt = mittel;
            } else if(formatAuswahl.getSelectedIndex() == 2){
                datumsAnzeige.setText(kurz.format(datum));
                gewaehlt = kurz;
            }
        }

    }
}
