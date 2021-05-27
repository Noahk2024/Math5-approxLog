package math5testproj;

import java.text.DecimalFormat;
import java.util.Scanner;



public class Main {
	
	public static double arithmetic_mean(double x, double y) {
		
		return (x + y) / 2;
	}
	
	public static double geometric_mean(double x, double y) {
		
		return Math.sqrt(x * y);
	}
	
	public static double[] create_low_bound(double input) {
		double[] data = new double[2];
		double low_bound = Math.sqrt(10.0);
		double n = 2.0;
		if (low_bound > input) {
			while (low_bound > input) {
				n++; 
				low_bound = Math.pow(10, 1 / n);
			}
		}
		data[0] = 1 / n;
		data[1] = low_bound;
		return data;
	}
	
	public static double[] shorten(double input) {
		double[] data = new double[2];
		double n = 0.0;
		if (input > 10.0) {
			while (input > 10.0) {
				n++;
				input = input / Math.pow(10.0, n);
			}
		}
		data[0] = input;
		data[1] = n;
		return data;
	}
	
	public static void main(String[] args) {
		
		DecimalFormat decimalFormat =  new DecimalFormat("#.####");
		
		Scanner sc = new Scanner(System.in);
		Double num = Double.valueOf(sc.nextLine());
		//System.out.println("works here");
		double[] data = shorten(num);
		System.out.println(data[0]);
		double[] low_bound_data = create_low_bound(data[0]);
		System.out.println("works here");
		System.out.println(low_bound_data[0]);
		
		double high_bound = 1.0;
		double low_bound = low_bound_data[0];
		System.out.println("works here");
		double compare_high_bound = 10.0;
		double compare_low_bound = low_bound_data[1];
		System.out.println("works here");
		for (int i=0; i < 20; i++) {
			if (geometric_mean(compare_high_bound, compare_low_bound) > data[0]) {
				compare_high_bound = geometric_mean(compare_high_bound, compare_low_bound);
				high_bound = arithmetic_mean(high_bound, low_bound);
				System.out.println("works here");
			}
			else if (geometric_mean(compare_high_bound, compare_low_bound) < data[0]){
				compare_low_bound = geometric_mean(compare_high_bound, compare_low_bound);
				low_bound = arithmetic_mean(high_bound, low_bound);
				System.out.println("works here");
			}
			System.out.println(low_bound + " " + "log" + data[0] + " " + high_bound);
			System.out.println("\n" + compare_low_bound + "   " + compare_high_bound + "\n");
		
		}

		
	}
}


