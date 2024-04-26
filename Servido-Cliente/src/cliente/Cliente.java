package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
		
	private final String HOST="localhost";
	
	private final int PUERTO=4321;
	 
	private Socket socket;
	
	
	public Cliente() throws IOException{
		
		
		socket=new Socket(HOST,PUERTO);
		
		
		
	}
	
	public void start() throws IOException{
		
		try {
		
		Scanner sc=new Scanner(System.in);
		
		DataInputStream entrada= new DataInputStream(socket.getInputStream());
		DataOutputStream salida=new DataOutputStream(socket.getOutputStream());
		
		
		
		// Recepción y envío de nombre
		
		System.out.println(entrada.readUTF());
		String nombre= sc.next();
		salida.writeUTF(nombre);
		
		
		//Explicacion de procedimiento para la contraseña
		
		System.out.println(entrada.readUTF());
		System.out.println(entrada.readUTF());
		
		
		//Requisito mayusculas
		
		System.out.println(entrada.readUTF());
		int numMayus=sc.nextInt();
		salida.writeInt(numMayus);
		
		//Requisito minusculas
		
		System.out.println(entrada.readUTF());
		int numMinus=sc.nextInt();
		salida.writeInt(numMinus);
		
		//Requisito digitos
		
		System.out.println(entrada.readUTF());
		int numDigitos=sc.nextInt();
		salida.writeInt(numDigitos);
		
		//Requisito caracteres especiales
		
		System.out.println(entrada.readUTF());
		int numCaracteres=sc.nextInt();
		salida.writeInt(numCaracteres);
		
		//Longitud total de la contraseña
		
		System.out.println(entrada.readUTF());
		
		// Recepción y envío de respuesta para generar contraseña
		
		System.out.println(entrada.readUTF());
		String respuesta= sc.next();
		salida.writeUTF(respuesta);
		
		// Recepción del mensaje final del servidor		
		
		System.out.println(entrada.readUTF());
		
		
		// Cierre de flujos y socket
		
		salida.close();
        entrada.close();
        socket.close();

	
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}

	}
		
}
