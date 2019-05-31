package com.infopulse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
@Inheritance(strategy = TABLE_PER_CLASS)
public class Student {

    @Id
    @GenericGenerator(name = "increment1", strategy = "increment")
    @GeneratedValue(generator = "increment1")
    @Basic
    private Long id;

    @Column(name = "name", unique = false, nullable = false, length = 255)
    @Basic
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

 //   private GradePointAverage gradePointAverage;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


//    private Faculty faculty;
}
