package com.eturk.jack;

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
public class Authenticator
{
    /*
     * Instance variables.
     */
    private String credentials;
    
    /**
     * Constructor.
     */
    public Authenticator(URLConnection connection, String username, String password)
    {
        /*
         * Concatenate.
         */
        credentials = username + ":" + password;
        
        /*
         * Encode in Base64.
         */
        byte[] creds = credentials.getBytes();
        Base64 base64 = new Base64(true);
        credentials = base64.encodeBase64String(creds);
        
        /*
         * Send to server.
         */
        connection.setRequestProperty("Authorization", "Basic " + credentials);
    }
}
