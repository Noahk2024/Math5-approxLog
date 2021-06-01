//Noah Kabiri
//Console-Based, GUI program is different

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
				input = input / 10;
			}
		}
		else if (input < 1.0 & input > 0) {
			while (input < 1.0) {
				n--; 
				input = input * 10;
			}
		}
		data[0] = input;
		data[1] = n;
		return data;
	}
	
	public static void main(String[] args) {
		System.out.println("Please Enter The Number You Would Like To Log (Do not enter fractions)" + "\n");		
		Scanner sc = new Scanner(System.in);
		Double num = Double.valueOf(sc.nextLine());	
		double[] data = shorten(num);	
		
		if (num % 10 == 0 || Math.pow(10, -(Double.toString(num).length() - 2)) % num == 0 || num == 1 || num < 0) {
			sc.close();
			
			if (num < 1.0 & num > 0) {
				System.out.println("log(" + num + ") = " + data[1]);
				return;
			}
			else if (num > 1.0) {
				System.out.println("log(" + num + ") = " + (data[1] + 1));
				return;	
			}
			else if (num == 1.0) {
				System.out.println("log(" + num + ") = 0");
				return;
			}
			else if (num == 0.0 || num < 0.0) {
				System.out.println("log(" + num + ") = " + "undefined");
        return;
			}
			
		}
		double[] low_bound_data = create_low_bound(data[0]);
		double low_bound = low_bound_data[0];		
		double compare_low_bound = low_bound_data[1];
		sc.close();
		
		double high_bound = 1.0;
		double final_num = 0.0;
		double compare_high_bound = 10.0;
		String high_bound_check = "";
		String low_bound_check = "";
		int high_bound_check_int = 0;
		int low_bound_check_int = 0;
		int check = 0;
		while (check < 2) {
			
			if (geometric_mean(compare_high_bound, compare_low_bound) > data[0]) {
				compare_high_bound = geometric_mean(compare_high_bound, compare_low_bound);
				high_bound = arithmetic_mean(high_bound, low_bound);
				high_bound_check = String.valueOf(high_bound);	
			}
			
			else if (geometric_mean(compare_high_bound, compare_low_bound) < data[0]){
				compare_low_bound = geometric_mean(compare_high_bound, compare_low_bound);
				low_bound = arithmetic_mean(high_bound, low_bound);
				low_bound_check = String.valueOf(low_bound);	
			}
			
			if (low_bound_check.length() > 5 & high_bound_check.length() > 5) {
				low_bound_check = low_bound_check.substring(2, 6);
				high_bound_check = high_bound_check.substring(2, 6);
				high_bound_check_int = Integer.parseInt(high_bound_check);
				low_bound_check_int = Integer.parseInt(low_bound_check);
				if (low_bound_check_int == high_bound_check_int) {
					check++;
				}
			}
			
			
		}
		System.out.println("\n" + "log(" + compare_low_bound + ") <  log(" + data[0] + ") < log(" + compare_high_bound + ")\n");
		if (high_bound + data[1] > 0) {
			final_num = Double.parseDouble(String.valueOf(high_bound + data[1]).substring(0, 6));
		}
		else {
			final_num = Double.parseDouble(String.valueOf(high_bound + data[1]).substring(0, 7));
		}
		System.out.println("log(" + num + ") = " + final_num);
	}
}

