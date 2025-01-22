import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
public class Logger2 extends JFrame implements ActionListener,Runnable{

  JButton b1,b2;
  JPanel p1;
  Thread t1;
  int i=0;
  public Logger2()
  {
    this.setVisible(true);
    this.setSize(150,100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    p1 = new JPanel();
    b1 = new JButton("Start");
    b2 = new JButton("Stop");
    p1.add(b1);
    p1.add(b2);
    this.add(p1);
    b1.addActionListener(this);
    b2.addActionListener(this);
  }
  public void run()
  {
    for(;;)
    {
      try {
        
        Robot r = new Robot();
        BufferedImage img =
        r.createScreenCapture(new Rectangle(getToolkit().getScreenSize()));
        ImageIO.write(img, "jpg", new File("c:\\pic\\"+i+".jpg"));
        i++;
        t1.sleep(300);
      }
      catch(Exception ex)
      {
        
      }
    }
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
    {
      t1=new Thread(this);
      t1.start();
    }
    else
    {
      //t1.suspend();
      System.exit(0);
    }
  }
  
  public static void main(String[] args) {
    
new Logger2();
  }

}