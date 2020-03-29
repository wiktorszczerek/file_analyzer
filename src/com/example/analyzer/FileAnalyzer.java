package com.example.analyzer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAnalyzer {
    public static void main(String[] args)
    {
        if(args.length!=3)
        {
            System.out.println("Usage: java FileAnalyzer file.sth \"%TOFIND\" \"To print if success\"");
        }
        else
        {
            try
            {
                byte[] byteArray = Files.readAllBytes(Paths.get(args[0]));
                if(checkIfPatternOccurs(byteArray,args[1].getBytes()))
                {
                    System.out.println(args[2]);
                }
                else System.out.println("This is not a file you're looking for");
            }
            catch(IOException e)
            {
                System.out.println("Cannot read data. File may not exist");
            }
        }
    }

    public static boolean checkIfPatternOccurs(byte[] arr,byte[] pattern)
    {
        int counter = 0;
        for(byte x:arr)
        {
            if(x == pattern[counter])
            {
                counter++;
            }
            else counter = 0;
            if(counter == pattern.length) break;
        }
        return counter == pattern.length;
    }
}
