public class Cliente {

		private String nombre;
		private int[] carroCompra;

		public Cliente(String nombre, int[] carroCompra){
			this.nombre=nombre;
			this.carroCompra=carroCompra;
		}
	
		public void setNombre(String n){
			nombre=n;
		}

		public void setCarroCompra(int[] a){
			carroCompra=a;
		}

		public int[] getCarroCompra(){
			return carroCompra;
		}

		public String getNombre(){
			return nombre;
		}
	}
