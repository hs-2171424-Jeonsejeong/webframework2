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
public class User {
    private int id;

    @Size(min = 2, max = 30, message = "Username must be between 2 and 30 characters")
    private String username;

    @Size(min = 2, max = 200, message = "Email must be between 2 and 200 characters")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 5, max = 100, message = "Password must be between 5 and 100 characters")
    private String password;
}
/*

CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL CHECK (CHAR_LENGTH(username) >= 2),
    email VARCHAR(200) NOT NULL CHECK (CHAR_LENGTH(email) >= 2),
    password VARCHAR(100) NOT NULL CHECK (CHAR_LENGTH(password) >= 5)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

*/