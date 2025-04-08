package vo;

// 자바빈의 규칙
// 필수 - 클래스명: public, 맴버변수(프로퍼티): private, getter/setter, 생성자: 기본 생성자
// 권장 - toString()

// < Member 테이블 설계 >
// -- id, pwd, username, nickname, age, birthday, job, email, phone, address, reg_date
// 날짜 타입: String 형으로 처리
public class Member {
	private String id;
	private String pwd;
	private String username;
	private String nickname;
	private int age;
	private String birthday;
	private String job;
	private String email;
	private String phone;
	private String address;
	private String reg_date;

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getUsername() {
		return username;
	}

	public String getNickname() {
		return nickname;
	}

	public int getAge() {
		return age;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getJob() {
		return job;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", username=" + username + ", nickname=" + nickname + ", age="
				+ age + ", birthday=" + birthday + ", job=" + job + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", reg_date=" + reg_date + "]";
	}

}
