package servicio.impl;

import modelo.Boleto;
import servicio.IconfirmarVuelo;

public class ConfirmarVuelo implements IconfirmarVuelo {
    @Override
    public void notificarUsuario(Boleto boleto) throws Exception {
        if (boleto.getUsuario().getCorreo() != null){
            System.out.println("Se envio un correo de confirmacion a la direccion: " + boleto.getUsuario().getCorreo());
        }else if (boleto.getUsuario().getTelefono() != null){
            System.out.println("Se envio un sms de confirmacion al: " + boleto.getUsuario().getTelefono());
        }else {
            throw new Exception("El usuario no completo sus datos de contacto");
        }
    }
}
