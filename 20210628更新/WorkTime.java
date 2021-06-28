package bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;

//work_timeテーブルのBean(出勤情報)
public class WorkTime implements Serializable {

	private String employeeCode; //従業員コード
	private Date workDate; //出勤日
	private Time startTime; //出勤時刻
	private Time finishTime; //退勤時刻
	private Duration workingHours; //勤務時間

	public String getEmployeeCode() {
		return employeeCode;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getFinishTime() {
		return finishTime;
	}

	public Duration getWorkingHours() {
		return workingHours;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public void setFinishTime(Time finishTime) {
		this.finishTime = finishTime;
	}

	public void setWorkingHours(Duration workingHours) {
		this.workingHours = workingHours;
	}

}
