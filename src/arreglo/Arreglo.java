package arreglo;

import java.util.Arrays;

/**
 *
 * @author iseli
 */
public class Arreglo {

    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] a = spiralMatrix(arr);
        System.out.println(Arrays.toString(a));
    } 
 
    public static int[] spiralMatrix(int[][] arr){
		int m=arr.length;//Fila
		int n=arr[0].length;//Columna
		int left=0;// Dirección izquierda
		int right=arr[0].length-1;//Dirección correcta
		int top=0;//Hacia arriba
		int bottom=arr.length-1;//Hacia abajo
		
		int[] a=new int[m*n];
		int temp=0;
		String direction="right";// La dirección a recorrer
		while(left<=right&&top<=bottom){
			if(direction.equals("right")){
				for(int i=left;i<=right;i++){
					a[temp++]=arr[top][i];
				}
				// Atraviesa el límite de izquierda a derecha, listo para atravesar hacia abajo, lo anterior ha atravesado una línea, entonces arriba ++
				top++;
				direction="bottom";
			}else if(direction.equals("bottom")){
				for(int i=top;i<=bottom;i++){
					a[temp++]=arr[i][right];
				}
				// Atravesar desde el límite superior al inferior, listo para atravesar hacia la izquierda, una columna ha sido atravesada a la derecha, entonces a la derecha--
				right--;
				direction="left";
			}else if(direction.equals("left")){
				for(int i=right;i>=left;i--){
					a[temp++]=arr[bottom][i];
				}
				// Atraviesa el límite de derecha a izquierda, listo para atravesar hacia arriba, la siguiente línea ha sido atravesada, así que abajo ...
				bottom--;
				direction="top";
			}else if(direction.equals("top")){
				for(int i=bottom;i>=top;i--){
					a[temp++]=arr[i][left];
				}
				// Atravesar desde el límite inferior hacia el superior, listo para atravesar hacia la derecha, la izquierda ha atravesado una columna, entonces la izquierda ++
				left++;
				direction="right";
			}
		}
		return a;
		
	}
    
}
