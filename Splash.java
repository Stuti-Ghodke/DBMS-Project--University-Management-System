package uni.manage.sys;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable
{
    Thread t;

    Splash()
    {
        // Load the image from the resources
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT); // Scaling the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3); // Corrected JLabel (not Jlabel)
        add(img);

        t = new Thread(this); // No need for named parameters; just pass 'this'
        t.start();

        setVisible(true);

        int x = 1;
        for (int i = 2; i <= 600; i += 4, x += 1)
        {
            setLocation(600 - ((i + x) / 2), 350 - (i / 2));
            setSize(i + 3 * x, i + x / 2); // Corrected setSize parameters

            try {
                Thread.sleep(10); // Add a sleep to see the effect of resizing
            } catch (Exception e) {
                e.printStackTrace(); // Correct method call for exception handling
            }
        }
    }

    public void run()
    {
        try {
            Thread.sleep(7000); // No named parameters for Thread.sleep
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Splash(); // Call the constructor
    }
}
