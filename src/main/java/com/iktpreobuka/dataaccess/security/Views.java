package com.iktpreobuka.dataaccess.security;

import com.iktpreobuka.dataaccess.security.Views.Private;
import com.iktpreobuka.dataaccess.security.Views.Public;

public class Views {


	public static class Public {}	
	public static class Private extends Public {}
	public static class Admin extends Private{}


}
