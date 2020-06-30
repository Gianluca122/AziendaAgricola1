package Entity.Entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name= "Bovini", schema="public")
public class Bovino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Matricola", nullable = false)
    private int Matricola;
    @Basic
    @Column(name = "Data di nascita", nullable = false)
    private int Data_di_nascita;
    @Basic
    @Column(name = "Sesso", nullable = false)
    private String Sesso;

    public int getMatricola() {
        return Matricola;
    }

    public int getData_di_nascita() {
        return Data_di_nascita;
    }

    public String getSesso() {
        return Sesso;
    }

    public void setMatricola(int matricola) {
        Matricola = matricola;
    }

    public void setData_di_nascita(int data_di_nascita) {
        Data_di_nascita = data_di_nascita;
    }

    public void setSesso(String sesso) {
        Sesso = sesso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bovino)) return false;
        Bovino bovino = (Bovino) o;
        return getMatricola() == bovino.getMatricola() &&
                getData_di_nascita() == bovino.getData_di_nascita() &&
                Objects.equals(getSesso(), bovino.getSesso());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricola(), getData_di_nascita(), getSesso());
    }
}
