
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {

			// RECEPCIÓN DE DATOS
			int N = Integer.parseInt(in.next());
			ArrayList<Integer> a = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				a.add(Integer.parseInt(in.next()));
			}
			Collections.sort(a);

			int money = Integer.parseInt(in.next());

			// SOLUCIÓN CON BÚSQUEDA BINARIA
			ArrayList<Integer> indexes = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				int book1 = a.get(i);
				int book2 = money - a.get(i);
				if (book1 <= book2) {
					int index = bsearch(copyArrayAndRemoveElement(a, i), book2);
					if (index >= 0) {
						indexes.add(book1);
					}
				}
			}
			System.out.print("Peter should buy books whose prices are " + indexes.get(indexes.size()-1) + " and " + (money - indexes.get(indexes.size()-1)) + ".\n\n");

		}
	}

	private static ArrayList<Integer> copyArrayAndRemoveElement(ArrayList<Integer> a, int index) {
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++) {
			copy.add(a.get(i));
		}
		copy.remove(index);
		return copy;
	}

	public static int bsearch(ArrayList<Integer> arr, int goal) {
		int inicio = 0;
		int fin = arr.size() - 1;
		while (inicio <= fin) {
			int median = (fin + inicio) / 2;
			if (arr.get(median) == goal) {
				return median;
			} else if (arr.get(median) < goal) {
				inicio = median + 1;
			} else {
				fin = median - 1;
			}
		}
		return -1;
	}

}
