package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {

    public Profile getDataFromFile(File file){
        Profile profile=new Profile();
        try(FileInputStream f=new FileInputStream(file);){

            int c;
            StringBuilder s = new StringBuilder("");
            while ((c = f.read()) != -1) {
                s.append((char) c);

            }
            String a=new String(s);
            a=a.replace(":"," ");
            a = a.replace("\n", " ");
            s=new StringBuilder(a);
            ArrayList<String> b = new ArrayList<>();
            for (String h : (a.split(" "))) {
                if (!h.isEmpty())
                    b.add(h.trim());
            }

            if (b.size() == 8) {

                profile.setAge(Integer.parseInt(b.get(3)));
                profile.setName(b.get(1));
                profile.setPhone(Long.parseLong(b.get(7)));
                profile.setEmail(b.get(5));

            }

        }catch (Exception e){
            Logger logger=Logger.getLogger(FileReader.class.getName());
            logger.log(Level.WARNING,"This is important!");
        }
    return profile;
    }

}
