package github.mbaehr.webuiforjava;

import java.io.IOException;

public class BrowserUILoader {
	
    public static void loadBrowserUI(String url) {
    	
    	String os = System.getProperty("os.name");
    	System.out.println("Running on: " + os);
    	String command = "";
    	if(os.contains("Windows")) {
    		command = "rundll32 url.dll,FileProtocolHandler " + url;
    	} else {
    		command = "xdg-open " + url;
    	}
    	
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}