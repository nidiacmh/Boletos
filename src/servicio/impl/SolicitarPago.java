package servicio.impl;

import modelo.Boleto;
import servicio.IsolicitarPago;

import java.util.Random;

public class SolicitarPago implements IsolicitarPago {
    private static final Random random = new Random();
    @Override
    public Boleto pagar(Boleto boleto) {
        if (verificarPago(boleto)){
            System.out.println("Pago confirmado");
            return modificarStatus(boleto);
        }
        System.out.println("El pago no pudo ser procesado");
        return boleto;
    }

    @Override
    public boolean verificarPago(Boleto boleto) {
        // return true; // si quieres que el pago siempre pase
        // return false; // si quieres que el pago nunca pase
        return random.nextInt(10)+1 <= 6; // si quieres que el pago a veces pase
    }

    @Override
    public Boleto modificarStatus(Boleto boleto) {
        boleto.setPagado(true);
        return boleto;
    }
}
