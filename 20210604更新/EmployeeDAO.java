package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import bean.Employee;
import bean.Section;

//従業員情報登録のDAOクラス
public class EmployeeDAO extends DAO {

	//すべての部署情報の検索
	public List<Section> getSection() throws Exception {
		List<Section> sections = new LinkedList<Section>(); //部署情報格納用リスト

		//コネクションの取得
		Connection con = getConnection();

		//SQL文の実行(すべての部署情報を部署コード順で検索)
		String sql = "select * from section order by section_code";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		//検索結果をリストに格納
		while(rs.next()) {
			Section se = new Section();
			se.setCode(rs.getString(1));
			se.setName(rs.getString(2));
			sections.add(se);
		}

		//クローズ処理
		st.close();
		con.close();

		return sections;
	}

	//入力された値で従業員情報を登録
	public boolean insertEmployee(String lastName, String firstName, String lastKanaName, String firstKanaName, int gender,
			String birthDay, String sectionCode, String hireDate, String password) throws Exception {
		boolean insertUserChkFlag = false; //登録成功判定用変数
		//コネクションの取得
		Connection con = getConnection();

		//オートコミットの無効
		con.setAutoCommit(false);

		//SQL文の実行(従業員コードの最大値を取得)
		String sql = "select max(employee_code) from employee";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		String headCode; //コードの英字部分
		int footCode; //コードの数字部分
		String code; //登録する従業員コード

		//登録する情報の従業員コード作成
		if(rs.next() && rs.getString(1) != null) {
			headCode = rs.getString(1).substring(0, 1);
			footCode = Integer.parseInt(rs.getString(1).substring(1)) + 1;
			code = headCode + String.format("%03d", footCode);
		} else {
			code = "E" + String.format("%03d", 1);
		}

		//SQL文の実行(入力された従業員情報を登録)
		sql = "insert into employee values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		st = con.prepareStatement(sql);
		st.setString(1, code);
		st.setString(2, lastName);
		st.setString(3, firstName);
		st.setString(4, lastKanaName);
		st.setString(5, firstKanaName);
		st.setInt(6, gender);
		st.setString(7, birthDay);
		st.setString(8, sectionCode);
		st.setString(9, hireDate);
		st.setString(10, password);
		int line = st.executeUpdate();

		//登録の正否確認
		if(line > 0) {
			insertUserChkFlag = true;
			con.commit();
		} else {
			con.rollback();
		}

		//オートコミットの設定を戻す
		con.setAutoCommit(true);

		return insertUserChkFlag;
	}

	//指定した従業員コードの従業員情報を取得
	public Employee selectEmployee(String code) throws Exception {
		Employee employee = new Employee(); //従業員情報格納用変数

		//コネクションの取得
		Connection con = getConnection();

		//SQL文の実行(指定した従業員コードの従業員情報を検索)
		String sql = "select * from employee where employee_code = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, code);
		ResultSet rs = st.executeQuery();

		//検索結果の確認
		if(rs.next() && rs.getString(1).equals(code)) {
			//従業員データを戻り値に格納
			employee.setCode(rs.getString(1));
			employee.setLastName(rs.getString(2));
			employee.setFirstName(rs.getString(3));
			employee.setLastKanaName(rs.getString(4));
			employee.setFirstKanaName(rs.getString(5));
			employee.setGender(rs.getInt(6));
			employee.setBirthDay(rs.getString(7));
			employee.setSectionCode(rs.getString(8));
			employee.setHireDate(rs.getString(9));
			employee.setpassword(rs.getString(10));
		}

		//クローズ処理
		st.close();
		con.close();

		return employee;
	}

	//入力された値で従業員情報を更新
	public boolean updateEmployee(Employee employee) throws Exception {
		boolean updateChk = false; //更新成功チェック用

		//コネクションの取得
		Connection con = getConnection();

		//オートコミットの無効
		con.setAutoCommit(false);

		//SQL文の実行(指定した従業員コードの従業員情報を検索)
		String sql = "select * from employee where employee_code = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, employee.getCode());
		ResultSet rs = st.executeQuery();

		//検索結果の確認
		if(rs.next() && rs.getString(1).equals(employee.getCode())) {
			//SQL文の実行(検索した従業員コードの従業員情報を入力された情報で更新)
			sql = "update employee set last_name = ?, first_name = ?, last_kana_name = ?, first_kana_name = ?, " +
					"gender = ?, birth_day = ?, section_code = ?, hire_date = ? where employee_code = ?";
			st = con.prepareStatement(sql);
			st.setString(1, employee.getLastName());
			st.setString(2, employee.getFirstName());
			st.setString(3, employee.getLastKanaName());
			st.setString(4, employee.getFirstKanaName());
			st.setInt(5, employee.getGender());
			st.setString(6, employee.getBirthDay());
			st.setString(7, employee.getSectionCode());
			st.setString(8, employee.getHireDate());
			st.setString(9, employee.getCode());
			int line = st.executeUpdate();

			//更新の正否確認
			if(line > 0) {
				updateChk = true;
				con.commit();
			} else {
				con.rollback();
			}

		}

		//クローズ処理
		st.close();
		con.close();

		//オートコミットの設定を戻す
		con.setAutoCommit(true);

		return updateChk;
	}

}
