package beans;

public class Student {
	private int sid;
	private String sname,semail;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", semail="
				+ semail + ", getSid()=" + getSid() + ", getSname()="
				+ getSname() + ", getSemail()=" + getSemail() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	

}
