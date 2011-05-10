/**
 * Jack allows you to make basic GET and POST HTTP requests.
 * 
 * @author Ethan Turkeltaub
 * @version 0.1.0
 */
import java.net.*;
import java.io.*;

public class Jack
{
    // Instance variables.
    private String out;
    private String[] parameters;
    
    /**
     * Constructor for the objects of class Jack.
     */
    public Jack()
    {
        
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
     * @param  parameters[]  What you want to send in the POST request.
     * @return               void
     */
    public void post(String url, String args) throws Exception
    {
        try
        {
            URL input = new URL(url);
            URLConnection connection = input.openConnection();
            connection.setDoOutput(true);
            
            OutputStreamWriter post = new OutputStreamWriter(connection.getOutputStream());
            post.write(args);
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
}