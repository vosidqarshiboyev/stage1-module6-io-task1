package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException {
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
            System.out.println(s);
            ArrayList <String>a=new ArrayList<>();
            for (String b:(s.split(" "))){
                if(!b.isEmpty())
                    a.add(b.trim());
            }
            for(int i=0;i<a.size();i++){
                System.out.println(a.get(i)+",");
            }
            if(a.size()==8) {
                System.out.println(a.size());
                profile.setAge(Integer.parseInt(a.get(3)));
                profile.setName(a.get(1));
                profile.setPhone(Long.parseLong(a.get(7)));
                profile.setEmail(a.get(5));

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            f.close();
        }

    return profile;
    }

}
