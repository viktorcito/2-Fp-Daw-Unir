package cajeroweb.modelo.entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cuentas")
@Data // Genera getters, setters, toString, equals y hashCode
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cuenta")
    private int idCuenta;

    private double saldo;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
}
