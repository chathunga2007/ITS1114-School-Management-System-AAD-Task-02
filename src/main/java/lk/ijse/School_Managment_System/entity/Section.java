package lk.ijse.School_Managment_System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectionId;
    private String description;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Student> studentList;
}