package systema.crm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_applicationRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "commentary", columnDefinition = "text")
    private String commentary;

    @Column(name = "phone", length = 12)
    private String phone;

    @Column(name = "handled")
    private Boolean handled;

    @ManyToOne(fetch = FetchType.EAGER)
    private Courses courseName;
}
