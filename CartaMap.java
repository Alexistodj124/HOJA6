import java.util.*;

public interface CartaMap {
    void agregarCarta(String nombreCarta, String tipoCarta);
    String getTipo(String nombreCarta);
    Map<String, String> getCartas();
    Map<String, Integer> getUsuarioCartas();
    Map<String, String> getTCartasTipo();
    Map<String, Integer> getUsuarioCartasTipo();
}