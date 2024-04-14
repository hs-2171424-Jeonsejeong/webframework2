package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {

    private int year;

    private int semester;

    @NotEmpty
    @Size(min=2, max=100)
    private String courseCode;

    @NotEmpty
    private String courseTitle;

    private String courseType;

    @NotEmpty
    private String professor;

    private int credits;
}

