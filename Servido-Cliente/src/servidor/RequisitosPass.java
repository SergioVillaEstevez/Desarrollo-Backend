package servidor;

public class RequisitosPass {

	
		private int numMayusculas;
		private int numMinusculas;
		private int numDigitos;
		private int numCaractEspeciales;
		
		
		public RequisitosPass() {}
		
		
		
		public int getNumMayusculas() {
			return numMayusculas;
		}
		public void setNumMayusculas(int numMayusculas) {
			this.numMayusculas = numMayusculas;
		}
		public int getNumMinusculas() {
			return numMinusculas;
		}
		public void setNumMinusculas(int numMinusculas) {
			this.numMinusculas = numMinusculas;
		}
		public int getNumDigitos() {
			return numDigitos;
		}
		public void setNumDigitos(int numDigitos) {
			this.numDigitos = numDigitos;
		}
		public int getNumCaractEspeciales() {
			return numCaractEspeciales;
		}
		public void setNumCaractEspeciales(int numCaractEspeciales) {
			this.numCaractEspeciales = numCaractEspeciales;
		}
		
		
		@Override
		public String toString() {
			return "PasswordReqs{Mayusculas=" + numMayusculas + ", Minusculas=" + numMinusculas
					+ ", Digitos=" + numDigitos + ", CaracteresEspeciales=" + numCaractEspeciales + "}";
		}
		
		
		
}
