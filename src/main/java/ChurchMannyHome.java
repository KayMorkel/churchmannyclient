import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChurchMannyHome extends JFrame implements ActionListener
{
    private JPanel panel1;
    private JButton churchGoerButton;
    private JButton incomingMoneyButton;
    private JButton collectionButton;
    private JTextArea display;
    private JButton hallBookingButton;
    private JButton exitButton;

    public ChurchMannyHome()
    {
        super("CHURCH OPTIONS");
         add(panel1);

        //add actionlistener
        collectionButton.addActionListener(this);
        incomingMoneyButton.addActionListener(this);
        churchGoerButton.addActionListener(this);
        hallBookingButton.addActionListener(this);
        exitButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == churchGoerButton)
        {
            ChurchGoer ren = new ChurchGoer();
            ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ren.setBounds(700,350,650,500);
            ren.setVisible(true);
            ren.setResizable(true);
            ren.setLocationRelativeTo(null);
        }
        if(e.getSource() == collectionButton)
        {
            Collections ren = new Collections();
            ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ren.setBounds(700,350,650,430);
            ren.setVisible(true);
            ren.setResizable(true);
            ren.setLocationRelativeTo(null);
        }
        if(e.getSource() == incomingMoneyButton)
        {
            IncomingMoney ren = new IncomingMoney();
            ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ren.setBounds(700,350,650,500);
            ren.setVisible(true);
            ren.setResizable(true);
            ren.setLocationRelativeTo(null);
        }
        if(e.getSource() == hallBookingButton)
        {
            HallBooking ren = new HallBooking();
            ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ren.setBounds(700,350,650,500);
            ren.setVisible(true);
            ren.setResizable(true);
            ren.setLocationRelativeTo(null);
        }
        if(e.getSource() == exitButton)
        {
            System.exit(0);
        }
    }

    public static void main (String[] args)
    {
        ChurchMannyHome ren = new ChurchMannyHome();
        ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ren.setBounds(700,350,650,330);
        ren.setVisible(true);
        ren.setResizable(true);
        ren.setLocationRelativeTo(null);
    }
}
