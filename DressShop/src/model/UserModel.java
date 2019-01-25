package model;

import java.sql.SQLException;
import java.util.Collection;

public interface UserModel<UserBean> {

			public Collection<UserBean> retrieveAllUsers()
			throws SQLException;
			
			public void saveUsers(UserBean user)
			throws SQLException;
			
			public boolean deleteUsers(String userName)
			throws SQLException;

			public UserBean retrieveByKey(String userName) throws SQLException;
			
		
}
