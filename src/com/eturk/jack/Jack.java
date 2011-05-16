 

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
    /*
     * Temporary instance variable for the output of a request.
     */
    private String out;
    
    /*
     * Temporary instance variable for the parameters of a POST or PUT request.
     */
    private String params;
    
    /**
     * Constructor for Jack. You don't need to supply anything.
     */
    public Jack()
    {
        params = "";
    }
    
    /**
     * Make GET requests.
     * 
     * @param   url   The URL you want to make a GET request of.
     * @return        static
     */
    public void get(String url)
    {   
        /*
         * If there isn't an exception, make the connection.
         */
        try
        {
            /*
             * Make the connection (make a URL, open the connection).
             */
            URL input = new URL(url);
            URLConnection connection = input.openConnection();
            BufferedReader get = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            /*
             * Try and print the output.
             */
            while((out = get.readLine()) != null)
            {
                System.out.println(out);
            }
            
            /*
             * Close the connection.
             */
            get.close();
        }
        
        /*
         * If there is an exception, print the error.
         */
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
     * @return               
     */
    public void post(String url, String[] parameters)
    {
        /*
         * Loop through the elements of the array of parameters, adding an "&" after each of them (except the last).
         */
        for(int i = 0; i < parameters.length; i = i + 1) // For arrays, length isn't a method.
        {
            params = params + parameters[i] + "&";
        }
        
        /*
         * Get the length of the parameters and take the last character off (in this case, it'll be "&").
         */
        int len = params.length(); // For strings, length IS a method. What in the hell...
        params = params.substring(0, len - 1);
        
        /*
         * If there isn't an exception, make the connection.
         */
        try
        {
            /*
             * Make the connection (make a URL, open the connection).
             */
            URL input = new URL(url);
            URLConnection connection = input.openConnection();
            connection.setDoOutput(true);
            
            /*
             * Make the actual request, with the parameters.
             */
            OutputStreamWriter post = new OutputStreamWriter(connection.getOutputStream());
            post.write(params);
            post.flush();
            
            /*
             * Get the server's response to the post request.
             */
            BufferedReader get = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((out = get.readLine()) != null) {
                System.out.println(out);
            }
            
            /*
             * Close both connections.
             */
            post.close();
            get.close();
        }
        
        /*
         * If there is an exception, print the error.
         */
        catch(Exception e)
        {
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
    public void put(String url, String[] parameters)
    {
        /*
         * Loop through the elements of the array of parameters, adding an "&" after each of them (except the last).
         */
        for(int i = 0; i < parameters.length; i = i + 1) // For arrays, length isn't a method.
        {
            params = params + parameters[i] + "&";
        }
        
        /*
         * Get the length of the parameters and take the last character off (in this case, it'll be "&").
         */
        int len = params.length(); // For strings, length IS a method. What in the hell...
        params = params.substring(0, len - 1);
        
        /*
         * If there isn't an exception, make the connection.
         */
        try
        {
            /*
             * Make the connection.
             */
            URL input = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) input.openConnection(); // Must use HttpURLConnection instead of URLConnection.
            connection.setDoOutput(true);
            
            /*
             * Make it a PUT request (instead of GET, the default)
             */
            connection.setRequestMethod("PUT");
            
            /*
             * Make the actual request.
             */
            OutputStreamWriter put = new OutputStreamWriter(connection.getOutputStream());
            put.write(params);
            put.flush();
            
            /*
             * Get the server's response to the request.
             */
            BufferedReader get = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((out = get.readLine()) != null) {
                System.out.println(out);
            }
            
            /*
             * Close the connection.
             */
            put.close();
            get.close();
        }
        
        /*
         * If there was an exception, catch it.
         */
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Make DELETE requests. DELETE doesn't take parameters, as explained <a href="http://is.gd/eB2QkL">here</a>.
     * 
     * @param  url           The URL you want to make a PUT request of.
     * @return               void
     */
    public void delete(String url)
    {
        /*
         * If there wasn't an exception, try and make the connection.
         */
        try
        {
            /*
             * Make the connection.
             */
            URL input = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) input.openConnection(); // Must use HttpURLConnection instead of URLConnection.
            connection.setDoOutput(true);
            
            /*
             * Make it a DELETE request (instead of GET, the default)
             */
            connection.setRequestMethod("DELETE");
            
            /*
             * Get the server's response to the request.
             */
            BufferedReader get = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((out = get.readLine()) != null) {
                System.out.println(out);
            }
            
            /*
             * Close the connection.
             */
            get.close();
        }
        
        /*
         * If there was an exception, catch it.
         */
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}