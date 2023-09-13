import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa una palabra para verificar si es un palindromo");
        String palabra = sc.next().toLowerCase();

        if(esPalindromo(palabra)){
            System.out.print("La palabra es un palindromo!");
        }else{
            System.out.println("La palabra no es un palindromo!");
        }
    }

    public static boolean esPalindromo(String palabra) {
        int longitudPalabra = palabra.length();

        for (int i = 0; i < longitudPalabra/2 ; i++) {
            if(palabra.charAt(i) != palabra.charAt(longitudPalabra - 1 -i)){
                return false;
            }
        }
        return true;
    }
}
