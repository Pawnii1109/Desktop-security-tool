import javax.swing.*;

public class Viewer extends JFrame implements Runnable{

  JLabel L1;
  Thread t1;
  int i=0;
  public Viewer()
  {
    this.setVisible(true);
    this.setSize(150,100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    L1 = new JLabel();
    this.add(L1);
    t1 = new Thread(this);
    t1.start();
  }
  public void run()
  {
    for(;;)
    {
      try {
        ImageIcon img = new ImageIcon("c:\\pic\\"+i+".jpg");
        L1.setIcon(img);
        i++;
        t1.sleep(300);
      }
      catch(Exception e)
      {
        
      }
    }
  }

  public static void main(String[] args) {
    new Viewer();

  }

}