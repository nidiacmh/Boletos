package servicio.impl;

import modelo.Boleto;
import modelo.Usuario;
import modelo.Vuelo;
import servicio.IreservarBoleto;

public class ReservarBoleto implements IreservarBoleto {
    @Override
    public Boleto reservar(Vuelo vuelo, Usuario usuario) throws Exception {
        System.out.println("Procesando vuelo para " + usuario.getNombre());
        System.out.println(vuelo);
        if (verificarDisponibilidad(vuelo)){
            Boleto boleto = new Boleto(350.00f, usuario);
            restarDisponibilidad(vuelo);
            return boleto;
        }
        throw new Exception("Ya no hay boletos disponibles para ese vuelo");
    }

    @Override
    public Vuelo restarDisponibilidad(Vuelo vuelo) {
        int disponibilidad = vuelo.getDisponibilidad() - 1;
        vuelo.setDisponibilidad(disponibilidad);
        return vuelo;
    }

    @Override
    public boolean verificarDisponibilidad(Vuelo vuelo) {
        return vuelo.getDisponibilidad()>0;
    }

}
