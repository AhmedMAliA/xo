/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myxo;
import java.awt.GridLayout;
import javafx.scene.paint.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Eng-mahmoud
 */
public class XOMe extends JFrame implements  ActionListener{
    
    JPanel Panel1;
       int count = 0;
    JButton [] Bnt;
    String [][] MatrixXO;
    String xando = "O";
    public XOMe ()
    {
        setTitle("X O Game");
        MatrixXO = new String[3][3];
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel1 = new JPanel();
        Panel1.setLayout(new GridLayout(3,3));
        Bnt = new JButton[9];
        
        for(int i = 0; i < 9; i++)
        {
            Bnt[i] = new JButton();
            Bnt[i].setBackground(java.awt.Color.WHITE);
            Bnt[i].addActionListener(this);
            Panel1.add(Bnt[i]);
        }
        add(Panel1);
    //    pack();
        setVisible(true);
    }
    public String checkxando (String val)
    {
        if(val.equals(null))
        {
            return null;
        }
        else
        {
            return val;
        }
    }
    public String checkwin ()
    {
        if(Bnt[0].getText().equals(Bnt[1].getText()) && Bnt[0].getText().equals(Bnt[2].getText()))
        {
            return checkxando(Bnt[0].getText());
        }
        if(Bnt[3].getText().equals(Bnt[4].getText()) && Bnt[3].getText().equals(Bnt[5].getText()) )
        {
           return checkxando(Bnt[3].getText());
        }
        if(Bnt[6].getText().equals(Bnt[7].getText()) && Bnt[6].getText().equals(Bnt[8].getText()) )
        {
           return checkxando(Bnt[6].getText());
        }
         if(Bnt[0].getText().equals(Bnt[3].getText()) && Bnt[0].getText().equals(Bnt[6].getText()) )
        {
           return checkxando(Bnt[0].getText());
        }
        if(Bnt[1].getText().equals(Bnt[4].getText()) && Bnt[1].getText().equals(Bnt[7].getText()) )
        {
           return checkxando(Bnt[1].getText());
        }
        if(Bnt[2].getText().equals(Bnt[5].getText()) && Bnt[2].getText().equals(Bnt[8].getText()) )
        {
           return checkxando(Bnt[2].getText());
        }
        if(Bnt[0].getText().equals(Bnt[4].getText()) && Bnt[4].getText().equals(Bnt[8].getText()) )
        {
           return checkxando(Bnt[0].getText());
        }
        if(Bnt[2].getText().equals(Bnt[4].getText()) && Bnt[4].getText().equals(Bnt[6].getText()) )
        {
           return checkxando(Bnt[2].getText());
        }
        
        return null;
        
    }
    public void Draw ()
    {
     
       if((Bnt[0].getText().equals("X") || Bnt[0].getText().equals("O"))
          &&(Bnt[1].getText().equals("X") || Bnt[1].getText().equals("O"))
          &&(Bnt[2].getText().equals("X") || Bnt[2].getText().equals("O"))   
           &&(Bnt[3].getText().equals("X") || Bnt[3].getText().equals("O"))        
           &&(Bnt[4].getText().equals("X") || Bnt[4].getText().equals("O"))        
            &&(Bnt[5].getText().equals("X") || Bnt[5].getText().equals("O"))       
            &&(Bnt[6].getText().equals("X") || Bnt[6].getText().equals("O"))  
            &&(Bnt[7].getText().equals("X") || Bnt[7].getText().equals("O"))   
            &&(Bnt[8].getText().equals("X") || Bnt[8].getText().equals("O"))   
               )
       {
           JOptionPane.showMessageDialog(null,"Tie");
           reset();
       }
              
    }
    public void reset ()
    {
        for(int i = 0; i < 9; i++)
        {
            Bnt[i].setText("");
            Bnt[i].setEnabled(true);
        }
    }
    public void X_or_O ()
    {
       String result = checkwin();
       System.out.println(result);
       if(result.equals("X"))
       {
           JOptionPane.showMessageDialog(null,"Wooow X is Winner");
          // System.exit(0); solution 1
           reset(); //solution2
       }
       else if (result.equals("O"))
       {
           JOptionPane.showMessageDialog(null,"Wooow O is Winner");
         //   System.exit(0); solution 1
            reset();  //solution2
       }
    }
    public void writexando ()
    {
        if(xando.equals("O"))
        {
            xando = "X";
            
        }
        else 
        {
            xando = "O";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       for(int i = 0 ; i < 9; i++)
       {
              
           if(Bnt[i] == e.getSource())
           {
               count = i;
            Bnt[i].setText(xando);
            writexando();
          
            Bnt[i].setForeground(java.awt.Color.BLUE);
            Bnt[i].setEnabled(false);
           }
            
       }
       System.out.println(count);
       X_or_O();
       Draw();
    
     
    }
    
}
