package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses/semester")
    public String showSemesterCourses(@RequestParam String year,
                                      @RequestParam int semester, Model model) {
        List <Course> courses = courseService.getSemesterCurrent(year, semester);
        model.addAttribute("courses", courses);

        return "semester"; //view를 만들어준다.
    }

    // 1) 그룹 단위로 볼수 있는 화면
    @RequestMapping("/grade-credit")
    public String showSemesterCourses(Model model) {
        List <Course> courses = courseService.getCourseGroupBySemester();
        model.addAttribute("courses", courses);
        return "gradecredit";
    }
    // 1-1) 연도/학기 선택시
    @RequestMapping("/grade-credit/detail/{year}/{semester}")
    public String showSemesterCoursesDetail(@PathVariable String year,
                                            @PathVariable int semester, Model model) {
        List<Course> courses = courseService.getSemesterCurrent(year, semester);
        model.addAttribute("courses", courses);

        return "gradecreditdetail"; // view를 만들어준다.
    }
    // 2) 수강신청하기
    @RequestMapping("/register-course")
    public String showRegister(Model model) {
        Course crs = new Course();
        crs.setCredits(3);
        model.addAttribute("course", new Course());
        return "register";
    }
    // 2-1) 수강신청 처리
    @RequestMapping("/register-submit")
    public String registerSubmit(Model model, @Valid Course course, BindingResult result) { //DB에 저장해야함
        course.setYear(2024);
        course.setSemester(2);
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "register"; //다시 입력을 받게 보냄
        }

        courseService.insert(course); //수강신청하기.
        return "registersuccess"; //view를 만들어준다. 웹폼을 만든다.
    }
}
