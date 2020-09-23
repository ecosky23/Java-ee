package guestbook.bean;

import lombok.Data;

@Data
public class GuestbookDTO {//롬복 lombok
	private String name;
	private String email;
	private String homepage;
	private String title;
	private String content;
	private String logtime;
	private int seq;

}
