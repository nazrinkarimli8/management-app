package az.edu.turing.managementapp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("userss")
public class User {

    @Id
    private Long id;
    private String username;
    private int age;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String profilePhoto;
}