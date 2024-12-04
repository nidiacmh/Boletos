package servicio;

import modelo.Boleto;
import modelo.Usuario;
import modelo.Vuelo;

public interface IreservarBoleto {

    Boleto reservar(Vuelo vuelo, Usuario usuario) throws Exception;
    Vuelo restarDisponibilidad(Vuelo vuelo);
    boolean verificarDisponibilidad(Vuelo vuelo);
}
