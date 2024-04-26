package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	
	private final int PUERTO=4321;
	private ServerSocket serverSocket;
	private Socket socket;
	
	public Servidor() throws IOException {
		
		serverSocket= new ServerSocket(PUERTO);
		
		socket= new Socket();
		
	}
	
	
	public void interactua() throws IOException {
		
		RequisitosPass requisito=new RequisitosPass();
		ServicioPass servicio= new ServicioPass();
		try
		{
		while(true) {
			
			System.out.println("Servidor arrancado");
			System.out.println("Esperando al cliente...");
			
			// Espera a que un cliente se conecte
			
			socket=serverSocket.accept();
			
			// Informa al servidor sobre la conexión del cliente
			
			System.out.println("Cliente conextado desde "+ socket.getInetAddress());
			
			
			// Creación de flujos de entrada y salida para comunicarse con el cliente
			DataOutputStream mensajeParaCliente= new DataOutputStream(socket.getOutputStream());
			DataInputStream entrada=new DataInputStream(socket.getInputStream());
			
			
			
			
			// Envío de mensaje solicitando el nombre del cliente
			mensajeParaCliente.writeUTF("Hola,soy un servidor,¿Cómo te llamas?");
			
			
			// Recepción del nombre del cliente
			
			String mensajeNuevodeCliente;
			int mensajeIntdeCliente;
			
			mensajeNuevodeCliente= entrada.readUTF();
			System.out.println("Nombre del cliente: " + mensajeNuevodeCliente);
			
			
			// Envío de mensaje de bienvenida al cliente
			mensajeParaCliente.writeUTF("Te doy la bienvenida: "+ mensajeNuevodeCliente);
			
			// Solicitar requisitos para la contraseña
			mensajeParaCliente.writeUTF("Voy a solicitarte distintos requisitos para la constraseña que voy a generar.");
			
			// Recepción de número de mayúsculas
			mensajeParaCliente.writeUTF("¿Cuántas mayúsculas debe tener la contraseña?");
			mensajeIntdeCliente= entrada.readInt();
			requisito.setNumMayusculas(mensajeIntdeCliente);
			
			// Recepción de número de minúsculas
			mensajeParaCliente.writeUTF("¿Cuántas minúsculas debe tener la contraseña?");
			mensajeIntdeCliente= entrada.readInt();
			requisito.setNumMinusculas(mensajeIntdeCliente);
			
			// Recepción de número de dígitos
			mensajeParaCliente.writeUTF("¿Cuántos dígitos debe tener la contraseña?");
			mensajeIntdeCliente= entrada.readInt();
			requisito.setNumDigitos(mensajeIntdeCliente);
			
			
			//Recepción de número de caracteres especiales
			mensajeParaCliente.writeUTF("¿Cuántos caracteres especiales debe tener la contraseña?");
			mensajeIntdeCliente= entrada.readInt();
			requisito.setNumCaractEspeciales(mensajeIntdeCliente);
			
			// Mostrar requisitos del cliente
			System.out.println("Los requisitos del cliente son los siguientes");
			System.out.println(requisito.toString()); 
			

			//La longitud de la contraseña
			mensajeParaCliente.writeUTF("La longitud de la contraseña que se va a generar es de "+ servicio.longitudPass(requisito.getNumMayusculas(),requisito.getNumMinusculas() ,requisito.getNumDigitos() ,requisito.getNumCaractEspeciales()) + " caractares");
			
			System.out.println("Se ha enviado la longitud de la contraseña al cliente");
			
			// Pregunta si el cliente quiere generar una contraseña
			mensajeParaCliente.writeUTF("¿Quieres generar una contraseña ahora? [si/no]");
			mensajeNuevodeCliente=entrada.readUTF();
			 
			 
		 
			 
			 if(mensajeNuevodeCliente.equals("si"))  {
				
				 // Genera la contraseña 
				 String passFinal;
				 
				 passFinal=servicio.generaPass(requisito.getNumMayusculas(),requisito.getNumMinusculas() ,requisito.getNumDigitos() ,requisito.getNumCaractEspeciales());
				 
				 mensajeParaCliente.writeUTF("La contraseña generada es: "+ passFinal);
				 System.out.println("Se ha enviado la contraseña al cliente");
			 }
			 
		
			 
			 else {
				 
				// Informa que no se generará ninguna contraseña
				 
				 mensajeParaCliente.writeUTF("No se generará ninguna contraseña. Hasta la próxima");
				 
				 System.out.println("El cliente no desea generar una contraseña");
			 
			 
			 }
		
			 
			// Cierre de flujos y socket
			  mensajeParaCliente.close();
              entrada.close();
              socket.close();
			
			

		
		}
		
		
		
		
		
		}catch(IOException e) {
			
			e.printStackTrace();
		}
			
}
			
		
	
	
	
	
	
	

}

	
	
	
	
	
	


