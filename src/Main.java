import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Cuvant {
    String text;

    public Cuvant(String text) {
        this.text = text;
    }

    public void metoda1() {
        System.out.println("Nr. words in txt : " + numarCuvinte());
    }

    public void metoda1(String additionalMessage) {
        System.out.println(additionalMessage + numarCuvinte());
    }

    public void metoda3() {
        System.out.println("Length txt : " + text.length() + " characters");
    }

    private int numarCuvinte() {
        String[] cuvinte = text.split("\\s+");
        return cuvinte.length;
    }

    String inverseazaText() {
        return new StringBuilder(text).reverse().toString();
    }

    public void cautaSubstring() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the substring pattern to search for: ");
        String patternToSearch = scanner.nextLine();
        scanner.close();

        Pattern regex = Pattern.compile(patternToSearch);
        Matcher matcher = regex.matcher(text);

        if (matcher.find()) {
            System.out.println("Substring found: " + matcher.group());
        } else {
            System.out.println("Substring not found.");
        }
    }

    @Override
    public String toString() {
        return text;
    }
}

class Linie extends Cuvant {
    public Linie(String text) {
        super(text);
    }

    public void metoda2() {
        System.out.println("Reversed text: \"" + inverseazaText() + "\"");
    }

    public void metoda2(int timesToRepeat) {
        for (int i = 0; i < timesToRepeat; i++) {
            System.out.println("Reversed text (iteration " + (i + 1) + "): \"" + inverseazaText() + "\"");
        }
    }

    public void afisareLinie() {
        System.out.println("Line : " + text);
    }
}

class Program {
    @SuppressWarnings("StringConcatenationInLoop")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Linie linie = new Linie("");

        do {
            System.out.print("Enter the word : ");
            String cuvant = scanner.nextLine();

            linie.text = linie.text + cuvant + " ";
            linie.metoda2();
            linie.metoda1(); // Apel la prima versiune a metodei metoda1()
            linie.metoda1("Custom message: Nr. words in txt = "); // Apel la a doua versiune a metodei metoda1()
            linie.metoda3();

            System.out.print("Do you want to add another word? (Y/N): ");
        } while (scanner.nextLine().trim().equalsIgnoreCase("Y"));

        linie.afisareLinie();
        linie.metoda1();
        linie.metoda2();
        linie.metoda2(3); // Apel la a doua versiune a metodei metoda2()
        linie.metoda3();

        System.out.print("Do you want to search for a substring? (Y/N): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
            linie.cautaSubstring();
        }

        scanner.close();
    }
}
