import java.util.*;
public class TreeMapCards implements CartaMap {
    private Map<String, String> todCarta = new TreeMap<>();
    private Map<String, Integer> usuarioCarta = new TreeMap<>();
    private Map<String, Integer> usuarioCartasTipo = new TreeMap<>();


    @Override
    public String getTipo(String nombreCarta) {return todCarta.get(nombreCarta);}

    @Override
    public Map<String, Integer> getUsuarioCartas() {return usuarioCarta;}

    @Override
    public Map<String, Integer> getUsuarioCartasTipo() {return usuarioCartasTipo;}

    @Override
    public Map<String, String> getCartas() {return todCarta;}

    @Override
    public Map<String, String> getTCartasTipo() {
        Map<String, String> cartasTipo = new TreeMap<>();
        for (Map.Entry<String, String> entrada : todCarta.entrySet()) {
            String nombreCarta = entrada.getKey();
            String tipoCarta = entrada.getValue();
            cartasTipo.merge(tipoCarta, nombreCarta, (vieja, nueva) -> vieja + ", " + nueva);
        }
        return cartasTipo;
    }
    @Override
    public void agregarCarta(String nombreCarta, String tipoCarta) {
        if (todCarta.containsKey(nombreCarta)) {
            usuarioCarta.merge(nombreCarta, 1, Integer::sum);
        } else {
            System.out.println("Error: " + nombreCarta + " no esta.");
        }
        usuarioCartasTipo.merge(tipoCarta, 1, Integer::sum);
    }

}
