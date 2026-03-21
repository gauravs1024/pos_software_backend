package com.g.pos_software.models;

import com.g.pos_software.domain.StoreStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Store {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @OneToOne
    private User storeAdmin;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private  String description;
    private String storeType;

    @Enumerated(EnumType.STRING)        /// This will make the status to store as Enum type in db
    private StoreStatus status;
      /*
    By default, JPA uses EnumType.ORDINAL,
     which maps the position of the enum to an integer.
      To store the string value, you must explicitly set it to EnumType.STRING.
    * */

    @Embedded
    private StoreContact contact;


    @PrePersist
    protected void onCreate(){
        createdAt=LocalDateTime.now();
        status=StoreStatus.PENDING;
    }
    @PreUpdate
    protected void onUpdate(){
        updatedAt=LocalDateTime.now();

    }

}
