package org.aufgabe2;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

	Client () throws IOException {
		Socket server = new Socket ("localhost", 1234);
		InputStream input = server.getInputStream();
		OutputStream output = server.getOutputStream();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welche Operation soll ausgeführt werden?: 11: Add || 22: Sub || 33: Mult");
		int operation = sc.nextInt();
		output.write(operation);
		int[] nums = new int[4];
		for(int i = 0; i< 4; i++){
			System.out.println("Geben sie die " + i +1  + ". Zahl ein");
			nums[i] = sc.nextInt();
			output.write(nums[i]);
		}
		sc.close();
		output.flush();
		System.out.println(input.read());
		server.close();
		input.close();
		output.close();
	}
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			Client client = new Client();		
		}
	catch (IOException e) {
		System.out.println(e);
	}
	}

}
