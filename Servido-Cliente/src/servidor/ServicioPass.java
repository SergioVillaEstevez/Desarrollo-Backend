package servidor;

import java.util.Random;

public class ServicioPass {
	
	// Instancia de la clase RequisitosPass para obtener los requisitos de la contraseña
	RequisitosPass requisitosPass= new RequisitosPass();
	
	
	//Genera una contraseña basada en los requisitos especificados.
	
	 public String generaPass(int numMayusculas, int numMinusculas, int numDigitos, int numEspeciales) {
	        StringBuilder contraseña = new StringBuilder();
	        
	        // Generar mayúsculas
	        for (int i = 0; i < numMayusculas; i++) {
	            contraseña.append(generaCaracter("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	        }
	        
	        // Generar minúsculas
	        for (int i = 0; i < numMinusculas; i++) {
	            contraseña.append(generaCaracter("abcdefghijklmnopqrstuvwxyz"));
	        }
	        
	        // Generar dígitos
	        for (int i = 0; i < numDigitos; i++) {
	            contraseña.append(generaCaracter("0123456789"));
	        }

	        // Generar caracteres especiales
	        String especiales = "!@#$%^&*()_-+=.:?";
	        for (int i = 0; i < numEspeciales; i++) {
	            contraseña.append(generaCaracter(especiales));
	        }
	        
	     // Mezcla la contraseña
	        return mezclarContraseña(contraseña.toString());
	    }
	 
	 
	    
	     // Genera un carácter aleatorio de la cadena de caracteres proporcionada.
	     
	  
	 
	  private char generaCaracter(String caracteres) {
	        Random rand = new Random();
	        return caracteres.charAt(rand.nextInt(caracteres.length()));
	    }
	  
	 
	     
	     // Mezcla la contraseña para aumentar la aleatoriedad.
	
	  
	    private String mezclarContraseña(String contraseña) {
	        char[] contraseñaArray = contraseña.toCharArray();
	        Random rand = new Random();
	        
	        for (int i = 0; i < contraseñaArray.length; i++) {
	            int indiceAleatorio = rand.nextInt(contraseñaArray.length);
	         
	            // Intercambia caracteres en posiciones aleatorias
	            char temp = contraseñaArray[i];
	            contraseñaArray[i] = contraseñaArray[indiceAleatorio];
	            contraseñaArray[indiceAleatorio] = temp;
	        }
	        
	        return new String(contraseñaArray);
	    }
	 
	 
	 
	
	public int longitudPass(int numMayus,int numMinusculas,int numDigitos,int numCaracteres) {
		 
		// Retorna la suma de todos los requisitos para obtener la longitud total de la contraseña
		return numMayus + numMinusculas + numDigitos + numCaracteres;
		
		
	}
		
}
