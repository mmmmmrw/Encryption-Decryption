package app;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EncodeMethod extends tap{

	@Override
	void decrypt(int key, String text, String in, String out) {
		String textSource = null;
		if ((in==null) || (in!=null) && (text!=null)){
			textSource = text;
		}else if(in!=null && text==null){
			try {
			textSource = readFile(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			textSource = null;
		}
//////////////////////////////////////////////////////////
		char phrase[] = textSource.toCharArray();

        String newStr="";
        for (char kar: phrase){
            int appended = kar-key;
            if(appended > 31 ){
                newStr+= (char)appended;
            }else {
                int temp = 31-appended;
                appended = 128-temp;
                newStr += (char)appended;
            }
        }
  
    	if(out==null) {
    		System.out.println(newStr);
    	}else {
    		try {
				writeToFile(out, newStr);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}//////////////////////////////////////////////////////////
        
	}

	@Override
	void encrypt(int key, String text, String in, String out) {
		String textSource = null;
		if ((in==null) || (in!=null) && (text!=null)){
			textSource = text;
		}else if(in!=null && text==null){
			try {
			textSource = readFile(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			textSource = null;
		}
//////////////////////////////////////////////////////////
		char phrase[] = textSource.toCharArray();

        String newStr="";
        for (char kar: phrase){
            int appended = kar+key;
            if(appended < 128){
                newStr+= (char)appended;
            }else {
                appended = appended % 128 + 32;
                newStr += (char)appended;
            }
        }
    	if(out==null) {
    		System.out.println(newStr);
    	}else {
    		try {
				writeToFile(out, newStr);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}//////////////////////////////////////////////////////////
        
	}
		
	}




