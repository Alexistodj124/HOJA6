import java.util.*;
public class LinkedHashMapCards implements CartaMap {
    private Map<String, String> todCartas = new LinkedHashMap<>();
    private Map<String, Integer> usuarioCartas = new LinkedHashMap<>();
    private Map<String, Integer> usuarioCartasTipo = new LinkedHashMap<>();

    @Override
    public String getTipo(String cardName) {return todCartas.get(cardName);}

    @Override
    public Map<String, Integer> getUsuarioCartas() {return usuarioCartas;}

    @Override
    public Map<String, Integer> getUsuarioCartasTipo() {return usuarioCartasTipo;}

    @Override
    public Map<String, String> getCartas() {return todCartas;}

    @Override
    public void agregarCarta(String nombreCarta, String tipoCarta) {
        if (todCartas.containsKey(nombreCarta)) {
            usuarioCartas.merge(nombreCarta, 1, Integer::sum);
        } else {
            System.out.println("Error: " + nombreCarta + " no esta.");
        }
        usuarioCartasTipo.merge(tipoCarta, 1, Integer::sum);
    }


    @Override
    public Map<String, String> getTCartasTipo() {
        Map<String, String> allCardsByType = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : todCartas.entrySet()) {
            String nombreCarta = entry.getKey();
            String tipoCarta = entry.getValue();
            allCardsByType.merge(tipoCarta, nombreCarta, (vieja, nueva) -> vieja + ", " + nueva);
        }
        return allCardsByType;
    }
}