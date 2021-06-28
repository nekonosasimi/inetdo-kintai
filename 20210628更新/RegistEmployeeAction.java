package action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import tool.Action;

//従業員情報の登録を行うアクションクラス
public class RegistEmployeeAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//セッションの取得
		HttpSession session = request.getSession();

		//ログインしているかのチェック
		if(session.getAttribute("userId") != null) {
			//m_employeeテーブルのDAOクラス使用準備
			EmployeeDAO dao = new EmployeeDAO();

			boolean insertUserChkFlag = false; //登録成功判定用変数

			//入力情報の取得
			String lastName = request.getParameter("lastName");
			String firstName = request.getParameter("firstName");
			String lastKanaName = request.getParameter("lastKanaName");
			String firstKanaName = request.getParameter("firstKanaName");
			int gender = Integer.parseInt(request.getParameter("gender"));
			Date birthDay = Date.valueOf(request.getParameter("birthDay"));
			String sectionCode = request.getParameter("sectionCode");
			Date hireDate = Date.valueOf(request.getParameter("hireDate"));
			String password = request.getParameter("password");

			try {
				//入力情報の登録
				boolean insertChk = dao.insertEmployee(lastName, firstName, lastKanaName, firstKanaName, gender,
						birthDay, sectionCode, hireDate, password);

				//登録が成功したかチェック
				if(insertChk) {
					insertUserChkFlag = true;
				}

			} catch(Exception e) {
				e.printStackTrace();
			}

			//登録の正否による分岐
			if(insertUserChkFlag) {
				return "completion.jsp";
			} else {
				return "regist_employee_error.jsp";
			}

		} else {
			return "../action/user_login.jsp";
		}
	}

}
