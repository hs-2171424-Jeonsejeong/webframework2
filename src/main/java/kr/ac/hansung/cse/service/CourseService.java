package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseDao;
import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    //그룹별로 보는함수.
    public List<Course> getCourseGroupBySemester() {
        return courseDao.getCourseGroupBySemester();
    }

    public List<Course> getSemesterCurrent(String year, int semester) {
        return courseDao.getSemesterCourses(year, semester);
    }

    public void insert(Course course) {
        courseDao.insert(course);
    }
}
