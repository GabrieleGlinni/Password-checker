import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordApp {
	public static void main(String[] args) {

		// OBIETTIVO: Un'app che verifica che le password rispettino dei criteri:
		// 1. Un numero
		// 2. Una lettera
		// 3. Un carattere speciale
		// Per ogni errore, compare un'eccezione (es: numero mancante)
		// Se non rispetta i criteri, compare un'eccezione (es: manca uno degli
		// elementi)

		// 1. Trova la cartella
		String filename = "C:\\Users\\gabri\\Desktop\\Generale\\Programmazione\\Java\\Password_Criteria\\Fakepassword.txt";

		// 2. Crea il file in Java
		File file = new File(filename);
		String Password = null;

		try { // CON TRY TESTO IL CODICE
				// 3. Apri il file
			BufferedReader br = new BufferedReader(new FileReader(file));

			// 4. Leggi il file
			Password = br.readLine();

			// 5. Chiudi le risorse
			br.close();

		} catch (FileNotFoundException e) { // CON CATCH becco l'errore e lo risolve a modo nostro
			System.out.println("ERROR: File not found: " + filename);
		} catch (IOException e) { // becco l'errore e lo risolve a modo nostro
			System.out.println("ERROR: Could not read the data: " + filename);
		}

		// Password valida: ha almeno un numero, una lettera e un carattere speciale

		try {
			String esitoPositivocarattere = "Carattere incluso.";
			String esitoPositivonumero = "Numero incluso.";
			String esitoPositivospeciale = "Carattere speciale incluso.";
			char[] specialChars = "!@#*+-_(%?/{}[].,;:".toCharArray();
			for (int n = 0; n < Password.length(); n++) {
				if (Password.substring(n).matches(".*[a-z].*")) {
					{
						System.out.println(esitoPositivocarattere);
					}
				} else {
					throw new MissingCharacterException();
				}
				if (Password.substring(n).matches(".*\\d.*")) {
					System.out.println(esitoPositivonumero);
				} else {
					throw new MissingNumberException();
				}
				boolean foundSpecial = false;
				for (int i = 0; i < specialChars.length; i++) {
					if (Password.indexOf(specialChars[i]) > -1) {
						foundSpecial = true;
					}
				}
				if (foundSpecial) {
					System.out.println(esitoPositivospeciale);
					break;
				} else {
					throw new MissingSpecialCharacterException();
				}
			}
		} catch (

		MissingSpecialCharacterException e) {
			System.out.println("ERRORE: Manca un carattere speciale.");
		} catch (MissingNumberException e) {
			System.out.println("ERRORE: Manca un numero.");
		} catch (MissingCharacterException e) {
			System.out.println("ERRORE: Manca un carattere.");
		}

	}
}

class MissingSpecialCharacterException extends Exception { // importante aggiungere extends Exception per ogni tipo di
															// eccezione

}

class MissingNumberException extends Exception {

}

class MissingCharacterException extends Exception {

}