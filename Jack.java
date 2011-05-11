/**
 * Jack allows you to make basic HTTP requests.
 * 
 * @author Ethan Turkeltaub
 * @version 0.1.0
 */
import java.net.*;
import java.io.*;

public class Jack
{
    /**
     * Temporary instance variable for the output of a request.
     */
    private String out;
    
    /**
     * Temporary instance variable for the parameters of a POST or PUT request.
     */
    private String params;
    
    /**
     * Constructor for the objects of class Jack.
     */
    public Jack()
    {
        params = "";
    }
    
    /**
     * Make GET requests.
     * 
     * @param   url   The URL you want to make a GET request of.
     * @return        void
     */
    public void get(String url) throws Exception
    {   
        try
        {
            URL input = new URL(url);
            URLConnection connection = input.openConnection();
            BufferedReader get = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            while((out = get.readLine()) != null)
            {
                System.out.println(out);
            }
            get.close();
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Make POST requests.
     * 
     * @param  url           The URL you want to make a POST request of.
     * @param  parameters    An array of parameters to send with the POST request. An element would be, for example, "width=50", and another will be 
     *                       "height=50". This will send "width=50&height=50".
     * @return               void
     */
    public void post(String url, String[] parameters) throws Exception
    {
        /*
         * Loop through the elements of the array of parameters, adding an "&" after each of them (except the last).
         */
        for(int i = 0; i < parameters.length; i = i + 1) // For arrays, length isn't a method.
        {
            params = params + parameters[i] + "&";
        }
        int len = params.length(); // For strings, length IS a method. What in the hell...
        params = params.substring(0, len - 1);
        
        /*
         * Try and make the connection.
         */
        try
        {
            /*
             * Make the connection.
             */
            URL input = new URL(url);
            URLConnection connection = input.openConnection();
            connection.setDoOutput(true);
            
            /*
             * 
             */
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
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // To-do; authentication, PUT, DELETE...
}