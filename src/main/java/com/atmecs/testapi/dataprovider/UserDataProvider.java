package com.atmecs.testapi.dataprovider;

import com.atmecs.testapi.constants.Constants;
import com.atmecs.testapi.utils.PropReader;

public class UserDataProvider {
	@DataProvider(name = "usersdata")
	public static Object[][] getUsersData() {
		PropReader usersDataReader = new PropReader(Constants.Users_prop_file);
		String url = usersDataReader.get("url");
		String firstName = usersDataReader.get("firstName");
		String lastName = usersDataReader.get("lastName");
		
		Object[][] data = new Object[1][3];
		data[0][0] = url;
		data[0][1] = firstName;
		data[0][2] = lastName;
		
		return data;
	}
}
