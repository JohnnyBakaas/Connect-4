import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] line1 = {'O', 'O', 'O', 'O', 'O', 'O'};
		char[] line2 = {'O', 'O', 'O', 'O', 'O', 'O'};
		char[] line3 = {'O', 'O', 'O', 'O', 'O', 'O'};
		char[] line4 = {'O', 'O', 'O', 'O', 'O', 'O'};
		char[] line5 = {'O', 'O', 'O', 'O', 'O', 'O'};
		char[] line6 = {'O', 'O', 'O', 'O', 'O', 'O'};
		char[] line7 = {'O', 'O', 'O', 'O', 'O', 'O'};
		
		System.out.println("Velkomen til 4 på rad");
		
		char spiller = 'R';
		String fullNavnSpiller = "Rød";
		
		while (true) {
			System.out.println("Spiller " + fullNavnSpiller + " det er din tur");
			System.out.println("Velg en linje");
			printbord(line1, line2, line3, line4, line5, line6, line7);
			
			System.out.println("Spiller " + fullNavnSpiller + ", hvor vil du legge brikken din?");
			imputTilNoeBrukbart(sc.nextInt(), spiller, line1, line2, line3, line4, line5, line6, line7);
			
			// har noen vunnet?
			if (harNoenFaktiskVunnet(spiller, line1, line2, line3, line4, line5, line6, line7) == 1) {
				printbord(line1, line2, line3, line4, line5, line6, line7);
				System.out.println(""+ "Spiller " + fullNavnSpiller + " har vunnet!");
				break;
			}
			
			if (spiller == 'R') {
				spiller = 'G';
			} else {
				spiller = 'R';
			}
			
			if (fullNavnSpiller == "Rød") {
				fullNavnSpiller = "Gul";
			} else {
				fullNavnSpiller = "Rød";
			}
			
		}
		sc.close();
	}
	
	//printer ut arrayen så jeg slipper å skrive det mer enn en gang
	public static void printbord (char[] array1, char[] array2, char[] array3, char[] array4, char[] array5, char[] array6, char[] array7) {
		System.out.println("|1|2|3|4|5|6|7|");
		for (int i = 0; i < 6; i++) {
			System.out.println("|" + array1[i] + "|" + array2[i] + "|" + array3[i] + "|" + array4[i] + "|" + array5[i] + "|" + array6[i] + "|" + array7[i] + "|");
		}
	}
	
	// komverterer imput fra sc til noe brukbart
	public static void imputTilNoeBrukbart (int imputFraSpiller, char spiller, char[] array1, char[] array2, char[] array3, char[] array4, char[] array5, char[] array6, char[] array7) {
		if (imputFraSpiller == 1) {
			array1[høyArray(array1)] = spiller;
		} else if (imputFraSpiller == 2) {
			array2[høyArray(array2)] = spiller;
		} else if (imputFraSpiller == 3) {
			array3[høyArray(array3)] = spiller;
		} else if (imputFraSpiller == 4) {
			array4[høyArray(array4)] = spiller;
		} else if (imputFraSpiller == 5) {
			array5[høyArray(array5)] = spiller;
		} else if (imputFraSpiller == 6) {
			array6[høyArray(array6)] = spiller;
		} else if (imputFraSpiller == 7) {
			array7[høyArray(array7)] = spiller;
		} else {
			System.out.println("du e drit");
		}
	}
	
	//skjekkerhøyden på en array
	public static int høyArray(char[] array) {
		int j = 0;
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] == 'O') {
				j++;
			}
		}
		return j;
	}
	
	//har noen vunnet vertikalt?
	public static int harNoenVunnetVertikalt(char[] array, char spiller) {
		int count = 0;
		int svar = 0;
		
		for (int i = 0; i < 6; i++) {
			
			if (array[i] == spiller) {
				count++;
			} else {
				count = 0;
			}
			if (count == 4) {
				break;
			}
		}
		if (count == 4) {
			svar = 1;
		}
		return svar;
	}
	
	// har noen vunnet horisontalt?
	public static int harNoenVunnetHorisontalt(char spiller, char[] array1, char[] array2, char[] array3, char[] array4, char[] array5, char[] array6, char[] array7) {
		int count = 0;
		int svar = 0;
		
		for (int i = 0; i < 6; i++) {
			
			if (count == 4) {break;}
			if (array1[i] == spiller) { count++;} else {count = 0;}
			
			if (count == 4) {break;}
			if (array2[i] == spiller) { count++;} else {count = 0;}

			if (count == 4) {break;}
			if (array3[i] == spiller) { count++;} else {count = 0;}

			if (count == 4) {break;}
			if (array4[i] == spiller) { count++;} else {count = 0;}

			if (count == 4) {break;}
			if (array5[i] == spiller) { count++;} else {count = 0;}

			if (count == 4) {break;}
			if (array6[i] == spiller) { count++;} else {count = 0;}

			if (count == 4) {break;}
			if (array7[i] == spiller) { count++;} else {count = 0;}
			count = 0;
		}
		if (count == 4) {
			svar = 1;
		}
		return svar;
		
	}
	
	// har noen vunnet på 135 grader
	public static int harNoenVunnet135(char spiller, char[] array1, char[] array2, char[] array3, char[] array4, char[] array5, char[] array6, char[] array7) {
		
		int count = 0;
		int svar = 0;
		
		for (int i = 0; i < 3; i++) {
			count = 0;
			
			if (array1[i] == spiller) {count++;} else {count = 0;}
			if (array2[i+1] == spiller) {count++;} else {count = 0;}
			if (array3[i+2] == spiller) {count++;} else {count = 0;}
			if (array4[i+3] == spiller) {count++;} else {count = 0;}
			if (count == 4) {svar = 1; break;} else {count = 0;}
			
			if (array2[i] == spiller) {count++;} else {count = 0;}
			if (array3[i+1] == spiller) {count++;} else {count = 0;}
			if (array4[i+2] == spiller) {count++;} else {count = 0;}
			if (array5[i+3] == spiller) {count++;} else {count = 0;}
			if (count == 4) {svar = 1; break;} else {count = 0;}
			
			if (array3[i] == spiller) {count++;} else {count = 0;}
			if (array4[i+1] == spiller) {count++;} else {count = 0;}
			if (array5[i+2] == spiller) {count++;} else {count = 0;}
			if (array6[i+3] == spiller) {count++;} else {count = 0;}
			if (count == 4) {svar = 1; break;} else {count = 0;}
			
			if (array4[i] == spiller) {count++;} else {count = 0;}
			if (array5[i+1] == spiller) {count++;} else {count = 0;}
			if (array6[i+2] == spiller) {count++;} else {count = 0;}
			if (array7[i+3] == spiller) {count++;} else {count = 0;}
			if (count == 4) {svar = 1; break;} else {count = 0;}
			
		}
		return svar;
	}
	
	// har noen vunnet på 45 grader
	public static int harNoenVunnet45(char spiller, char[] array1, char[] array2, char[] array3, char[] array4, char[] array5, char[] array6, char[] array7) {
		
		int count = 0;
		int svar = 0;
		
		for (int i = 0; i < 3; i++) {
			count = 0;
			
			if (array1[i+3] == spiller) {count++;} else {count = 0;}
			if (array2[i+2] == spiller) {count++;} else {count = 0;}
			if (array3[i+1] == spiller) {count++;} else {count = 0;}
			if (array4[i] == spiller) {count++;} else {count = 0;}
			if (count == 4) {svar = 1; break;} else {count = 0;}
			
			if (array2[i+3] == spiller) {count++;} else {count = 0;}
			if (array3[i+2] == spiller) {count++;} else {count = 0;}
			if (array4[i+1] == spiller) {count++;} else {count = 0;}
			if (array5[i] == spiller) {count++;} else {count = 0;}
			if (count == 4) {svar = 1; break;} else {count = 0;}
			
			if (array3[i+3] == spiller) {count++;} else {count = 0;}
			if (array4[i+2] == spiller) {count++;} else {count = 0;}
			if (array5[i+1] == spiller) {count++;} else {count = 0;}
			if (array6[i] == spiller) {count++;} else {count = 0;}
			if (count == 4) {svar = 1; break;} else {count = 0;}
			
			if (array4[i+3] == spiller) {count++;} else {count = 0;}
			if (array5[i+2] == spiller) {count++;} else {count = 0;}
			if (array6[i+1] == spiller) {count++;} else {count = 0;}
			if (array7[i] == spiller) {count++;} else {count = 0;}
			if (count == 4) {svar = 1; break;} else {count = 0;}
			
		}
		return svar;
	}
	
	// har noen vunnet sammlet?
	public static int harNoenFaktiskVunnet(char spiller, char[] array1, char[] array2, char[] array3, char[] array4, char[] array5, char[] array6, char[] array7) {
		int W = 0;
		if (harNoenVunnetVertikalt(array1, spiller) == 1) {W = 1;}
		else if (harNoenVunnetVertikalt(array2, spiller) == 1) {W = 1;}
		else if (harNoenVunnetVertikalt(array3, spiller) == 1) {W = 1;}
		else if (harNoenVunnetVertikalt(array4, spiller) == 1) {W = 1;}
		else if (harNoenVunnetVertikalt(array5, spiller) == 1) {W = 1;}
		else if (harNoenVunnetVertikalt(array6, spiller) == 1) {W = 1;}
		else if (harNoenVunnetVertikalt(array7, spiller) == 1) {W = 1;}
		
		else if (harNoenVunnetHorisontalt(spiller, array1, array2, array3, array4, array5, array6, array7) == 1) {W = 1;}
		else if (harNoenVunnet135(spiller, array1, array2, array3, array4, array5, array6, array7) == 1) {W = 1;}
		else if (harNoenVunnet45(spiller, array1, array2, array3, array4, array5, array6, array7) == 1) {W = 1;}
		
		return W;
	}

}
