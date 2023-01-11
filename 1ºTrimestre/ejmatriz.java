public class ejmatriz {

	public static void main(String[] args) {
		int array1[][] = { { 2, 4, 5, 6 }, { 8, 7, 4, 1 }, { 27, 36, 42, 5 } };
		int sumac[] = { 0, 0, 0, 0 };

		for (int i = 0; i < array1.length; i++) {
			int sumaf = 0;

			for (int j = 0; j < array1[i].length; j++) {
				System.out.print(array1[i][j] + ",");
				sumaf = sumaf + array1[i][j];
				sumac[j] = sumac[j] + array1[i][j];

			}
			System.out.print(" " + sumaf);

			System.out.println("");

			for (int j = 0; j < array1[i].length; j++) {
				System.out.println(sumac[j]);

			}
		}
	}
}