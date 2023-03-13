import java.util.*;

public class HashMapCards implements CartaMap {
    private Map<String, String> todCartas = new HashMap<>();
    private Map<String, Integer> usuarioCartas = new HashMap<>();
    private Map<String, Integer> usuarioCartasTipo = new HashMap<>();

    @Override
    public String getTipo(String nombreCarta) {return todCartas.get(nombreCarta);}

    @Override
    public Map<String, Integer> getUsuarioCartas() {return usuarioCartas;}

    @Override
    public Map<String, Integer> getUsuarioCartasTipo() {return usuarioCartasTipo;}

    @Override
    public Map<String, String> getCartas() {return todCartas;}

    @Override
    public Map<String, String> getTCartasTipo() {
        Map<String, String> cartasTipo = new HashMap<>();
        for (Map.Entry<String, String> entry : todCartas.entrySet()) {
            String nombreCarta = entry.getKey();
            String tipoCarta = entry.getValue();
            cartasTipo.merge(tipoCarta, nombreCarta, (vieja, nueva) -> vieja + ", " + nueva);
        }
        return cartasTipo;
    }
    @Override
    public void agregarCarta(String cardName, String cardType) {
        if (todCartas.containsKey(cardName)) {
            usuarioCartas.merge(cardName, 1, Integer::sum);
        } else {
            System.out.println("Error: " + cardName + " no esta.");
        }
        usuarioCartasTipo.merge(cardType, 1, Integer::sum);
    }
}