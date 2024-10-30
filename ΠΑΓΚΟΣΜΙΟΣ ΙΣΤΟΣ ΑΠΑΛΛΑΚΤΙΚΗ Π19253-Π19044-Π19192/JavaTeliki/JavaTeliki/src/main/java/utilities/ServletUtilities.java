package utilities;



public class ServletUtilities {

	private ServletUtilities() {} // Uninstantiatable class

	public static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}

	public static String getAlphaNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
	
	/** Replaces characters that have special HTML meanings
	   *  with their corresponding HTML character entities.
	   *  Specifically, given a string, this method replaces all 
	   *  occurrences of  
	   *  {@literal
	   *  '<' with '&lt;', all occurrences of '>' with
	   *  '&gt;', and (to handle cases that occur inside attribute
	   *  values), all occurrences of double quotes with
	   *  '&quot;' and all occurrences of '&' with '&amp;'.
	   *  Without such filtering, an arbitrary string
	   *  could not safely be inserted in a Web page.
	   *  }
	   */
	  public static String filter(String input) {
	    if (!hasSpecialChars(input)) {
	      return(input);
	    }
	    StringBuilder filtered = new StringBuilder(input.length());
	    char c;
	    for(int i=0; i<input.length(); i++) {
	      c = input.charAt(i);
	      switch(c) {
	        case '<': filtered.append("&lt;"); break;
	        case '>': filtered.append("&gt;"); break;
	        case '"': filtered.append("&quot;"); break;
	        case '&': filtered.append("&amp;"); break;
	        default: filtered.append(c);
	      }
	    }
	    return(filtered.toString());
	  }

	  private static boolean hasSpecialChars(String input) {
	    boolean flag = false;
	    if ((input != null) && (input.length() > 0)) {
	      char c;
	      for(int i=0; i<input.length(); i++) {
	        c = input.charAt(i);
	        switch(c) {
	          case '<': flag = true; break;
	          case '>': flag = true; break;
	          case '"': flag = true; break;
	          case '&': flag = true; break;
	        }
	      }
	    }
	    return(flag);
	  }

	  /**
	   * checkIfEmpty Method
	   */
	public static boolean checkIfEmpty(String dataString) {
		if(dataString.isEmpty() || dataString.contains("\t"))
			return true;
		else 
			return false;
	}
  	
	/**
	 * tryParseToInt Method
	 */
	public static int tryParseToInt(String value) {
	    try {
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        return -1;
	    }
	}
}
