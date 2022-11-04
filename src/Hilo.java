
public class Hilo extends Thread{
    
	//Variables globales para todos los hilos
	public static int nHilos;
	public static int nElementos;
	public static double sumaTotal;
	
	
	//Variables locales para cada hilo
	private int miId;
	private int miN;
	private int miInicio;
	private int miFinal;
	private double miSuma;
	
	public Hilo(int id){
		miId=id;
	}//Hilo()
	@Override
	public void run(){
		//Número de elementos para cada hilo
		miN= nElementos/nHilos;
		
		//Primer elemento del hilo
		miInicio=miId*miN;
		
		//Último elemento del hilo
		miFinal=miInicio+miN; //miFinal=miInicio+miN-1;
		
		double signo;
		if(miInicio%2==0)
			signo=1.0;
		else
			signo=-1.0;
		
		for(int e=miInicio; e< miFinal; e++,signo*=-1.0){
			
			//sumaTotal=sumaTotal+ signo/(2*e+1);
			miSuma= miSuma+ signo/(2*e+1);
			
		}
		
		//sumaTotal=sumaTotal+miSuma;
		sumar(miSuma);
	}//run
	
	private static synchronized void sumar(double sumaIndividual){
		sumaTotal=sumaTotal+sumaIndividual;
		
	}
	
	
}//hilo
