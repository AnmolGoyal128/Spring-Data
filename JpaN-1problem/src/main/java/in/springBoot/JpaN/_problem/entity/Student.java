package in.springBoot.JpaN._problem.entity;

import in.springBoot.JpaN._problem.entity.Department;
import in.springBoot.JpaN._problem.entity.Profile;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "department_id",
                nullable = false
    )
    private Department department;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

//    private void addDepartment(Department department){
//        this.department = department;
//        this.department.getStudentList().add(this);
//    }
//    private void removeDepartment(Department department){
//        this.department = null;
//        this.department.remove(this);
//    }
}
