import java.net.*;
import java.io.*;
import java.util.*;

import org.apache.commons.codec.binary.Base64;

/**
 * Allows for authentication to work with Jack.
 * 
 * @author Ethan Turkeltaub 
 * @version 0.1.0
 */
public class Authenticator {
    private String credentials;
    
    /**
     * Create a basic authenticator that takes a URLConnection, a username, and a password.
     */
    public Authenticator(URLConnection connection, String username, String password) {
        credentials = username + ":" + password;
        
        byte[] creds = credentials.getBytes();
        Base64 base64 = new Base64(true);
        credentials = base64.encodeBase64String(creds);
        
        connection.setRequestProperty("Authorization", "Basic " + credentials);
    }
}
