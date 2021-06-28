package bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;

//work_breakテーブルのBean(休憩情報)
public class WorkBreak implements Serializable {

	private String employeeCode; //従業員コード
	private Date workDate; //出勤日
	private Time breakStartTime; //休憩開始時刻
	private Time breakFinishTime; //休憩終了時刻
	private Duration breakTime; //休憩時間

	public String getEmployeeCode() {
		return employeeCode;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public Time getBreakStartTime() {
		return breakStartTime;
	}

	public Time getBreakFinishTime() {
		return breakFinishTime;
	}

	public Duration getBreakTime() {
		return breakTime;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public void setBreakStartTime(Time breakStartTime) {
		this.breakStartTime = breakStartTime;
	}

	public void setBreakFinishTime(Time breakFinishTime) {
		this.breakFinishTime = breakFinishTime;
	}

	public void setBreakTime(Duration breakTime) {
		this.breakTime = breakTime;
	}

}
