package app;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ShiftingMethod extends tap {

	@Override
	void encrypt(int key, String text, String in, String out) {
		// TODO Auto-generated method stub
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
		
		
		char phrase[] = textSource.toLowerCase().toCharArray();
		String letters = "abcdefghijklmnopqrstuvwxyz";
	    char[] let = letters.toCharArray();
	    String newStr ="";
	    //////////////////////////////////////////////////////////////
	    for (char car : phrase) {
	    	if(check(let, car)) {
		    	//قيمة مفتاح الحرف بعد اضافة قيمة التغيير
		    	int carIndex = letters.indexOf(car)+ key;
		    	//تفقد اذا ما كان المفتاح أكبر من طول مصفوفة الاحرف
		    	if (carIndex > letters.length()) {
		    		//اذا كان اكبر من طول مصفوفة الاحرف القيمة الجديدة تحمل قيمة المفتاح ناقص طول المصفوفة
		    		carIndex = carIndex - letters.length();
		    	}
		    	newStr+=letters.charAt(carIndex);
	    		
	    	}else {
	    		newStr+=car;
	    	}

	    }    
	    /////////////////////////////////////////////////////////////		        
    	if(out==null) {
    		System.out.println(newStr);
    	}else {
    		try {
				writeToFile(out, newStr);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
}

		
	

	@Override
	void decrypt(int key, String text, String in, String out) {
		// TODO Auto-generated method stub
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
		
		
		char phrase[] = textSource.toLowerCase().toCharArray();
		String letters = "abcdefghijklmnopqrstuvwxyz";
	    char[] let = letters.toCharArray();
	    String newStr ="";
	    //////////////////////////////////////////////////////////////
	    for (char car : phrase) {
	    	if(check(let, car)) {
	    		//System.out.println("index of "+car+" is "+ letters.indexOf(car));
		    	int carIndex = letters.indexOf(car)- key;
		    	//System.out.println(carIndex);
		    	if (carIndex < 0) {
		    		carIndex =  letters.length() + carIndex;
		    		System.out.println(carIndex);
		    	}
		    	newStr+=letters.charAt(carIndex);
	    		
	    	}else {
	    		newStr+=car;
	    	}

	    }    
	    /////////////////////////////////////////////////////////////		        
    	if(out==null) {
    		System.out.println(newStr);
    	}else {
    		try {
				writeToFile(out, newStr);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	}

	 
    private boolean check(char[] arr, int toCheckValue) { 
        // check if the specified element 
        // is present in the array or not 
        // using Linear Search method 
        boolean test = false; 
        for (char element : arr) { 
            if (element == toCheckValue) { 
                test = true; 
                break; 
            } 
        }
        return test;

    } 
  
	
}


