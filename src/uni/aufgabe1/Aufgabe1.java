package uni.aufgabe1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Aufgabe1 extends JFrame {

    Container c;
    JButton b;

    public Aufgabe1() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        b = new JButton("Drueck mich!");
        b.setFont(new Font("SansSerif", Font.ITALIC, 24));
        c.add(b);
        ButtonBearbeiter bL = new ButtonBearbeiter();
        b.addActionListener(bL);
        MausBearbeiter mL = new MausBearbeiter();
        b.addMouseListener(mL);
    }

    public static void main(String[] args) {
        JFrame a = new Aufgabe1();

        a.setTitle("Black and White");
        a.setSize(250, 150);
        a.setVisible(true);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public class ButtonBearbeiter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            c.setBackground(Color.BLACK);

        }

    }

    public class MausBearbeiter implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

            c.setBackground(Color.WHITE);

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
