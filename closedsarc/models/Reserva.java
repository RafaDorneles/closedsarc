import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turmaID", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "salaID")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "equipamentoID")
    private Equipamento equipamento;

    @Column(nullable = false)
    private LocalDateTime data;

}