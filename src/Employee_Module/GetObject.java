package Employee_Module;

public class GetObject {
	
	public static Employee getObject(String str)
	{
		if(str==null)
			return null;
		else if(str=="Permanent")
			return new Permanent_Employee();
		else if(str=="Temporary")
			return new Temporary_Employee();
		else 
			return null;
	}

}
