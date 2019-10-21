

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Collections extends JFrame implements ActionListener
{
    private JPanel panel1;
    private JLabel collections;
    private JTextArea textArea1;
    private JButton insertNewCollectionButton;
    private JButton updateCollectionButton;
    private JButton viewAllCollectionsButton;
    private JButton deleteACollectionButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton searchButton;
    private JTextField textField3;
    private JTextField textField4;

    public Collections() {
        super("COLLECTION OPTIONS");

        add(panel1);

        insertNewCollectionButton.addActionListener(this);
        viewAllCollectionsButton.addActionListener(this);
        deleteACollectionButton.addActionListener(this);
        searchButton.addActionListener(this);
        updateCollectionButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateCollectionButton)
        {
            if(textField4.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter an id");
            }
            else if(!textField4.getText().matches("[0-9]+"))
            {
                JOptionPane.showMessageDialog(null, "Id should only consist of numbers");
            }
            else if(textField3.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter an amount");
            }
            else if(!textField3.getText().matches("[0-9]+"))
            {
                JOptionPane.showMessageDialog(null, "Amount should only consist of numbers");
            }
            else {
                String id = textField4.getText();
                String amount = textField3.getText();

                ClientClass clientClass = new ClientClass();
                String message = "http://localhost:8080/collection/update";
                String result = "";
                try {
                    JSONObject json = new JSONObject();
                    json.put("collectId", id);
                    json.put("collectAmt", amount);

                    clientClass.update(message, json);

                    textField4.setText("");
                    textField3.setText("");

                    System.out.println(result);
                    JOptionPane.showMessageDialog(null, "Successfully updated");

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        if(e.getSource() == searchButton)
        {
            if(textField2.getText().equals(""))
            {
                textField2.setText("");
                JOptionPane.showMessageDialog(null,"Please enter an id");
            }
            else if(!textField2.getText().matches("[0-9]+"))
            {
                textField2.setText("");
                JOptionPane.showMessageDialog(null, "ID should only consist of numbers");
            }
            else
                {
                String id = textField2.getText();
                ClientClass clientClass = new ClientClass();
                String message = "http://localhost:8080/collection/read/" + id;
                textArea1.setText("collectId:           " + "collectAmt:\n");
                try {
                    Map result = clientClass.read(message);
                    textArea1.append(result.get("collectId").toString() +"           " +result.get("collectAmt").toString());
                    textField2.setText("");

                }
                catch (NullPointerException npe)
                {
                    textArea1.setText("");
                    textField2.setText("");
                    JOptionPane.showMessageDialog(null, "No such id exists");
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No such id exists");
                }
            }
        }
        if (e.getSource() == deleteACollectionButton)
        {
            if(textField1.getText().equals(""))
            {
                textField1.setText("");
                JOptionPane.showMessageDialog(null,"Please enter an id");
            }
            else if(!textField1.getText().matches("[0-9]+"))
            {
                textField1.setText("");
                JOptionPane.showMessageDialog(null, "ID should only consist of numbers");
            }
            else{String id = textField1.getText();

            ClientClass clientClass = new ClientClass();
            String message = "http://localhost:8080/collection/delete/"+id;

            try {
                clientClass.delete(message);

                textField1.setText("");
                JOptionPane.showMessageDialog(null, "Successfully deleted");
            } catch (IOException e1) {
                e1.printStackTrace();
            }}
        }
        if (e.getSource() == insertNewCollectionButton) {
            CollectionCreateGUI ren = new CollectionCreateGUI();
            ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ren.setBounds(700, 350, 350, 160);
            ren.setVisible(true);
            ren.setResizable(true);
            ren.setLocationRelativeTo(null);
        }
        if (e.getSource() == viewAllCollectionsButton) {
            ClientClass clientClass = new ClientClass();
            String message = "http://localhost:8080/collection/getAll";

            try {
                  List result = clientClass.getAll(message);
//                while (result.containsKey("collectID") && result.containsKey("collectAmt"))
//                {
//                    textArea1.setText(result.get("collectId") + " " + result.get("collectAmt"));
//                }
//  JSONObject jsonObject = new JSONObject();
//                ArrayList<String> array = new ArrayList<>();

//                for(int i = 0; i<result.size(); i++)
//                {
//                Gson gson = new Gson();
//
//                Type type = new TypeToken<List<String>>(){}.getType();
//                List<String> list = gson.fromJson(result, type);
//                JsonParser jsonParser = new JsonParser();
//                JsonArray array = jsonParser.parse(result).getAsJsonArray();

//                ObjectMapper map = new ObjectMapper();
//                ArrayList<String> list = new ArrayList<String>();
//
//
                for (int i = 0; i< result.size(); i++)
                {
                    textArea1.setText(result.get(i).toString());
                }


            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }

    public static void main (String[] args)
    {
        Collections ren = new Collections();
        ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ren.setBounds(700,350,650,210);
        ren.setVisible(true);
        ren.setResizable(true);
        ren.setLocationRelativeTo(null);
    }
}
