

public class Main {
    public static void main(String[] args) {

        String[][] vinilos =  new String[100][3];

        agregarVinilos(vinilos ,"Iron Maiden","Iron Maiden","1980");
        agregarVinilos(vinilos , "Iron Maiden","Killers", "1981");
        agregarVinilos(vinilos , "Iron Maiden", "The number of the beast", "1982");
        agregarVinilos(vinilos , "AC-DC","Back in the black", "1982");
        agregarVinilos(vinilos , "AC-DC", "Higway to hell", "1979");
        agregarVinilos(vinilos , "AC-DC", "Who made who" , "1986");
        agregarVinilos(vinilos , "Judas Priest", "British steel", "1980");
        agregarVinilos(vinilos , "Judas Priest", "Painkiller", "1990");
        agregarVinilos(vinilos , "Judas Priest", "Defenders of the faith" , "1984");
        agregarVinilos(vinilos , "Kiss", "Destroyer" , "1976");

        System.out.printf("Espacio maximo coleecion : "+ vinilos.length );

        mostrarTotalNumeroVinilos(vinilos);

        mostrarEspacioDisponible(vinilos);

        String artistaBuscado = "AC-DC";
        System.out.println("El artista a buscar es: "+artistaBuscado);

        mostrarBusquedaArtista(vinilos,artistaBuscado);

        buscarArtistas(vinilos, artistaBuscado);

        mostrarColeccion(vinilos);

    }
    public static int totalVinilos(String[][] vinilos){

        int contador = 0;

        for (int i = 0; i < vinilos.length ; i++) {
            if (vinilos[i][0] != null) {contador++;}
        }
         return contador;
    }
    public static void agregarVinilos(String[][] vinilos, String nombreArtista, String nombreDisco , String añoLanzamiento){

        for (int i = 0; i <vinilos.length ; i++) {
            if (vinilos[i][0] == null){
                vinilos[i][0] = nombreArtista;
                vinilos[i][1] = nombreDisco;
                vinilos[i][2] = añoLanzamiento;

                break;
            }
        }
    }
    public static boolean buscarArtistas(String[][] vinilos, String nombreArtista){

        for (String[] vinilo : vinilos) {
            if (vinilo[0] != null && vinilo[0].equals(nombreArtista)) {
                return true;
            }
        }
        return false;
    }
    public static void mostrarColeccion(String[][] vinilos){

            for (int i = 0; i <vinilos.length ; i++) {
                if(vinilos[i][0] != null){
                    System.out.print("\n Fila "+(i+1)+":  "+vinilos[i][0]+"-"+vinilos[i][1]+"-"+vinilos[i][2] );
                }
            }
    }
    public static void mostrarTotalNumeroVinilos(String[][] vinilos){

        System.out.println("\nHay un total de :"+ totalVinilos(vinilos)+" vinilos en la collecion ");

    }
    public static void mostrarEspacioDisponible(String[][] vinilos){

        System.out.println("Hay un total de: " + contarEspacioDisponible(vinilos) + " espacios disponibles en la coleccion \n");
    }w
    public static int contarEspacioDisponible(String[][] vinilos){
        int contador = 0;

        for (int i = 0; i <vinilos.length ; i++) {
            if(vinilos[i][0] == null){
                contador++;
            }
        }
        return contador;
    }
    public static void mostrarBusquedaArtista(String[][] vinilos, String nombreArtista){

        if (buscarArtistas(vinilos, nombreArtista)){
            System.out.printf("El artista :"+ nombreArtista+" si se encuentra en la coleccion");
        }else{
            System.out.printf("El artista :"+ nombreArtista+" no se encuentra en la coleccion");
        }
    }
}
