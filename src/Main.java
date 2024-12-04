import modelo.Boleto;
import modelo.Usuario;
import modelo.Vuelo;
import servicio.IconfirmarVuelo;
import servicio.IreservarBoleto;
import servicio.IsolicitarPago;
import servicio.impl.ConfirmarVuelo;
import servicio.impl.GenerarVuelos;
import servicio.impl.ReservarBoleto;
import servicio.impl.SolicitarPago;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // creamos unos cuantos usuarios
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Carlos Mendoza", "carlos.mendoza@example.com", "555-123-4567"));
        usuarios.add(new Usuario("María López", null, "555-987-6543"));
        usuarios.add(new Usuario("Ana Torres", "ana.torres@example.com", null));
        usuarios.add(new Usuario("Caro Meza", null, null));

        // creamos una lista de vuelos
        List<Vuelo> vuelos = GenerarVuelos.generarVuelosAleatorios();

        usuarios.forEach( usuario -> {
            Vuelo vueloSeleccionado = GenerarVuelos.seleccionarVueloAleatorio(vuelos);
            IreservarBoleto reserva = new ReservarBoleto();
                    try {
                        Boleto boleto = reserva.reservar(vueloSeleccionado, usuario);
                        IsolicitarPago pago = new SolicitarPago();
                        pago.pagar(boleto);

                        if(boleto.isPagado()) {
                            IconfirmarVuelo confirmarVuelo = new ConfirmarVuelo();
                            confirmarVuelo.notificarUsuario(boleto);
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
            System.out.println("____________________________________");
                }
        );
    }
}