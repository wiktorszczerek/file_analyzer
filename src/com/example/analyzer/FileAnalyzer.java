package com.example.analyzer;

import java.io.*;

public class FileAnalyzer {
    public static void main(String[] args)
    {
        boolean desiredFile = false;
        if(args.length!=3)
        {
            System.out.println("Usage: java FileAnalyzer file.sth \"%TOFIND\" \"To print if success\"");
        }
        else
        {
            try
            {
                byte buffer = -2;
                FileInputStream file = new FileInputStream(args[0]);
                byte[] pattern = args[1].getBytes();
                int counter = 0;

                while((buffer=(byte)file.read())!=-1)
                {
                    if(buffer == pattern[counter])
                    {
                        counter++;
                    }
                    else counter = 0;
                    if(counter == pattern.length)
                    {
                        desiredFile = true;
                        break;
                    }
                }
            }
            catch(IOException e)
            {
                System.out.println("Cannot read data. File may not exist");
            }
            if(desiredFile)
            {
                System.out.println(args[2]);
            }
            else System.out.println(Constants.MSG_UNKNOWN_TYPE);
        }
    }
}
