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

public class Main extends JFrame implements ActionListener
{

    JButton churchGoer = new JButton("Church goers");
    JButton collection = new JButton("Collection");
    JButton pledges = new JButton("Pledges");

//    JButton sw = new JButton("Search");
//    JButton rent = new JButton("Rent A Movie");
//    JButton btnreturn = new JButton("Return A Dvd");
//    JButton exit = new JButton("Exit");
//    JButton returnMovie = new JButton("Return Movie");
//    JButton btnSearch = new JButton("Confirm");

    //TextArea
    JTextArea display = new JTextArea(21,58);
    JScrollPane scroll = new JScrollPane(display);

    //Adding Labels
    JLabel heading = new JLabel("WELCOME TO CHURCH MANNY");
    JLabel startWith = new JLabel("Enter first letter of movie:");

    //Create JMenuBar
    JMenuBar bar = new JMenuBar();

    //Create JMenu for MenuBar
    JMenu menu = new JMenu("ADD");
    JMenu menu1 = new JMenu("DELETE");
    JMenu menu2 = new JMenu("UPDATE");

    //Array
    String[] categories = {"SELECT MOVIE"};
    String[] categories1 = {"SELECT PHONE NUMBER"};

    //ComboBoxes
    JComboBox cbChooseReturnMovie = new JComboBox();
    JComboBox cbChooseReturnCustomer = new JComboBox();

    //Creating menu item
    JMenuItem itemAddCust = new JMenuItem("Customer");
    JMenuItem itemAddMovie = new JMenuItem("Movie");

    JMenuItem itemDeleteCust = new JMenuItem("Customer");
    JMenuItem itemDeleteMovie = new JMenuItem("Movie");

    JMenuItem itemUpdateCust = new JMenuItem("Customer");
    JMenuItem itemUpdateMovie = new JMenuItem("Movie");

    //Adding TextFields
    JTextField txtStartLetter = new JTextField(10);

    //String array for cbOper
    String[] cOper = {"ADD","SORT","DISPLAY"};

    //Adding JComboBox Of Add Sort and Display Operations
    JComboBox cbOper = new JComboBox(cOper);

    //Adding Panels
    //JPanel bottomP = new JPanel();
    JPanel rowPanel = new JPanel();
    JPanel rowCenterPanel = new JPanel();
    JPanel rowEastPanel = new JPanel();
    JPanel rowFlowPanel = new JPanel();

    JPanel p1 = new JPanel(new FlowLayout());
    JPanel p2 = new JPanel(new FlowLayout());
    JPanel p3 = new JPanel(new FlowLayout());

    public Main()
    {
        super("DVD HOME SCREEN");
        //Setting layout
        setLayout(new BorderLayout());

        //Adding bar to menu
        bar.add(menu);
        bar.add(menu1);
        bar.add(menu2);

        //Adding items to menu
        menu.add(itemAddCust);
        menu.add(itemAddMovie);

        menu1.add(itemDeleteCust);
        menu1.add(itemDeleteMovie);

        menu2.add(itemUpdateCust);
        menu2.add(itemUpdateMovie);

        //Add menu to frame
        setJMenuBar(bar);

        churchGoer.setPreferredSize(new Dimension(240,70));
        pledges.setPreferredSize(new Dimension(240,70));
        collection.setPreferredSize(new Dimension(240,70));

        //Setting Panel Layouts
       // bottomP.setLayout(new GridLayout(3,1));
        rowPanel.setLayout(new BorderLayout());
        rowCenterPanel.setLayout(new GridLayout(4,1));
        rowEastPanel.setLayout(new FlowLayout());
        rowFlowPanel.setLayout(new FlowLayout());

        //Searching for first letter of movie title
        rowFlowPanel.add(pledges);
        rowFlowPanel.add(collection);
        rowFlowPanel.add(churchGoer);

        p1.add(churchGoer);
        p2.add(pledges);
        p3.add(collection);

        //list buttons
        rowCenterPanel.setBorder(new EmptyBorder(2,0,2,0));
        rowCenterPanel.add(rowFlowPanel);
        rowCenterPanel.add(p1);
        rowCenterPanel.add(p2);
        rowCenterPanel.add(p3);

        //TextArea to display details
        rowEastPanel.add(scroll);

//        bottomP.add(rent);
//        bottomP.add(btnreturn);
//        bottomP.add(exit);

        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        //setting to regions
        add(heading, BorderLayout.NORTH);
        add(rowCenterPanel, BorderLayout.CENTER);
        add(rowEastPanel, BorderLayout.EAST);
       // add(bottomP, BorderLayout.SOUTH);

        itemAddCust.addActionListener(this);
        itemDeleteCust.addActionListener(this);
        itemAddMovie.addActionListener(this);
        itemDeleteMovie.addActionListener(this);
        itemUpdateCust.addActionListener(this);
        itemUpdateMovie.addActionListener(this);
        //rent.addActionListener(this);
        churchGoer.addActionListener(this);
        pledges.addActionListener(this);
        collection.addActionListener(this);
//        sw.addActionListener(this);
//        btnreturn.addActionListener(this);
        cbChooseReturnMovie.addActionListener(this);
//        exit.addActionListener(this);
//        returnMovie.addActionListener(this);
//        btnSearch.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == churchGoer)
        {
            display.append("Hello there\n" );
        }
    }

    public static void main(String[] args) {

        Main ren = new Main();
        ren.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ren.setBounds(700,350,930,510);
        ren.setVisible(true);
        ren.setResizable(true);
        ren.setLocationRelativeTo(null);
    }
}
