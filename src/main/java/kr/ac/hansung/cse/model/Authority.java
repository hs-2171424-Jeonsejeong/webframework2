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
public class Authority {
    private int id;

    @Size(min = 2, max = 30, message = "Username must be between 2 and 30 characters")
    private String username;

    @Size(min = 2, max = 200, message = "Authority must be between 2 and 200 characters")
    private String authority;
}
/*

CREATE TABLE Authority (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL CHECK (CHAR_LENGTH(username) >= 2),
    authority VARCHAR(200) NOT NULL CHECK (CHAR_LENGTH(authority) >= 2)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

*/