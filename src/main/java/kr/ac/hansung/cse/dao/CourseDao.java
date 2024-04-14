package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public Course getCourse(String courseCode) {
        String sqlStatement = "select * from course where course_code=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[]{courseCode}, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseTitle(rs.getString("course_title"));
                course.setCourseType(rs.getString("course_type"));
                course.setProfessor(rs.getString("professor"));
                course.setCredits(rs.getInt("credits"));
                return course;
            }
        });
    }


    public List<Course> getCourses() {
        String sqlStatement = "select * from course";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseTitle(rs.getString("course_title"));
                course.setCourseType(rs.getString("course_type"));
                course.setProfessor(rs.getString("professor"));
                course.setCredits(rs.getInt("credits"));
                return course;
            }
        });
    }



    public List<Course> getSemesterCourses(String year, int semester) {
        String sqlStatement = "select * from course WHERE year=" + year + " and semester =" + semester;

        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                Course course = new Course();
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseTitle(rs.getString("course_title"));
                course.setCourseType(rs.getString("course_type"));
                course.setProfessor(rs.getString("professor"));
                course.setCredits(rs.getInt("credits"));

                return course;
            }

        });
    }


    public List<Course> getCourseGroupBySemester() {
        String sqlStatement = "select year, semester, sum(credits) from course group by year, semester order by year";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCredits(rs.getInt("sum(credits)"));
                return course;
            }
        });
    }


    public boolean insert(Course course) {
        String sqlStatement = "insert into course (year, semester, course_code, course_title, course_type, professor, credits) values (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sqlStatement, course.getYear(), course.getSemester(), course.getCourseCode(),
                course.getCourseTitle(), course.getCourseType(), course.getProfessor(), course.getCredits()) == 1;
    }


    public boolean update(Course course) {
        String sqlStatement = "update course set year=?, semester=?, course_title=?, course_type=?, professor=?, credits=? where course_code=?";
        return jdbcTemplate.update(sqlStatement, course.getYear(), course.getSemester(), course.getCourseTitle(),
                course.getCourseType(), course.getProfessor(), course.getCredits(), course.getCourseCode()) == 1;
    }


    public boolean delete(String courseCode) {
        String sqlStatement = "delete from course where course_code=?";
        return jdbcTemplate.update(sqlStatement, courseCode) == 1;
    }
}
