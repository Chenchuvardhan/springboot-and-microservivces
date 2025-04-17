package in.disney.password;

public class GeneratePassword {
	   public static String generatePasswordForUser() {
		  
		   Double random = Math.random();
		   String string = random.toString();
		   String str="";
		   for(int i=string.length()-1;i>=string.length()-4;i--) {
			 str+=string.charAt(i);
		   }
		   return str;
	   }
}
