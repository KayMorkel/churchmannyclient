import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.*;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ClientClass {

    public static void main(String[] args) throws Exception {
        ClientClass clientClass = new ClientClass();
        try {
            clientClass.get();
            System.out.println("get request is okay");
        } catch (Exception e) {
            e.getMessage();
        }

        ChurchMannyHome ren = new ChurchMannyHome();
        ren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ren.setBounds(700, 350, 650, 430);
        ren.setVisible(true);
        ren.setResizable(true);
        ren.setLocationRelativeTo(null);
    }

    public void get() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet("http://localhost:8080/");

        try (CloseableHttpResponse getResponse = client.execute(getRequest))
        {
            System.out.println(getResponse.getStatusLine().toString());
            HttpEntity getEntity = getResponse.getEntity();

            if (getEntity != null) {
                String results = EntityUtils.toString(getEntity);
                System.out.println(results);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            client.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List getAll(String message)
    {
        HttpGet request = new HttpGet(message);
        String results = "";
        Map map = null;
        List list = null;
        CloseableHttpClient clientGet = HttpClients.createDefault();
        //HttpGet getRequest = new HttpGet("http://localhost:8080/");

        try (CloseableHttpResponse getResponse = clientGet.execute(request))
        {
            System.out.println(getResponse.getStatusLine().toString());
            HttpEntity getEntity = getResponse.getEntity();

            if (getEntity != null)
            {
                results = EntityUtils.toString(getEntity);
                ObjectMapper mapper = new ObjectMapper();
                list = mapper.readValue(results, List.class);

                //                ArrayList arrayList = new ArrayList();
//                for(int i=0;i < map.size();i++){
//                    arrayList.add(map.get(i));
//
//                }
                System.out.println(list.get(1));
//
                //results = "data is returning";
                System.out.println(results);
            }
            else results = "Nothing in database";
        }
        catch (Exception e) {
            e.getMessage();
        }

        return list;
    }

    public String postTo(String url, Object obj)
    {
        String result="";
        try {
            CloseableHttpClient clientPost = HttpClients.createDefault();
            HttpPost postTo = new HttpPost(url);
            StringEntity toPost = new StringEntity(obj.toString());
            toPost.setContentType("application/json; charset=UTF-8");
            postTo.setEntity(toPost);

            HttpResponse postResponse = clientPost.execute(postTo);

            result = postResponse.getEntity().getContent().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Map read(String message) throws IOException
    {
        HttpGet request = new HttpGet(message);
        String results = "";
        Map map = null;
        CloseableHttpClient clientGet = HttpClients.createDefault();
        //HttpGet getRequest = new HttpGet("http://localhost:8080/");

        try (CloseableHttpResponse getResponse = clientGet.execute(request))
        {
            System.out.println(getResponse.getStatusLine().toString());
            HttpEntity getEntity = getResponse.getEntity();

            if (getEntity != null)
            {
                results = EntityUtils.toString(getEntity);
                ObjectMapper mapper = new ObjectMapper();
                map = mapper.readValue(results, Map.class);
                //                array = mapper.readValue(results, ArrayList.class);
                //results = "data is returning";
                //System.out.println(map.size());
            }
        }
        catch (Exception e) {
            e.getMessage();
        }

        return map;
    }
    public void update(String url, Object obj)
    {
        String result="";
        try {
            CloseableHttpClient clientPost = HttpClients.createDefault();
            HttpPost postTo = new HttpPost(url);
            StringEntity toPost = new StringEntity(obj.toString());
            toPost.setContentType("application/json; charset=UTF-8");
            postTo.setEntity(toPost);

            HttpResponse postResponse = clientPost.execute(postTo);

            result = postResponse.getEntity().getContent().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void delete(String message) throws IOException {
        CloseableHttpClient clientPost = HttpClients.createDefault();
        HttpGet httpDelete = new HttpGet(message);
        HttpResponse response = clientPost.execute(httpDelete);

        if(response == null)
        {

        }
    }
}

