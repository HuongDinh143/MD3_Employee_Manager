package ra.revise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    @Column(name = "dept_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String deptName;
    @Column(name = "dept_no", columnDefinition = "char(4)", nullable = false)
    private String deptNo;
    @Column(name = "dept_status", columnDefinition = "bit", nullable = false)
    private boolean deptStatus;
    @OneToMany(mappedBy = "department")
    private List<Employee> listEmloyees = new ArrayList<>();
}
