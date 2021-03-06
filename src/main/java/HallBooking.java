import net.minidev.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class HallBooking extends JFrame implements ActionListener {
    private JPanel panel1;
    private JLabel HALLBOOKINGSLabel;
    private JButton bookButton;
    private JButton updateButton;
    private JButton viewAllBookingsButton;
    private JButton deleteButton;
    private JTextArea textArea1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton searchButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField txtid;
    private JTextField name;

    public HallBooking() {
        super("HALL BOOKING OPTIONS");

        add(panel1);

        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        bookButton.addActionListener(this);
        searchButton.addActionListener(this);
        viewAllBookingsButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateButton)
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
//            else if(!textField3.getText().matches("[0-9]+"))
//            {
//                JOptionPane.showMessageDialog(null, "Amount should only consist of numbers");
//            }
            else {
                String id = textField4.getText();
                String name = textField3.getText();

                ClientClass clientClass = new ClientClass();
                String message = "http://localhost:8080/hallBooking/update";
                String result = "";
                try {
                    JSONObject json = new JSONObject();
                    json.put("hallBookId", id);
                    json.put("eventType", name);

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
                String message = "http://localhost:8080/hallBooking/read/" + id;
                textArea1.setText("hallBookId:           " + "evenType:\n");
                try {
                    Map result = clientClass.read(message);
                    textArea1.append(result.get("hallBookId").toString() + "           "+result.get("eventType").toString());
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
        if (e.getSource() == deleteButton)
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
            else{
            String id = textField1.getText();

            ClientClass clientClass = new ClientClass();
            String message = "http://localhost:8080/hallBooking/delete/"+id;

            try {
                clientClass.delete(message);

                textField1.setText("");
                JOptionPane.showMessageDialog(null, "Successfully deleted");
            } catch (IOException e1) {
                e1.printStackTrace();
            }}
        }
        if (e.getSource() == bookButton) {

                if(txtid.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter an id");
                }
                else if(!txtid.getText().matches("[0-9]+"))
                {
                    JOptionPane.showMessageDialog(null, "Id should only consist of numbers");
                }
                else if(name.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a name");
                }
//                else if(!name.getText().matches("[0-9]+"))
//                {
//                    JOptionPane.showMessageDialog(null, "Amount should only consist of numbers");
//                }
                else
                {
                    String id = txtid.getText();
                    String amount = name.getText();

                    ClientClass clientClass = new ClientClass();
                    String message = "http://localhost:8080/hallBooking/create";
                    String result="";
                    try
                    {
                        JSONObject json = new JSONObject();
                        json.put("hallBookId", id);
                        json.put("eventType", amount);

                        System.out.println(json);
                        result = clientClass.postTo(message, json);

                        txtid.setText("");
                        name.setText("");

                    }
                    catch (Exception e1)
                    {
                        e1.printStackTrace();
                    }
                    //System.out.println(result);
                    JOptionPane.showMessageDialog(null,"Successfully saved");
                }
        }
        if (e.getSource() == viewAllBookingsButton) {
            ClientClass clientClass = new ClientClass();
            String message = "http://localhost:8080/hallBooking/getAll";

            try {
                List result = clientClass.getAll(message);

                for (int i = 0; i< result.size(); i++)
                {
                    textArea1.setText(result.get(i).toString());
                }


//                JSONObject jsonObject = new JSONObject();
//                ArrayList<String> array = new ArrayList<>();

//                for(int i = 0; i<result.size(); i++)
//                {
//                Gson gson = new Gson();
//
//                Type type = new TypeToken<List<String>>(){}.getType();
//                List<String> list = gson.fromJson(result, type);
//                JsonParser jsonParser = new JsonParser();
//                JsonArray array = jsonParser.parse(result).getAsJsonArray();

//                ArrayList arraylist = gson.fromJson(array, ArrayList.class);
//                ObjectMapper map = new ObjectMapper();
//                ArrayList<String> list = new ArrayList<String>();
//
//
//                for (int i = 0; i< list.size(); i++)
//                {
//                    textArea1.setText(String.valueOf(i));
//                }


            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }

    public static void main (String[] args)
    {
        HallBooking ren = new HallBooking();
        ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ren.setBounds(700,350,650,210);
        ren.setVisible(true);
        ren.setResizable(true);
        ren.setLocationRelativeTo(null);
    }

}
