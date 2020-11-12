//https://omegaup.com/arena/ED-P2/#problems/Salvenlos
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		// Leer entrada en consola
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String lineaAEjecutar = br.readLine();
		String[] lineaSiendoEjecutada = lineaAEjecutar.split(" ");

		int n = Integer.parseInt(lineaSiendoEjecutada[0]);
		int xL = Integer.parseInt(lineaSiendoEjecutada[1]);
		int[] x = new int[n];
		int[] y = new int[n];
		int[] r = new int[n];
		double[] c = new double[n];
		int j = 0;
		int a = 0, b = 0, q = 0;

		// Procesar circulitos

		for (int i = 0; i < n; i++) {
			String Circulo = br.readLine();
			String[] siguienteCirculo = Circulo.split(" ");
			x[i] = Integer.parseInt(siguienteCirculo[0]);
			y[i] = Integer.parseInt(siguienteCirculo[1]);
			r[i] = Integer.parseInt(siguienteCirculo[2]);
		}

		try {

			for (int i = 0; i < n; i++) {
				if (x[i] - r[i] < 0) {
					a = x[i];
					b = y[i];
					q = r[i];
					//j = i + 1;
					break;
				}

			}

			for (int i = j; i <= n; i++) {
				if (DoTheyMeet(a, b, q, x[i], y[i], r[i]) && x[i] + r[i] >= a + q) {
					a = x[i];
					b = y[i];
					q = r[i];
				}
				if (a + q >= xL) {
					bw.write("Si");
					break;
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			bw.write("No");
		}
		br.close();
		bw.close();
	}

	public static boolean DoTheyMeet(int x1, int y1, int r1, int x2, int y2, int r2) {

		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		if (distance <= r1 + r2) {
			return true;
		} else {
			return false;
		}

	}

}