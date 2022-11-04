
public class Programa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Hilo.nHilos=Integer.parseInt(args[0]);
		Hilo.nElementos=Integer.parseInt(args[1]);
		
		Hilo[] hilos=new Hilo[Hilo.nHilos];
		
		for(int h=0;h<Hilo.nHilos;h++){
			hilos[h]=new Hilo(h);
		}
		
		//Tiempo de inicio
		 long ti=System.currentTimeMillis();
		
		for(int h=0; h<Hilo.nHilos; h++){
			hilos[h].start();
		}
		
		for(int h=0; h<Hilo.nHilos; h++){
			hilos[h].join();
		}
		//Tiempo de finalización
		long tf= System.currentTimeMillis();
		
		System.out.printf("El procesamiento tomó  %d ms%n",(tf-ti));
		
		System.out.printf("El valor estimado de Pi es %.9f%n", (4*Hilo.sumaTotal));
		
	}//main

}//programa
