import java.awt.Color;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
class Fdemo extends JFrame
{
    Jpdemo jp;
    Fdemo()
    {
  jp=new Jpdemo();
  add(jp);
    }
}
class Jpdemo extends JPanel implements ActionListener,KeyListener
{
    ImageIcon img1 ,img2;
    Image dot,head;
    int x[]=new int[100];
    int y[]=new int[100];
    int dots=5;
    boolean start_game=false;


    Jpdemo()// ko hum frame me add karne vale hai
    {
        x[0]=120;
        y[0]=100;
        x[1]=100;
        y[1]=100;
        x[2]=80;
        y[2]=100;
        x[3]=60;
        y[3]=100;
        x[4]=40;
        y[4]=100;
        x[5]=20;
        y[5]=100;
        
        
        
        
        

        setBackground(Color.black);
        img1 =new ImageIcon("snakeimage.png");
        dot=img1.getImage();

        img1 =new ImageIcon("rightmouth.png");
        head=img1.getImage();
        Timer t=new Timer(200,this);
        t.start();

        addKeyListener(this);
        setFocusable(true);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i=0;i<dots;i++)
        {
            if(i==0)
            {
                g.drawImage(head,x[i],y[i],this);

            }
            else
            {
        g.drawImage(dot,x[i],y[i],this);
            }
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(start_game)
        {
        for(int i=dots;i>0;i--)
        {
        x[i]=x[i-1];
        y[i]=y[i-1];
       
        }
        x[0]=x[0]+20;
    }
        repaint();

    }
    public void keyReleased(KeyEvent e){}

public void KeyPressed(KeyEvent e){

    start_game=true;

}

public void KeyTyped(KeyEvent e){}


       
}
class snake
{
    public static void main(String args[])

    {
        Fdemo f=new Fdemo();
        f.setVisible(true);
        f.setBounds(200, 50, 1000, 900);
 f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}