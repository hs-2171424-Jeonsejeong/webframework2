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
    // 수강년도
    private int year;

    // 학기
    private int semester;

    // 교과 코드
    @NotEmpty
    @Size(min=2, max=100)
    private String courseCode;

    // 교과목명
    @NotEmpty
    private String courseTitle;

    // 교과구분(전필 / 전선 등)
    private String courseType;

    // 담당교수
    @NotEmpty
    private String professor;

    // 학점
    private int credits;
}

/*
CREATE TABLE `Course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `year` INT NOT NULL,
  `semester` INT NOT NULL,
  `course_code` VARCHAR(10) NOT NULL,
  `course_title` VARCHAR(255) NOT NULL,
  `course_type` VARCHAR(255),
  `professor` VARCHAR(255) NOT NULL,
  `credits` INT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

*/