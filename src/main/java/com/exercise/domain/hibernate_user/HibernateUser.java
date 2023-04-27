package com.exercise.domain.hibernate_user;


import com.exercise.domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name = "users")
public class HibernateUser {

    @Id
    @GeneratedValue(generator = "users_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_sec",
            allocationSize = 1, initialValue = 200)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(name = "date_birth")
    private Timestamp dateBirth;

    @Column
    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.NOT_SELECTED;

    @Column
    private Integer height;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "created")
    private Timestamp created = Timestamp.valueOf(LocalDateTime.now());

    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
