
package moj_kalkulator;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import javax.swing.*;

public class Main extends JFrame implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22;
    JButton zapisz,wyczysc,otworz;
    JTextField f1;
    JLabel l1,l2;
    JPanel p1;
    JRadioButton on,off;
    ButtonGroup g;
    JScrollPane scroll;
    JEditorPane edit;
    double wynik=0;
    double pom;
    int numer;
    private int clicks;
    String zmienie="";
    Main()
    {
        JFrame frame=new JFrame();
        SpringLayout layout=new SpringLayout();
       
        p1=new JPanel();
        edit=new JEditorPane();
       
        scroll=new JScrollPane(edit);
        scroll.setPreferredSize(new Dimension(150,180));
        l2=new JLabel("Historia");
      
        
    
        
        add(p1);
        p1.setLayout(layout);
        
       
       
        b1=new JButton("0");
        b2=new JButton("1");
        b3=new JButton("2");
        b4=new JButton("3");
        b5=new JButton("4");
        b6=new JButton("5");
        b7=new JButton("6");
        b8=new JButton("7");
        
        b9=new JButton("8");
        b10=new JButton("9");
        b11=new JButton("+");
        b12=new JButton("-");
        b12.setPreferredSize(new Dimension(41,26));
        b13=new JButton("*");
        b13.setPreferredSize(new Dimension(41,26));
        b14=new JButton("/");
        b14.setPreferredSize(new Dimension(41,26));
        b15=new JButton("=");
        b16=new JButton(".");
        b16.setPreferredSize(new Dimension(41,26));
        b17=new JButton("c");
        b17.setPreferredSize(new Dimension(41,26));
        f1=new JTextField();
        f1.setPreferredSize(new Dimension(161,20));
        l1=new JLabel();
        l1.setPreferredSize(new Dimension(163,20));
        on=new JRadioButton("on");
        on.setPreferredSize(new Dimension(41,13));
        off=new JRadioButton("off");
        off.setPreferredSize(new Dimension(41,13));
        b18=new JButton("ce");
     
        b18.setPreferredSize(new Dimension(82,26));
        b19=new JButton("+-");
        b20=new JButton("x^2");
        
        b19.setPreferredSize(new Dimension(82,26));
        b20.setPreferredSize(new Dimension(81,26));
        b21=new JButton("sqrt(x)");
        b22=new JButton("1/x");
        
        wyczysc=new JButton("wyczysc");
        zapisz=new JButton("zapisz");
        otworz=new JButton("otwórz");
        
        
        b21.setPreferredSize(new Dimension(82,26));
        b22.setPreferredSize(new Dimension(81,26));
        
        b19.setHorizontalAlignment(SwingConstants.CENTER);
        f1.setHorizontalAlignment(SwingConstants.RIGHT);
        l1.setHorizontalAlignment(SwingConstants.RIGHT);
        
        
        //ustawienie położenia label 1
        
        layout.putConstraint(SpringLayout.WEST,l1,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,l1,20,SpringLayout.SOUTH,frame);
        
        // ustalenie położenia l1 w zależności od okna
        
        layout.putConstraint(SpringLayout.WEST,f1,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,f1,40,SpringLayout.SOUTH,frame);
        
        //dodanie labelu Historia
        layout.putConstraint(SpringLayout.WEST,l2,240,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,l2,35,SpringLayout.SOUTH,frame);
        
       
        // ustalenie położenia drugiego panelu, na którym będzie
        // zapisywana historia działań
        
        layout.putConstraint(SpringLayout.WEST,scroll,240,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,scroll,50,SpringLayout.SOUTH,b12);
                
        // ustalenie położenia przycisku do zapisywania historii działań
        
        layout.putConstraint(SpringLayout.WEST,wyczysc,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,wyczysc,50,SpringLayout.SOUTH,scroll);
        
        layout.putConstraint(SpringLayout.WEST,zapisz,150,SpringLayout.WEST,wyczysc);
        layout.putConstraint(SpringLayout.SOUTH,zapisz,50,SpringLayout.SOUTH,scroll);
        
        layout.putConstraint(SpringLayout.WEST,otworz,150,SpringLayout.WEST,zapisz);
        layout.putConstraint(SpringLayout.SOUTH,otworz,50,SpringLayout.SOUTH,scroll);
        
        // ustalenie położenia przycisków
        // b17- czyszczenie pola tekstowego
        
        layout.putConstraint(SpringLayout.WEST, b17,140,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH, b17,65,SpringLayout.SOUTH,frame);
        
        //ustalenie położenia buttonów on i off odpowiedzialnych za włączanie sprzętu
        layout.putConstraint(SpringLayout.WEST,on,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,on,52,SpringLayout.SOUTH,frame);
       
        layout.putConstraint(SpringLayout.WEST,off,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,off,65,SpringLayout.SOUTH,frame);
        
        // ustalenie położenia prycisku
        //+- - negacji liczby
        // w zależności od położenia okna oraz 
        //przycisku b18- czyszczenie labela i pola tekstowego
        
        layout.putConstraint(SpringLayout.WEST,b19,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH, b19,25,SpringLayout.SOUTH,b18);
        
        layout.putConstraint(SpringLayout.WEST,b21,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH, b21,25,SpringLayout.SOUTH, b19);
        
        layout.putConstraint(SpringLayout.WEST, b22,80,SpringLayout.WEST, b21);
        layout.putConstraint(SpringLayout.SOUTH,b22,25,SpringLayout.SOUTH,b19);
        //ustalenie położenia przycisku
        //b20- podniesienie liczby do kwadratu
        // w zależności od przycisku b19- negacji liczby w tym samym wierszu
        // w osi pionowej od przycisku b18- czyszczenia "ce"
        
        layout.putConstraint(SpringLayout.WEST, b20,80,SpringLayout.WEST, b19);
        layout.putConstraint(SpringLayout.SOUTH, b20,25,SpringLayout.SOUTH, b18);
        
        //ustalenie położenia przycisku b18- "ce"
        // w poziomie i pionie od wymiarów okna typu JFrame
        
        layout.putConstraint(SpringLayout.WEST,b18,60,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,b18,65,SpringLayout.SOUTH,frame);
        
        //ustalenie położenia przycisków 
        // b8 -cyfra "7"
        //b9 -cyfra "8"
        //b10 -cyfra "9"
        // w odległości od górnej krawędzi okna
        layout.putConstraint(SpringLayout.SOUTH,b8,140,SpringLayout.SOUTH,frame);
        layout.putConstraint(SpringLayout.SOUTH,b9,140,SpringLayout.SOUTH,frame);
        layout.putConstraint(SpringLayout.SOUTH,b10,140,SpringLayout.SOUTH,frame);
        
        // ustalenie położenia przycisków
        //b8- cyfra "7" od lewego brzegu okna
        //b9- cyfra "8" od pzycisku b8
        //b10 - cyfra "9" od przycisku b9
        
        layout.putConstraint(SpringLayout.WEST,b8,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.WEST,b9,40,SpringLayout.WEST,b8);
        layout.putConstraint(SpringLayout.WEST,b10,40,SpringLayout.WEST,b9);
        
        // ustalenie położenia przycisku b5- cyfra "4"
        // w poziomie od ramki w pinoie od b8- cyfra "7"
        layout.putConstraint(SpringLayout.WEST,b5,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,b5,25,SpringLayout.SOUTH,b8);
        
        // ustalenie położenia przycisku b6- cyfra "5"
        // w poziomie od b5- cyfra "4"
        // w pionie od b9 - cyfra "8"
        layout.putConstraint(SpringLayout.WEST,b6,40,SpringLayout.WEST,b5);
        layout.putConstraint(SpringLayout.SOUTH,b6,25,SpringLayout.SOUTH,b9);
        
        //ustalenie położenia przycisku b7- cyfra "6"
        // w poziomie od b6 cyfra "8"
        // w pionie od b10- cyfra "9"
        layout.putConstraint(SpringLayout.WEST,b7,40,SpringLayout.WEST,b6);
        layout.putConstraint(SpringLayout.SOUTH,b7,25,SpringLayout.SOUTH,b10);
        
        //ustalenie położenia przycisku b2- cyfra "1"
        // w poziomie od ramki
        // w pionie od b5- cyfra "4"
        layout.putConstraint(SpringLayout.WEST,b2,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,b2,25,SpringLayout.SOUTH,b5);
         
        //ustalenie położenia przycisku b3- cyfra "2"
        // w poziomie od b2- cyfra "1"
        // w pionie od b7- cyfra "6"
        layout.putConstraint(SpringLayout.SOUTH,b3,25,SpringLayout.SOUTH,b6);
        layout.putConstraint(SpringLayout.WEST,b3,40,SpringLayout.WEST,b2);
        
        //ustalenie położenia przycisku b4- cyfra "3"
        // w poziomie od b7- cyfra "6"
        // w pionie od b3- cyfra "2"
        layout.putConstraint(SpringLayout.SOUTH,b4,25,SpringLayout.SOUTH,b7);
        layout.putConstraint(SpringLayout.WEST,b4,40,SpringLayout.WEST,b3);
        
        //ustalenie położenia przycisku b1- cyfra "0"
        //w poziomie od ramki
        //w pionie od b3- cyfra "2"
        layout.putConstraint(SpringLayout.WEST,b1,60,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH, b1,25,SpringLayout.SOUTH,b3);
        
        //ustalenie położenia przycisku b16 - kropka
        // w poziomie od b1- cyfra "0"
        // w pionie od b4- cyfra "3"
        layout.putConstraint(SpringLayout.WEST,b16,40,SpringLayout.WEST,b1);
        layout.putConstraint(SpringLayout.SOUTH,b16,25,SpringLayout.SOUTH,b4);
        
        //ustalenie położenia przycisku b15 - znak "="
        // w poziomie od b16- kropka
        // w pionie od b4- cyfra "3"
        layout.putConstraint(SpringLayout.WEST,b15,40,SpringLayout.WEST,b16);
        layout.putConstraint(SpringLayout.SOUTH,b15,25,SpringLayout.SOUTH,b4);
        
        //ustalenie położenia przycisku b11- znak "+"
        //w poziomie od b4-cyfra "3"
        // w pionie od b6- cyfra "5"
        layout.putConstraint(SpringLayout.WEST,b11,40, SpringLayout.WEST, b4);
        layout.putConstraint(SpringLayout.SOUTH,b11,25,SpringLayout.SOUTH,b6);
        
        //ustalenie położenia przycisku b12- znak "-"
        //w poziomie od b7 -cyfra "6"
        // w pionie od b8 -cyfra "7"
        layout.putConstraint(SpringLayout.WEST, b12,40,SpringLayout.WEST,b7);
        layout.putConstraint(SpringLayout.SOUTH, b12,25,SpringLayout.SOUTH,b8);
        
        //ustalenie położenia przycisku b13- znak "*" (mnożenia)
        // w poziomie od b10- cyfra "9"
        // w pionie od Ramki
        layout.putConstraint(SpringLayout.WEST,b13,40,SpringLayout.WEST,b10);
        layout.putConstraint(SpringLayout.SOUTH, b13,140,SpringLayout.SOUTH,frame);
        
        //ustalenie położenia przycisku b14- znak "/" dzielenia
        // w poziomie od okna
        // w pionie od przycisku b2- cyfra "1"
        layout.putConstraint(SpringLayout.WEST,b14,20,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,b14,25,SpringLayout.SOUTH,b2);
        
        // utworzenie grupy dla radiobuttonów on i off 
        g=new ButtonGroup();
        // dodanie oby radiobuttonów do grupy
        
        g.add(on);
        g.add(off);
        on.setSelected(true);
        //dodawanie wszystkich elementów do panelu p1 odbowiedzialnych za odpowiednie operacje
        
        p1.add(b8);
        p1.add(b9);
        p1.add(b10);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b1);
        p1.add(b16);
        p1.add(f1);
        p1.add(l1);
        p1.add(b15);
        p1.add(b11);
        p1.add(b12);
        p1.add(b13);
        p1.add(b14);
        p1.add(b17);
        p1.add(b18);
        p1.add(on);
        p1.add(off);
        p1.add(b19);
        p1.add(b20);
        p1.add(b21);
        p1.add(b22);
        p1.add(scroll);
        p1.add(l2);
        p1.add(otworz);
        p1.add(zapisz);
        p1.add(wyczysc);
        //dodanie każdemu elementowi odbiorcy zdarzeń
        
        b1.addActionListener(this);
        
        b2.addActionListener((ActionEvent e) -> {
            f1.setText(f1.getText()+"1");
            l1.setText(f1.getText());
            l1.setVisible(false);
            
           
        });
        
        b3.addActionListener((ActionEvent e) -> {
            f1.setText(f1.getText()+"2");
            l1.setText(f1.getText());
            l1.setVisible(false);
           
       
        });
        
       b4.addActionListener((ActionEvent e) -> {
           f1.setText(f1.getText()+"3");
           l1.setText(f1.getText());
           l1.setVisible(false);
           
          
          
        });
       
       b5.addActionListener((ActionEvent e) -> {
           f1.setText(f1.getText()+"4");
           l1.setText(f1.getText());
           l1.setVisible(false);
        
        });
       
       b6.addActionListener((ActionEvent e) -> {
           f1.setText(f1.getText()+"5");
           l1.setText(f1.getText());
           l1.setVisible(false);
       
         
        });
       
       b7.addActionListener((ActionEvent e) -> {
           f1.setText(f1.getText()+"6");
           l1.setText(f1.getText());
           l1.setVisible(false);
           
          
                   
        });
       
       b8.addActionListener((ActionEvent e) -> {
           f1.setText(f1.getText()+"7");
           l1.setText(f1.getText());
           l1.setVisible(false);
       
        });
       
       b9.addActionListener((ActionEvent e) -> {
           f1.setText(f1.getText()+"8");
           l1.setText(f1.getText());
           l1.setVisible(false);
           
           
        });
       
       b10.addActionListener((ActionEvent e) -> {
           f1.setText(f1.getText()+"9");
           l1.setText(f1.getText());
           l1.setVisible(false);

           
        });
    
        // dodanie ActionListenerów do Buttonów odpowiedzialnych za operacje arytmetyczne
        // ustawienie labelu na text nie widzialny aby działa negacja
        b11.addActionListener((ActionEvent e) -> {
            l1.setVisible(true);
            pom=Double.parseDouble(f1.getText());
            l1.setText(pom+"+");
            f1.setText("");
           
            numer=1;
        });
        
        b12.addActionListener((ActionEvent e) -> {
            l1.setVisible(true);
            pom=Double.parseDouble(f1.getText());
            l1.setText(pom+"-");
            f1.setText("");
            
            numer=2;
        });
        
        b13.addActionListener((ActionEvent e) -> {
           l1.setVisible(true);
            pom=Double.parseDouble(f1.getText());
            l1.setText(pom+"*");
            f1.setText("");
          
            numer=3;
        });
        
        b14.addActionListener((ActionEvent e) -> {
            l1.setVisible(true);
            pom=Double.parseDouble(f1.getText());
            l1.setText(pom+"/");
            f1.setText("");
            
            numer=4;
        });
        
        b15.addActionListener((ActionEvent e) -> {
            operacja_arytmetyczna();
            
            zmienie+=" ="+f1.getText()+" \n ";
            edit.setText(zmienie);
        });
        b16.addActionListener((ActionEvent e)->{
           f1.setText(f1.getText()+".");
           zmienie+="= "+  l1.getText()+ " \n ";
           edit.setText(zmienie);
            
        });
        
        b17.addActionListener(((e) -> {
            f1.setText("");
            zmienie+="Czyszczenie bufora  \n ";
            edit.setText(zmienie);
           
        }));
        
        b18.addActionListener((ActionEvent e)->{
            l1.setText("");
            f1.setText("");
            
            zmienie+="Czyszczenie bufora \n ";
            edit.setText(zmienie);
              
        });
        
        // po kliknięciu na przycisk on wszystkie przyciski stają się dostępne
        on.addActionListener((ActionEvent e)->{
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            b10.setEnabled(true);
            b11.setEnabled(true);
            b12.setEnabled(true);
            b13.setEnabled(true);
            b14.setEnabled(true);
            b15.setEnabled(true);
            b16.setEnabled(true);
            b17.setEnabled(true);
            b18.setEnabled(true);
            b19.setEnabled(true);
            b20.setEnabled(true);
            b21.setEnabled(true);
            b22.setEnabled(true);
            f1.setEnabled(true);
            l1.setEnabled(true);
            scroll.setEnabled(true);
            wyczysc.setEnabled(true);
            otworz.setEnabled(true);
            zapisz.setEnabled(true);
            p1.setBackground(Color.LIGHT_GRAY);
                    
        });
        // po kliknięciu na off wszystkie przyciski stają się dezaktywne
        
        off.addActionListener((ActionEvent e)->{
             b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);
            b17.setEnabled(false);
            b18.setEnabled(false);
            b19.setEnabled(false);
            b20.setEnabled(false);
            b21.setEnabled(false);
            b22.setEnabled(false);
            f1.setEnabled(false);
            l1.setEnabled(false);
            wyczysc.setEnabled(false);
            otworz.setEnabled(false);
            zapisz.setEnabled(false);
            scroll.setEnabled(false);
            p1.setBackground(Color.DARK_GRAY);
        });
        
     
        // zliczanie ilosci kliknięc na Button odpowiedzialny za negację jeśli ilość
        //kliknięć parzysta to nasza liczba jest nieujemna
        // jeśli nieparzysta to liczba jest ujemna
        
        b19.addActionListener((ActionEvent e)->{
           clicks++;
           if(clicks%2!=0){
               f1.setText("-"+f1.getText());
               zmienie+= f1.getText()+ " \n  ";
           }
           else {
               
              f1.setText(l1.getText());
              zmienie+="Działanie:  "+f1.getText()+ "\n ";

           }
            edit.setText(zmienie);
        });
       
        // podnoszenie liczby do kwadratu
        
        b20.addActionListener((ActionEvent e)->{
        pom=Double.parseDouble(f1.getText());
        wynik=Math.pow(pom,2);
        f1.setText(Double.toString(wynik));
        zmienie+="Działanie:"  +f1.getText()+ " \n ";
        edit.setText(zmienie);
        
        });
        
        
        // dodanie słuchacza obliczającego pierwiastek z podanej liczby
        b21.addActionListener((ActionEvent e)->{
            
            pom=Double.parseDouble(f1.getText());
            if(pom<0.0){
                JOptionPane.showMessageDialog(null,"Nie można wykonać pierwiastkowania na liczbie");
            }
            else{
                wynik=Math.sqrt(pom);
                f1.setText(Double.toString(wynik));
                zmienie+="Działanie:  "+f1.getText()+" \n ";
                edit.setText(zmienie);
           
                 
            }
           
        });
        
        b22.addActionListener((ActionEvent e)->{
            try{
            pom=Double.parseDouble(f1.getText());
            if(pom==0.0){
                JOptionPane.showMessageDialog(null,"Nie można dzielić przez zero ");
                f1.setText("Nie można dzielić przez 0");
            }
            wynik=1/pom;
            f1.setText(Double.toString(wynik));
            
            zmienie+="Działanie:  "+f1.getText() + " \n ";
            edit.setText(zmienie);
           
            }catch(ArithmeticException exc){
                System.out.println(exc.getMessage());
            }
        });
        
        zapisz.addActionListener((ActionEvent e)->{
           JFileChooser fc=new JFileChooser();
           if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
               File file=fc.getSelectedFile();
               String path=file.getAbsolutePath();
               
               try{
                   BufferedWriter wr=new BufferedWriter(new FileWriter(path));
                   wr.write(edit.getText());
                   wr.close();
                   JOptionPane.showMessageDialog(null,"Udało się zapisac dane do pliku");
               }catch(IOException ed){
                   ed.getMessage();
               }
           }
        });
        
        otworz.addActionListener((ActionEvent e)->{
            JFileChooser fc2=new JFileChooser();
            if(fc2.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                File file=fc2.getSelectedFile();
                String path=file.getAbsolutePath();
                
                try{
                    String line;
                    StringBuilder tekst= null;
                    BufferedReader reader=new BufferedReader(new FileReader(path));
                    while((line=reader.readLine())!=null) {
                        assert false;
                        tekst.append(line);
                    }
                    edit.setText(Objects.requireNonNull(null).toString());
                    JOptionPane.showMessageDialog(null,"Odczytywanie danych z pliku zakończone sukcesem");
                }catch(IOException xd){
                    xd.getMessage();
                }
            }
        });
        
        wyczysc.addActionListener((ActionEvent e)-> edit.setText(""));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(420,320);
        
    }
    
    
    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     f1.setText(f1.getText()+"0"); 
     l1.setText(f1.getText());
     l1.setVisible(false);
     
    
   
    }
    
    public void operacja_arytmetyczna(){
        
        switch(numer){
            case 1:
                wynik=pom+Double.parseDouble(f1.getText());
                l1.setText(pom+"+"+Double.parseDouble(f1.getText()));
                zmienie+=l1.getText()+"\n";
                f1.setText(Double.toString(wynik));
                edit.setText(zmienie);
                l1.setVisible(true);
             
                break;
            case 2:
                wynik=pom-Double.parseDouble(f1.getText());
                l1.setText(pom+"-"+Double.parseDouble(f1.getText()));
                zmienie+=l1.getText();
                f1.setText(Double.toString(wynik));
                edit.setText(zmienie);
                l1.setVisible(true);
                break;
            case 3:
                wynik=pom*Double.parseDouble(f1.getText());
                l1.setText(pom+"*"+Double.parseDouble(f1.getText()));
                zmienie+=l1.getText();
                f1.setText(Double.toString(wynik));
                edit.setText(zmienie);
                l1.setVisible(true);
                break;
            case 4:
                   if(Double.parseDouble(f1.getText())==0.0) 
                   {
                        f1.setText("Nie można dzielić przez zero");
                       JOptionPane.showMessageDialog(null,"Nie można dzielić przez zero");    
                   }
                   
                   wynik=pom/Double.parseDouble(f1.getText());
                   l1.setText(pom+"/"+Double.parseDouble(zmienie));
                   f1.setText(Double.toString(wynik));
                   l1.setVisible(true);
                break;
        }
    }
}
