package q3;

/**
 * tester for both binary and sequential search @author Justin Kord 
 * Student number 0360764
 * This class counts the number of searches needed to locate a specific value
 * in a array and in a Binary Search Tree
 **/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class tester {

	public static void main(String[] args) throws FileNotFoundException {
		// create tree and local variables needed
		BSTree tree = new BSTree();
		int counted = 0;
		// needed to loop through arrays and store values
		int k = 0;
		int g = 0;
		int o = 0;
		int a = 0;
		int l = 0;
		// average and standard deviation holders
		int seqAVG = 0;
		int binAVG = 0;
		int calcSD1 = 0;
		int calcSD2 = 0;
		int calcSD3 = 0;
		int calcSD4 = 0;
		// arrays to store the data for numbers of searches in each case
		double[] data1 = new double[100];
		double[] data2 = new double[100];
		double[] data3 = new double[100];
		double[] data4 = new double[100];
		// create file results.txt to output the results
		String output = "results.txt";
		PrintWriter out = new PrintWriter(output);
		out.println("Overall search stats");

		// fill size 100 array with random values between 1-100 (disjoint)
		int[] randArray = new int[100];
		for (int i = 0; i < 100; i++) {
			randArray[i] = (int) (Math.random() * 100 - 1) + 1;
		}
		// fill size 10000 array with random values between 500-1000 (disjoint)
		int[] randArray2 = new int[10000];
		for (int i = 0; i < 10000; i++) {
			randArray2[i] = (int) (Math.random() * 1000 - 500) + 500;
		}
		// insert size 10000 array into the tree
		for (int i = 0; i < 10000; i++) {
			tree.insert(randArray2[i]);
		}
		// show the height of the tree
		System.out.println("Height of tree: " + tree.findHeight(tree.root));
		// search the size 10000 array for the values of the size 100 array
		// (unsuccessful)
		System.out.println("Searching the bigger array for the 100 array 1 values");
		System.out.println("");
		for (int i = 0; i < 100; i++) {
			System.out.print(+i + 1 + ".");
			data1[g] = tester.contains(randArray2, randArray[i]);
			counted += data1[g];
			g++;

		}
		System.out.println("Average searches: " + counted / 100);
		out.println("Average searches for first sequential search : " + counted / 100);
		seqAVG += counted / 100;
		counted = 0;
		System.out.println("****************************************");
		// search the tree for the size 100 array values (unsuccessful)
		System.out.println("Searching Tree for the 100 array 1 values");
		System.out.println("");
		for (int i = 0; i < 100; i++) {
			System.out.print(+i + 1 + ".");
			tree.find(randArray[i]);
			System.out.println("It took " + tree.count + " searches");
			k += tree.count;
			data2[o] = tree.count;
			o++;
			tree.count = 0;
		}
		System.out.println("Average searches: " + k / 100);
		out.println("Average searches for first binary search : " + k / 100);
		binAVG += k / 100;
		k = 0;
		System.out.println("****************************************");
		// search the size 10000 array for 100 random values from itself (successful)
		System.out.println("Searching the bigger array for the 100 random array 2 values");
		System.out.println("");
		for (int i = 0; i < 100; i++) {
			System.out.print(+i + 1 + ".");
			data3[a] = tester.contains(randArray2, randArray[i]);
			counted += data3[a];
			a++;
		}
		System.out.println("Average searches: " + counted / 100);
		out.println("Average searches for second sequential search : " + counted / 100);
		seqAVG += counted / 100;
		counted = 0;

		System.out.println("");
		System.out.println("****************************************");
		System.out.println("");
		// search the tree for the 100 values that were searched in the size 10000
		// array(successful)
		System.out.println("Searching Tree for the 100 random array 2 values");
		System.out.println("");
		for (int i = 0; i < 100; i++) {
			System.out.print(+i + 1 + ".");
			tree.find(randArray2[(int) (Math.random() * 1000)]);
			System.out.println("It took " + tree.count + " searches");
			k += tree.count;
			data4[l] = tree.count;
			l++;
			tree.count = 0;
		}
		System.out.println("Average searches: " + k / 100);
		out.println("Average searches for second binary search : " + k / 100);
		binAVG += k / 100;
		k = 0;
		System.out.println("****************************************");

		// print out and write to results.txt the overall
		// results for average and standard deviation from all searches
		System.out.println("Overall search stats");

		System.out.println("Average seq searches: " + seqAVG / 2);
		System.out.println("Average bin searches: " + binAVG / 2);
		System.out.println("Standard deviation 1 (unsuccessful) : " + calculateSD(data1));
		System.out.println("Standard deviation 2 (unsuccessful) : " + calculateSD(data2));
		System.out.println("Standard deviation 3 (successful) : " + calculateSD(data3));
		System.out.println("Standard deviation 4 (successful) : " + calculateSD(data4));
		out.println("Standard deviation 1 (unsuccessful) : " + calculateSD(data1));
		out.println("Standard deviation 2 (unsuccessful) : " + calculateSD(data2));
		out.println("Standard deviation 3 (successful) : " + calculateSD(data3));
		out.println("Standard deviation 4 (successful) : " + calculateSD(data4));
		out.close();
	}

	// contains method to determine if a specific value is in the array
	public static int contains(int[] arr, int item) {
		int count = 0, i = 0;
		int x = 0;
		for (int n : arr) {
			// count the number of searches needed
			count++;
			if (item == arr[n]) {
				System.out.println("Found a " + item);
				System.out.println("It took " + count + " searches");
				x = count;
				count = 0;
				return x;
			}
		}
		System.out.println("Found nothing. ");
		System.out.println(+i + 1 + "." + "It took " + count + " searches");
		i++;
		return count;
	}

	// calculateSD method to calculate the standard deviation of the searches
	public static double calculateSD(double numArray[]) {
		double sum = 0.0, standardDeviation = 0.0;

		for (double num : numArray) {
			sum += num;
		}

		double mean = sum / 10;

		for (double num : numArray) {
			standardDeviation += Math.pow(num - mean, 2);
		}

		return Math.sqrt(standardDeviation / 10);
	}
}