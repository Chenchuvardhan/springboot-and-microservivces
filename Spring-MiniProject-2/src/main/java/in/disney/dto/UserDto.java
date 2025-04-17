package in.disney.dto;

import lombok.Data;

@Data
public class UserDto {
	private Integer userId;
	private String name;
	private String email;
	private String phno;
	private String password;
	private String passwordStatus;
	private Integer cid;
	private Integer sid;
	private Integer cityId;
}
