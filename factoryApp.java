package app;

public class factoryApp {
	public factoryApp(String[] args) {
		String mode = "enc";
		String text = null;
		String in = null;
		String out = null;
		String alg = "shift";
		int key = 0;
		for (int x = 0; x < args.length; x++){
			if (args[x].equals("-mode")){
				mode = args[x+1];
			}else if(args[x].equals("-key")){
				key = Integer.parseInt(args[x+1]);
	        }else if(args[x].equals("-data")){
	            text = args[x+1];
	        }else if (args[x].equals("-in")){
	        	in = args[x+1];
	        }else if (args[x].equals("-out")){
	        	out = args[x+1];
	        }else if (args[x].equals("-alg")){
	        	alg = args[x+1];
	            }
	        }
		if (alg.equals("shift")) {
			tap x = new ShiftingMethod();
			if (mode.equals("enc")) {
				x.encrypt(key, text, in, out);
				
			}else if(mode.equals("dec")) {
				x.decrypt(key, text, in, out);
			}
		}else if(alg.equals("encode")) {
			tap x = new EncodeMethod();
			if(mode.equals("enc")) {
				x.encrypt(key, text, in, out);
			}else if(mode.equals("dec")) {
				x.decrypt(key, text, in, out);
			}
		}
		
	 }
		
}

