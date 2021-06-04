package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;
import dao.EmployeeDAO;
import tool.Action;

//従業員情報を更新するアクション
public class EditEmployeeAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//セッションの取得
		HttpSession session = request.getSession();

		//ログインしているかのチェック
		if(session.getAttribute("userId") != null) {
			Employee employee = (Employee) session.getAttribute("employee"); //従業員情報格納用変数
			boolean updateChk = false; //更新成功チェック用

			//編集した従業員情報を取得
			employee.setCode(request.getParameter("employeeCode"));
			employee.setLastName(request.getParameter("lastName"));
			employee.setFirstName(request.getParameter("firstName"));
			employee.setLastKanaName(request.getParameter("lastKanaName"));
			employee.setFirstKanaName(request.getParameter("firstKanaName"));
			employee.setGender(Integer.parseInt(request.getParameter("gender")));
			employee.setBirthDay(request.getParameter("birthDay"));
			employee.setSectionCode(request.getParameter("sectionCode"));
			employee.setHireDate(request.getParameter("hireDate"));
			//employee.setpassword(request.getParameter("password"));

			//DAOクラス使用準備
			EmployeeDAO dao = new EmployeeDAO();

			//従業員情報の更新
			try {
				updateChk = dao.updateEmployee(employee);
			} catch(Exception e) {
				e.printStackTrace();
			}

			session.removeAttribute("employeeCode");
			session.setAttribute("employee", employee);

			//更新の成否により分岐
			if(updateChk) {
				return "edit_completion.jsp";
			} else {
				return "edit_employee_error.jsp";
			}

		} else {
			return "../action/user.login.jsp";
		}

	}

}
