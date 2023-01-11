import java.util.Scanner;
public class moverfila1a3{ 
    public static void main (String args[]){ 
		Scanner reader = new Scanner(System.in);
		int m[][] ={
					{1,2},
					{3,4},
					{5,6}
					};
						
		int v[]={0,0};
		
		System.out.println("matriz 1");
		mostrar(m);
		//guaradar primera fila
		for(int j=0;j<2;j++){
			v[j]=m[0][j];
		}
	
	
		//mover filas
		for(int i=0;i<m.length-1;i++){
			for(int j=0;j<m[i].length;j++){
				m[i][j]=m[i+1][j];
			}
		}
		
		//poner primera fila en la ultima
		for(int j=0;j<2;j++){
			m[2][j]=v[j];
		}
		System.out.println();
		System.out.println("matriz 2");
		mostrar(m);
		
	}
	
	//funcion para mostrar
	public static void mostrar (int m[][]){ 
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				System.out.print(m[i][j]+" ");
			}System.out.println();
		}
	}
}