package dto;

public class Board {
	private Integer num;
	private String subject;
	private String content;
	private String writer;
	private String filename;
	
	public Board() {
	
	}
	
	public Board(Integer num, String subject, String content, String writer,String filename) {
		super();
		this.num = num;
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", filename=" + filename + "]";
	}
	

	
	
}
