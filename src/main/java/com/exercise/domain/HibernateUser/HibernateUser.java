package com.exercise.domain.HibernateUser;


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
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name = "users")
public class HibernateUser {

    @Id
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

    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
