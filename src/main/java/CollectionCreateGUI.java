import jdk.nashorn.internal.parser.JSONParser;
import net.minidev.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class CollectionCreateGUI extends JFrame implements ActionListener
{
    private JButton saveButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel main;
    private Object Collection;

    public CollectionCreateGUI()
    {
        super("Insert Collection");

        add(main);

        saveButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == saveButton)
        {
            if(textField1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter an id");
            }
            else if(!textField1.getText().matches("[0-9]+"))
            {
                JOptionPane.showMessageDialog(null, "Id should only consist of numbers");
            }
            else if(textField2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter an amount");
            }
            else if(!textField2.getText().matches("[0-9]+"))
            {
                JOptionPane.showMessageDialog(null, "Amount should only consist of numbers");
            }
            else
            {
                String id = textField1.getText();
                String amount = textField2.getText();

                ClientClass clientClass = new ClientClass();
                String message = "http://localhost:8080/collection/create";
                String result="";
                try
                {
                    JSONObject json = new JSONObject();
                    json.put("collectId", id);
                    json.put("collectAmt", amount);

                    System.out.println(json);
                    result = clientClass.postTo(message, json);

                    textField1.setText("");
                    textField2.setText("");

                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
                //System.out.println(result);
                JOptionPane.showMessageDialog(null,"Successfully saved");
            }
    }
    }

    public static void main (String[] args)
    {
        CollectionCreateGUI ren = new CollectionCreateGUI();
        ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ren.setBounds(700,350,350,210);
        ren.setVisible(true);
        ren.setResizable(true);
        ren.setLocationRelativeTo(null);
    }
}
