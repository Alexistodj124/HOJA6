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
        
            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre de la carta:");
                    String nombreCarta = scanner.nextLine().trim();
                    mapaCarta.agregarCarta(nombreCarta, mapaCarta.getCartas().get(nombreCarta));
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la carta:");
                    String carta = scanner.nextLine().trim();
                    String tipoCarta = mapaCarta.getTipo(carta);
                    if (tipoCarta != null) {
                        System.out.println("Tipo: " + tipoCarta);
                    } else {
                        System.out.println("Error: " + carta + " no esta.");
                    }
                    break;
                case 3:
                    Map<String, Integer> usuarioCartas = mapaCarta.getUsuarioCartas();
                    if (usuarioCartas.isEmpty()) {
                        System.out.println("Esta vacio.");
                    } else {
                        System.out.println("Su coleccion:");
                        for (Map.Entry<String, Integer> entry : usuarioCartas.entrySet()) {
                            String nombreCartaEntrada = entry.getKey();
                            int cuentaCartaEntrada = entry.getValue();
                            System.out.println(nombreCartaEntrada + " (" + cuentaCartaEntrada + ")");
                        }
                    }
                    break;
                case 4:
                    Map<String, Integer> usuarioCartasTipo = mapaCarta.getUsuarioCartasTipo();
                    if (usuarioCartasTipo.isEmpty()) {
                        System.out.println("Esta Vacio.");
                    } else {
                        System.out.println("Su colleccion:");
                        for (Map.Entry<String, Integer> entry : usuarioCartasTipo.entrySet()) {
                            String cardTypeEntry = entry.getKey();
                            int cardCountEntry = entry.getValue();
                            System.out.println(cardTypeEntry + " (" + cardCountEntry + ")");
                        }
                    }
                    break;
                case 5:
                    Map<String, String> allCards = mapaCarta.getCartas();
                    if (allCards.isEmpty()) {
                        System.out.println("No Cards Available.");
                    } else {
                        System.out.println("All Available Cards:");
                        for (Map.Entry<String, String> entry : allCards.entrySet()) {
                            String cardNameEntry = entry.getKey();
                            String cardTypeEntry = entry.getValue();
                            System.out.println(cardNameEntry + " (" + cardTypeEntry + ")");
                        }
                    }
                    break;
                case 6:
                    Map<String, String> allCardsByType = mapaCarta.getTCartasTipo();
                    if (allCardsByType.isEmpty()) {
                        System.out.println("No Cards Available.");
                    } else {
                        System.out.println("All Available Cards:");
                        for (Map.Entry<String, String> entry : allCardsByType.entrySet()) {
                            String cardTypeEntry = entry.getKey();
                            String cardNamesEntry = entry.getValue();
                            System.out.println(cardTypeEntry + ": " + cardNamesEntry);
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option.");
                    break;
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

           
