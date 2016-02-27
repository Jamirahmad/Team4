/**
 * 
 */
package com.fundit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.fundit.beans.FundingBean;
import com.fundit.beans.ProjectBean;

/**
 * @author Kashif
 * 
 */
public class FundDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}


	public List<FundingBean> getAllFundsByUserId(int userId) {
		String query = "Select USER_ID, PROJECT_ID , FUND_ADDED"
			+ " from FUNDING where USER_ID = ? ";
		System.out.println("query: "+ query);
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		FundingBean fundingBean = null;
		List<FundingBean> fundingList = new ArrayList<FundingBean>();
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, userId);
			resultSet = pstmt.executeQuery();
	
			while(resultSet.next()) {
				fundingBean = new FundingBean();
				fundingBean.setUser_id(resultSet.getString("USER_ID"));
				fundingBean.setProject_id(resultSet
						.getString("PROJECT_ID"));
				fundingBean.setFund_added(resultSet
						.getString("FUND_ADDED"));
			
				
				fundingList.add(fundingBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fundingList;
	}
	
	
	public List<FundingBean> getAllFundsByProjectId(int projectId) {
		String query = "Select USER_ID, PROJECT_ID , FUND_ADDED"
			+ " from FUNDING where PROJECT_ID = ? ";
		System.out.println("query: "+ query);
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		FundingBean fundingBean = null;
		List<FundingBean> fundingList = new ArrayList<FundingBean>();
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, projectId);
			resultSet = pstmt.executeQuery();
	
			while(resultSet.next()) {
				fundingBean = new FundingBean();
				fundingBean.setUser_id(resultSet.getString("USER_ID"));
				fundingBean.setProject_id(resultSet
						.getString("PROJECT_ID"));
				fundingBean.setFund_added(resultSet
						.getString("FUND_ADDED"));
			
				
				fundingList.add(fundingBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fundingList;
	}

	public boolean addFund(FundingBean fundingBean) {
		boolean isSuccess = false;
		String query = "INSERT INTO FUNDING ( USER_ID , PROJECT_ID , FUND_ADDED) VALUES (?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = dataSource.getConnection().prepareStatement(query);

			pstmt.setString(1, fundingBean.getUser_id());
			pstmt.setString(2, fundingBean.getProject_id());
			pstmt.setString(3, fundingBean.getFund_added());
			

			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return isSuccess;
	}
}
