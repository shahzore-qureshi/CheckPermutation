public class CP {

	public static void main(String[] args) {

		//Check if input has two arguments.
		if(args.length != 2)	{
			System.out.println("Please include two Strings as arguments.");
			return;
		}

		//Check if arguments have the same length.
		//A string cannot be a permutation of another
		//if the lengths vary.
		if(args[0].length() != args[1].length()) {
			System.out.println("Please include two Strings with the same length.");
			return;
		}

		//Assume that alphabet consists of 128 characters.
		//Use an array to determine the count of each letter
		//in the first String argument. Then, compare the
		//counts with the second String argument.
		int[] alphabetCount = new int[128];

		String firstString = args[0];
		String secondString = args[1];

		//Count instances of each letter in first String.
		for(int i = 0; i < firstString.length(); i++) {
			int letterCode = firstString.charAt(i);
			alphabetCount[letterCode]++;
		}

		//Subtract each instance of a letter in second String
		//until there are no more instances of that letter.
		//If one of the letter counters reaches -1, that means
		//there is a mismatch in the number of letters between
		//the two Strings, and therefore, neither String is a
		//permutation of the other.
		for(int j = 0; j < secondString.length(); j++) {
			int letterCode = secondString.charAt(j);
			alphabetCount[letterCode]--;

			if(alphabetCount[letterCode] == -1) {
				System.out.println("Strings are not permutations of the other.");
				return;
			}
		}

		//Check if all alphabet letter counts are zero.
		//If they are all zero, that means both Strings
		//are permutations of the other.
		for(int k = 0; k < alphabetCount.length; k++) {
			if(alphabetCount[k] != 0) {
				System.out.println("Strings are not permutations of the other.");
				return;
			}
		}

		System.out.println("Strings are permutations of each other.");

	}

}
