package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @NotBlank(message = "title filed in task entity is blank")
    @Size(min = 3 , max = 40,message = "title size should be [3,20]")
    private String title;


    @NotBlank(message = "description filed in task entity is blank")
    @Size(min = 10 , max = 50, message = "description size should be [10,50]")
    private String description;

    @NotNull(message = "date filed in task entity is null")
    @Future(message = "due date should be in future in task entity")
    private Date dueDate;

    @Size(min = 4 , max = 10,message = "status size should be [4,10]")
    @NotBlank(message = "status filed in task entity is blank")
    private String status;
}
