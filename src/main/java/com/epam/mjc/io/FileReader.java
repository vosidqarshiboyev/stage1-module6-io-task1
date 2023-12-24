package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;



public class FileReader {

    public Profile getDataFromFile(File file) throws IOException{
        FileInputStream f=null;
        Profile profile=new Profile();
        try {
            f=new FileInputStream(file);
            int c;
            String s="";
            while((c=f.read())!=-1){
                s=s+(char)c;

            }
            s=s.replace(":"," ");
            s=s.replace("\n"," ");
            ArrayList <String>a=new ArrayList<>();
            for (String b:(s.split(" "))){
                if(!b.isEmpty())
                    a.add(b.trim());
            }

            if(a.size()==8) {

                profile.setAge(Integer.parseInt(a.get(3)));
                profile.setName(a.get(1));
                profile.setPhone(Long.parseLong(a.get(7)));
                profile.setEmail(a.get(5));

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            assert f != null;
            f.close();
        }

    return profile;
    }

}
