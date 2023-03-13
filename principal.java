import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class principal {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo: 1)HashMap 2)TreeMap 3)LinkedHashMap");
        String tipomapa = scanner.nextLine();
        CartaMap mapaCarta = CartaMap(tipomapa);
        leerArchivo(mapaCarta);
        
        while (true) {
            System.out.println("Selecciona una opcion:");
            System.out.println("1) Agregar carta");
            System.out.println("2) Mostrar el tipo de una carta");
            System.out.println("3) Cartas que tiene el usuario");
            System.out.println("4) Cartas que tiene el usuario ordenadas por tipo");
            System.out.println("5) Mostrar todas las cartas");
            System.out.println("6) Mostrar todas las cartas por tipo");
            System.out.println("0) Salir");
        
            int option = scanner.nextInt();
            scanner.nextLine();
        
            if(option == 1){
                System.out.println("Ingrese el nombre de la carta:");
                String nombreCarta = scanner.nextLine().trim();
                mapaCarta.agregarCarta(nombreCarta, mapaCarta.getCartas().get(nombreCarta));
            }
            if(option == 2){
                System.out.println("Ingrese el nombre de la carta:");
                String carta = scanner.nextLine().trim();
                String tipoCarta = mapaCarta.getTipo(carta);
                if (tipoCarta != null) {
                    System.out.println("Tipo: " + tipoCarta);
                } else {
                    System.out.println("Error: " + carta + " no esta.");
                }
            }
            if (option == 3){
                Map<String, Integer> usuarioCartas = mapaCarta.getUsuarioCartas();
                if (usuarioCartas.isEmpty()) {
                    System.out.println("Esta vacio.");
                } else {
                    System.out.println("Su coleccion:");
                    for (Map.Entry<String, Integer> entry : usuarioCartas.entrySet()) {
                        String nombreCartaEntrada = entry.getKey();
                        int cuentaCartaEntrada = entry.getValue();
                        System.out.println(nombreCartaEntrada + " " + cuentaCartaEntrada + " ");
                    }
                }
            }
            if (option == 4){
                Map<String, Integer> usuarioCartasTipo = mapaCarta.getUsuarioCartasTipo();
                if (usuarioCartasTipo.isEmpty()) {
                    System.out.println("Esta Vacio.");
                } else {
                    System.out.println("Su colleccion:");
                    for (Map.Entry<String, Integer> entrada : usuarioCartasTipo.entrySet()) {
                        String tipoEntrada = entrada.getKey();
                        int cuentaEntrada = entrada.getValue();
                        System.out.println(tipoEntrada + " " + cuentaEntrada + " ");
                    }
                }
            }
            if (option == 5){
                Map<String, String> allCards = mapaCarta.getCartas();
                if (allCards.isEmpty()) {
                    System.out.println("No hay cartas disponibles.");
                } else {
                    System.out.println("Cartas disponibles");
                    for (Map.Entry<String, String> entrada : allCards.entrySet()) {
                        String nombreEntrada = entrada.getKey();
                        String tipoEntrada = entrada.getValue();
                        System.out.println(nombreEntrada + " " + tipoEntrada + " ");
                    }
                }
            }
            if (option == 6){
                Map<String, String> allCardsByType = mapaCarta.getTCartasTipo();
                if (allCardsByType.isEmpty()) {
                    System.out.println("No hay cartas disponibles.");
                } else {
                    System.out.println("Cartas Disponibles:");
                    for (Map.Entry<String, String> entrada : allCardsByType.entrySet()) {
                        String tipoEntrada = entrada.getKey();
                        String nombreEntrada = entrada.getValue();
                        System.out.println(tipoEntrada + ": " + nombreEntrada);
                    }
                }
            }
        }
    }
    public static void leerArchivo(CartaMap cardMap){
        Scanner scanner = new Scanner(System.in);
        
        // Poner la direccion exacta del documento en su computadora.
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Alexis Mesias/OneDrive/uvg3r/algoritmos/ht6/cards_desc.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] cardData = line.split("\\|");
                String cardName = cardData[0].trim();
                String cardType = cardData[1].trim();
                cardMap.getCartas().put(cardName, cardType);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
    }
    public static CartaMap CartaMap(String mapType) {
        switch (mapType) {
            case "1":return new HashMapCards();
            case "2":return new TreeMapCards();
            case "3":return new LinkedHashMapCards();
            default:throw new IllegalArgumentException("Invalid Map Type: " + mapType);
        }
    }
}

           
           
