/**
 * 
 */
package com.fundit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.fundit.beans.UserProfileBean;

/**
 * @author Kashif
 * 
 */
public class LoginDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public UserProfileBean authenticateUser(String userName, String password) {
		//createTables();
		String query = "Select USER_ID, FIRST_NAME, LAST_NAME,BUSINESS_FUNCTION, EMAIL from USERPROFILE where USER_ID = ? and PASSWORD = ?";
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		UserProfileBean userProfileBean = null;
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);

			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			resultSet = pstmt.executeQuery();
			
			if (resultSet.next()){
				userProfileBean = new UserProfileBean();
				userProfileBean.setUserId(resultSet.getString("USER_ID"));
				userProfileBean.setFirstName(resultSet.getString("FIRST_NAME"));
				userProfileBean.setLastName(resultSet.getString("LAST_NAME"));
				userProfileBean.setBusinessFunction(resultSet.getString("BUSINESS_FUNCTION"));
				userProfileBean.setEmail(resultSet.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return userProfileBean;
	}
	
	public void createTables(){
		String dropUserProfiletable = "DROP TABLE USERPROFILE";
		//String dropProjecttable = "DROP TABLE PROJECT";
		String ddlUserProfile = "CREATE TABLE USERPROFILE(USER_ID VARCHAR(20) NOT NULL, PASSWORD VARCHAR(20) NOT NULL, FIRST_NAME VARCHAR(40) NOT NULL, LAST_NAME VARCHAR(40) NOT NULL, BUSINESS_FUNCTION VARCHAR(40), EMAIL VARCHAR(40), PRIMARY KEY (USER_ID))";
		//String ddlProject = "CREATE TABLE PROJECT (PROJECT_ID INT NOT NULL AUTO_INCREMENT, PROJECT_TITLE VARCHAR(100) NOT NULL, PROJECT_DESCRIPTION VARCHAR(500), PROJECT_CATEGORY VARCHAR(200) NOT NULL, PROJECT_GLOBAL_BUSINESS VARCHAR(40), PROJECT_COUNTRY VARCHAR(40), PROJECT_PLANNED_FINISH_DATE DATE, PROJECT_FUND_REQUIRED INT, PROJECT_FUND_RECEIVED INT, USER_ID VARCHAR(20) NOT NULL, PROJECT_MY_FUND INT, VIDEO_URL VARCHAR(500), PRIMARY KEY (PROJECT_ID, USER_ID))";
		String insertUser1 = "INSERT INTO USERPROFILE VALUES ('kevin', 'kevin', 'Kevin','Goodbody', 'MANAGER', 'kevin.goodbody@xyz.com')";
		String insertUser2 = "INSERT INTO USERPROFILE VALUES ('peter', 'peter', 'Peter','Clark', 'COO', 'peter.clark@xyz.com')";
		String insertUser3 = "INSERT INTO USERPROFILE VALUES ('chris', 'chris', 'Chris','Rogers', 'CENTER HEAD', 'chris.rogers@xyz.com')";
		String insertUser4 = "INSERT INTO USERPROFILE VALUES ('david', 'david', 'David','Kolb', 'HEAD DEPT', 'david.kolb@gmail.com')";
		String insertUser5 = "INSERT INTO USERPROFILE VALUES ('christophe', 'christophe', 'Christophe','Chazot', 'GROUP HEAD', 'christophe.chazot@xyz.com')";
		String insertUser6 = "INSERT INTO USERPROFILE VALUES ('manjula', 'manjula', 'Manjula','Muthukrishnan', 'REGION HEAD', 'manjula.muthukrishnan@xyz.com')";
		String insertUser7 = "INSERT INTO USERPROFILE VALUES ('sateen', 'sateen', 'Sateen','Bailur', 'DEPT HEAD', 'sateen.bailur@xyz.com')";
		String insertUser8 = "INSERT INTO USERPROFILE VALUES ('devesh', 'devesh', 'Devesh','Rana', 'DEPT HEAD', 'devesh.rana@xyz.com')";
		String insertUser9 = "INSERT INTO USERPROFILE VALUES ('patrick', 'patrick', 'Patrick','Mang', 'LEAD', 'patrick.mang@xyz.com')";
		String insertUser10 = "INSERT INTO USERPROFILE VALUES ('andy', 'andy', 'Andy','Manguire', 'OPERATING OFFICER', 'andy.maguire@xyz.com')";
		String insertUser11 = "INSERT INTO USERPROFILE VALUES ('mangesh', 'mangesh', 'Mangesh','Paunikar', 'SCRUM MASTER', 'mangesh.paunikar@xyz.com')";
		Statement pstmt = null;
		try {
			pstmt = dataSource.getConnection().createStatement();
			pstmt.addBatch(dropUserProfiletable);
			pstmt.addBatch(ddlUserProfile);
			//pstmt.addBatch(dropProjecttable);
			
			//pstmt.addBatch(ddlProject);
			pstmt.addBatch(insertUser1);
			pstmt.addBatch(insertUser2);
			pstmt.addBatch(insertUser3);
			pstmt.addBatch(insertUser4);
			pstmt.addBatch(insertUser5);
			pstmt.addBatch(insertUser6);
			pstmt.addBatch(insertUser7);
			pstmt.addBatch(insertUser8);
			pstmt.addBatch(insertUser9);
			pstmt.addBatch(insertUser10);
			pstmt.addBatch(insertUser11);
			pstmt.executeBatch();
			System.out.println("Table created and record inserted...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
