package uni.aufgabe2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class KnopfHorcher implements ActionListener {

    JLabel datumsAnzeige;

    public KnopfHorcher (JLabel datumsAnzeige) {
        this.datumsAnzeige = datumsAnzeige;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Date datum = new Date();
        datumsAnzeige.setText(Zeitangabe.gewaehlt.format(datum));
    }

}
