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
