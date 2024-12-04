package modelo;

import java.util.UUID;

public class Boleto {
    private UUID id;
    private  float costo;
    private boolean pagado;
    private Usuario usuario;

    public Boleto(float costo, Usuario usuario) {
        this.id = UUID.randomUUID();
        this.costo = costo;
        this.pagado = false;
        this.usuario =usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
}
