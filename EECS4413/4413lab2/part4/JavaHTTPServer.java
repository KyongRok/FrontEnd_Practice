import javax.sound.sampled.Port;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class JavaHTTPServer {

	static final String DEFAULT_FILE = "index.html";
	static final String FILE_NOT_FOUND = "404.html";
	static final String METHOD_NOT_SUPPORTED = "no_support.html";
	static final String WEB_ROOT = "/Users/kyongrokkim/Desktop/EECS4413/4413lab2/part4";
	//please change WEB_ROOT to the directory of the files for part4
	// port to listen HTTP connection
	static final int PORT = 8080;

	public static void main(String[] args) throws Exception {

		ServerSocket serverConnect = new ServerSocket(PORT);

		System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");

		// we listen until user halts server execution

		while (true) {
			Socket clientSocket = serverConnect.accept();

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			OutputStream out1 = clientSocket.getOutputStream();

			String inputline = in.readLine();
			System.out.println((inputline));
			StringTokenizer parse = new StringTokenizer(inputline);
			String method = parse.nextToken().toUpperCase();
			String filerequested = parse.nextToken().toLowerCase();

			if (!(method.equals("GET")) && !(method.equals("HEAD"))) {
				System.out.println("501 NOT IMPLEMENTED : " + method + "method.");

				File file = new File(WEB_ROOT, METHOD_NOT_SUPPORTED);
				int filelength = (int) file.length();
				String contenttype = "text/html";

				out.println("HTTP/1.1 501 Not Implemnted");
				out.println("Date: " + new Date());
				out.println("Content-Type: " + contenttype);
				out.println("Content-Length: " + filelength);
				out.println();
				out.flush();

				BufferedReader rf = new BufferedReader(new FileReader(file));
				String line;
				while((line=rf.readLine()) != null){
					out.println(line);
					out.flush();
				}
			}else{
				if(filerequested.endsWith("/")){
				filerequested += DEFAULT_FILE;
				}
				File file = new File(WEB_ROOT , filerequested);
				if(!file.exists()){
					file = new File(WEB_ROOT , FILE_NOT_FOUND);
					int filelength = (int) file.length();
					String contenttype = "text/html";

					out.println("HTTP/1.1 404 Not Found");
					out.println("Date: " + new Date());
					out.println("Content-Type: " + contenttype);
					out.println("Content-Length: " + filelength);
					out.println();
					out.flush();

					BufferedReader rf = new BufferedReader(new FileReader(file));
					String line;
					while((line=rf.readLine()) != null){
						out.println(line);
						out.flush();
					}
				}else{
					int filelength = (int) file.length();
					String content = getContentType(filerequested);
					
					out.println("HTTP/1.1 200 OK");
					out.println("Date: " + new Date());
					out.println("Content-Type: " + content);
					out.println("Content-Length: " + filelength);
					out.println();
					out.flush();

					if(method.equals("GET")){

						BufferedReader rf = new BufferedReader(new FileReader(file));
						String line;
						while((line=rf.readLine()) != null){
							out.println(line);
							out.flush();
						}
					}
				}
				
			}
		}

	}

	private static String getContentType(String filerequested) {
		return null;
	}

}