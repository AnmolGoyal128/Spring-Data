package in.springBoot.JpaRelationship.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id",
                nullable = false
    )
    private Department department;
}
