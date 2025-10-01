import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Boolean estaReservado;

    @OneToMany(mappedBy = "equipamento")
    private List<Reserva> reservas;

}