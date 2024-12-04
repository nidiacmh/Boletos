package servicio;

import modelo.Boleto;

public interface IsolicitarPago {
    Boleto pagar(Boleto boleto);
    boolean verificarPago(Boleto boleto);
    Boleto modificarStatus(Boleto boleto);

}
