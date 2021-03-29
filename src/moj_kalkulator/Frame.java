
package moj_kalkulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Frame extends JFrame implements ActionListener{
    Frame(){
        setTitle("Witaj w drugim oknie po klinkięciu w button ");
        JButton welcome=new JButton("Witaj");
        welcome.addActionListener(this);
        add(welcome);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    public static void main(String[] args) {
        Frame frame=new Frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       new Main().setVisible(true);
       this.dispose();
    }
}
