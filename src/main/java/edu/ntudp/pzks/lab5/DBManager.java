package edu.ntudp.pzks.lab5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final String URL = "jdbc:sqlite:database.sqlite";

    public List<Student> getStudentsByBirthMonth(int month) {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students WHERE substr(birth_date, 6, 2) = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String monthFormatted = String.format("%02d", month);
            stmt.setString(1, monthFormatted);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        rs.getString("birth_date"),
                        rs.getString("record_book_num")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Помилка при отриманні студентів", e);
        }
        return students;
    }
}