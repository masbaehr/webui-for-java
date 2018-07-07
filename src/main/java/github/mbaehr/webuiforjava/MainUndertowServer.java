package github.mbaehr.webuiforjava;

import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

import io.undertow.Undertow;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class MainUndertowServer {
	
	/*
	 * Creating HttpHandlers as a method and passing it as a method reference is pretty clean.
	 * This also helps reduce accidentally adding state to handlers.
	 */
	public static void reqHandler(HttpServerExchange exchange) throws Exception {
	    
	    //handle resource request
	    if(exchange.getRequestPath().endsWith(".css")  || exchange.getRequestPath().endsWith(".js")){	
	    	  if(exchange.getRequestPath().endsWith(".css")) {
	    		  exchange.getResponseHeaders().add(Headers.CONTENT_TYPE, "text/css");
	    	  }
	    	  if(exchange.getRequestPath().endsWith(".js")) {
	    		  exchange.getResponseHeaders().add(Headers.CONTENT_TYPE, "application/javascript");
	    	  }
	    	  InputStreamReader in = new InputStreamReader(MainUndertowServer.class.getResourceAsStream(exchange.getRequestPath()), "UTF-8");
	    	  String message = IOUtils.toString(in);
			  in.close();
			  exchange.getResponseSender().send(message);
			  return;
	    }
	   
	    //handle page request
	    String page = "/app.html";
	    exchange.getResponseHeaders().add(Headers.CONTENT_TYPE, "text/html");
	   
		InputStreamReader in = new InputStreamReader(MainUndertowServer.class.getResourceAsStream(page), "UTF-8");
		String message = IOUtils.toString(in);
		in.close();
		exchange.getResponseSender().send(message);
	 
	}
	
	public static void main(String[] args) {
		//start embedded http server
	    int port = 8085;
	    String host = "localhost";//0.0.0.0
	    Undertow server = Undertow.builder().addHttpListener(port, host, MainUndertowServer::reqHandler).build();
	    server.start();
	    //load UI
	    BrowserUILoader.loadBrowserUI("http://" + host + ":" + port);
	}
}

