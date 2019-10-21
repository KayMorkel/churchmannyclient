import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.border.TitledBorder;
import java.text.*;
import java.io.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ChurchGui extends JFrame implements ActionListener
{
    //Page name or label
    JLabel heading = new JLabel("Church:");

    //Buttons
    JButton create = new JButton("Create new church");
    JButton read = new JButton("Search a church");
    JButton update = new JButton("Edit a church");
    JButton delete = new JButton("Delete a church");
    JButton getall = new JButton("View all churches");

    JButton back = new JButton("Back to main page");

    //Display area
    JTextArea display = new JTextArea(21,58);
    JScrollPane scroll = new JScrollPane(display);

    //Panels
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JPanel bottomPanel1 = new JPanel();
    JPanel bottomPanel2 = new JPanel();
    JPanel bottomPanel3 = new JPanel();

    public ChurchGui()
    {
        super("CHURCH OPTIONS");
        //Setting layout
        setLayout(new BorderLayout());

        //setting panel layouts
        topPanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new GridLayout(1, 2));
        bottomPanel1.setLayout(new GridLayout(3, 2));
        bottomPanel2.setLayout(new GridLayout(2, 1));
        bottomPanel3.setLayout(new FlowLayout());

        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(heading);

        bottomPanel1.add(create);
        bottomPanel1.add(read);
        bottomPanel1.add(update);
        bottomPanel1.add(delete);
        bottomPanel1.add(getall);
        //bottomPanel1.setBorder(new EmptyBorder(2,0,2,0));

        bottomPanel3.add(back);
        //back.setSize(10, 10);
        bottomPanel2.add(scroll);
        bottomPanel2.add(bottomPanel3);


        bottomPanel.add(bottomPanel1);
        bottomPanel.add(bottomPanel2);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel1, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.CENTER);

        //add actionlistener
        create.addActionListener(this);
        read.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        getall.addActionListener(this);
        back.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == create)
        {
            display.setText("You can create a new church");
        }
        if(e.getSource() == read)
        {
            display.setText("You can search for a church with a specific name");
        }
        if(e.getSource() == update)
        {
            display.setText("You can update details of an existing church");
        }
        if(e.getSource() == delete)
        {
            display.setText("You can delete a church");
        }
        if(e.getSource() == getall)
        {
            display.setText("You can get a list of all churches");
        }
        if(e.getSource() == back)
        {
            Main ren = new Main();
            ren.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ren.setBounds(700,350,930,510);
            ren.setVisible(true);
            ren.setResizable(true);
            ren.setLocationRelativeTo(null);
        }
    }

    public static void main (String[] args)
    {
        ChurchGui ren = new ChurchGui();
        ren.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ren.setBounds(700,350,650,430);
        ren.setVisible(true);
        ren.setResizable(true);
        ren.setLocationRelativeTo(null);
    }
}
