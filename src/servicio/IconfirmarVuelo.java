package servicio;

import modelo.Boleto;

public interface IconfirmarVuelo {
    void notificarUsuario(Boleto boleto) throws Exception;
}
