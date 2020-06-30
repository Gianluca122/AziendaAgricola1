package Entity.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({@NamedQuery(name = "getMacchine", query = "select m from MacchineAgricole m")})
public class MacchineAgricole {
    private String Targa;
    private String Modello;
    private int NumeroTelaio;

    @Id
    @Column(name = "Targa")
    public String getTarga() {
        return Targa;
    }

    public void setTarga(String Targa) {
        Targa = Targa;
    }

    @Basic
    @Column(name = "Modello", nullable = false)
    public String getModello() {
        return Modello;
    }

    public void setModello(String Modello) {
        Modello = Modello;
    }

    @Basic
    @Column(name = "Numero Telaio", nullable = false)
    public int getNumeroTelaio() {
        return NumeroTelaio;
    }

    public void setNumeroTelaio(int NumeroTelaio) {
        NumeroTelaio = NumeroTelaio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MacchineAgricole that = (MacchineAgricole) o;
        return NumeroTelaio == that.NumeroTelaio &&
                Objects.equals(Targa, that.Targa) &&
                Objects.equals(Modello, that.Modello);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Targa, Modello, NumeroTelaio);
    }
}
