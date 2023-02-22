package org.example;
import java.net.*;
import java.io.*;

public class KleinerServer {
		ServerSocket server = new ServerSocket (1234);
		
		KleinerServer(int i) throws IOException{
			while (true) {
				Socket client = server.accept();
				InputStream input = client.getInputStream();
				OutputStream output = client.getOutputStream();
				
				
				int op = input.read();
				int zahl1 = input.read();
				int zahl2 = input.read();
				int zahl3 = input.read();
				int zahl4 = input.read();
				
				if(op == 11) {
					output.write(zahl1 + zahl2 + zahl3 + zahl4);
				}
				else if(op == 22) {
					output.write(zahl1 - zahl2 - zahl3 - zahl4);
				}
				else if(op == 33) {
					output.write(zahl1 * zahl2 * zahl3 * zahl4);
				}
				
				output.flush();
				input.close();
				output.close();			
			}
		}
	
		
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			KleinerServer server = new KleinerServer(1);
		}
	
		catch (IOException e) {
			System.out.println(e);
		}
		}
		

}
