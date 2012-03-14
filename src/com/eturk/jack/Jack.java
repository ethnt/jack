/**
 * Jack allows you to make basic HTTP requests.
 * 
 * @author Ethan Turkeltaub
 * @version 0.1.0
 */

import java.net.*;
import java.io.*;
import java.util.*;

public class Jack {
    private String out;
    private String params;
    private boolean authenticated;
    private String username;
    private String password;
    
    /**
     * Constructor for Jack. You don't need to supply anything if you're not using basic authentication.
     */
    public Jack() {
        params = "";
        authenticated = false;
    }
    
    /**
     * Constructor for Jack. Supply username and password if you're using basic authentication.
     */
    public Jack(String user, String pass) {
        params = "";
        authenticated = true;
        username = user;
        password = pass;
    }
     
    /**
     * Make GET requests.
     * 
     * @param   url   The URL you want to make a GET request of.
     * @return        void
     */
    public void get(String url) {
        try {
            URL input = new URL(url);
            URLConnection connection = input.openConnection();
            
            if (authenticated) {
                Authenticator authenticator = new Authenticator(connection, username, password);
            }
            
            BufferedReader get = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            while ((out = get.readLine()) != null) {
                System.out.println(out);
            }
            
            get.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Make POST requests.
     * 
     * @param  url           The URL you want to make a POST request of.
     * @param  parameters    An array of parameters to send with the POST request. An element would be, for example, "width=50", and another will be 
     *                       "height=50". This will send "width=50&height=50".
     * @return               
     */
    public void post(String url, String[] parameters) {
        for (int i = 0; i < parameters.length; i = i + 1) {
            params = params + parameters[i] + "&";
        }
        
        params = params.substring(0, params.length() - 1);
        
        try {
            URL input = new URL(url);
            URLConnection connection = input.openConnection();
            connection.setDoOutput(true);
            
            OutputStreamWriter post = new OutputStreamWriter(connection.getOutputStream());
            post.write(params);
            post.flush();
            
            BufferedReader get = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((out = get.readLine()) != null) {
                System.out.println(out);
            }
            
            post.close();
            get.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Make PUT requests.
     * 
     * @param  url           The URL you want to make a PUT request of.
     * @param  parameters    An array of parameters to send with the PUT request. An element would be, for example, "width=50", and another will be 
     *                       "height=50". This will send "width=50&height=50".
     * @return               void
     */
    public void put(String url, String[] parameters) {
        for (int i = 0; i < parameters.length; i = i + 1) {
            params = params + parameters[i] + "&";
        }

        params = params.substring(0, params.length() - 1);
        
        try {
            URL input = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) input.openConnection(); // Must use HttpURLConnection instead of URLConnection.
            connection.setDoOutput(true);
            
            connection.setRequestMethod("PUT");
            
            OutputStreamWriter put = new OutputStreamWriter(connection.getOutputStream());
            put.write(params);
            put.flush();
            
            BufferedReader get = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((out = get.readLine()) != null) {
                System.out.println(out);
            }
            
            put.close();
            get.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Make DELETE requests. DELETE doesn't take parameters, as explained <a href="http://is.gd/eB2QkL">here</a>.
     * 
     * @param  url           The URL you want to make a PUT request of.
     * @return               void
     */
    public void delete(String url) {
        try {
            URL input = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) input.openConnection(); // Must use HttpURLConnection instead of URLConnection.
            connection.setDoOutput(true);
            
            connection.setRequestMethod("DELETE");
            
            BufferedReader get = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((out = get.readLine()) != null) {
                System.out.println(out);
            }
            
            get.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}