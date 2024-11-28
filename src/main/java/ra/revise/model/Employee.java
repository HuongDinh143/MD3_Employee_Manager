package ra.revise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @Column(name = "emp_id", columnDefinition = "char(5)")
    private String empId;
    @Column(name = "emp_name", columnDefinition = "varchar(50)", nullable = false)
    private String empName;
    @Column(name = "emp_age", nullable = false)
    private int age;
    @Column(name = "emp_sex", nullable = false)
    private boolean sex;
    @Column(name = "emp_email", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String empEmail;
    @Column(name = "emp_phone", columnDefinition = "varchar(10)", nullable = false, unique = true)
    private String empPhone;
    @Column(name = "emp_address", columnDefinition = "text", nullable = false)
    private String empAddress;
    @Column(name = "emp_status", columnDefinition = "int", nullable = false)
    private int empStatus;
    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    private Department department;

}
