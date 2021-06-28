package bean;

import java.io.Serializable;
import java.sql.Date;

//m_employeeテーブルのBean(従業員情報)
public class Employee implements Serializable {

	//※生年月日、入社日は日付型で取り扱う予定

	private String code; //従業員コード
	private String lastName; //苗字
	private String firstName; //名前
	private String lastKanaName; //かな苗字
	private String firstKanaName; //かな名前
	private int gender; //性別(0=男,1=女)
	private Date birthDay; //生年月日
	private String sectionCode; //部署コード
	private Date hireDate; //入社日
	private String password; //パスワード

	public String getCode() {
		return code;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastKanaName() {
		return lastKanaName;
	}

	public String getFirstKanaName() {
		return firstKanaName;
	}

	public int getGender() {
		return gender;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public String getpassword() {
		return password;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastKanaName(String lastKanaName) {
		this.lastKanaName = lastKanaName;
	}

	public void setFirstKanaName(String firstKanaName) {
		this.firstKanaName = firstKanaName;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public void setpassword(String password) {
		this.password = password;
	}

}
