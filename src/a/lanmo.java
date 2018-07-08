package a;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class lanmo {

	public static void main(String[] args) {
		
		//X-mssvc-signature: 59ebacd2c3bf19bb3dd4fee6d1dc90059418be65
		String str="Mon, 14 May 2018 14:10:16 GMT";
		String paramString="http://api.mosoteach.cn/mssvc/index.php/checkin/current_open";
		String localbka="0B90B9D6-961B-11E7-8560-7CD30ABC9F86";
		String localbkh="8VOCoZIoerjbs8uT";
		System.out.println(b(paramString, localbka, str, localbkh));
		
		
		/*String s="6ec3a0ea468d946e1096a94b0bf60e10e5503fad";
		System.out.println(s.length());*/
		
		//System.out.println(hamcsha1("123456".getBytes(),"123456".getBytes()));
	}
	
	public static String b(String paramString1, String paramString2, String paramString3, String paramString4)
	  {
	    return a(paramString4, String.format("%s|%s|%s", new Object[] { paramString1, paramString2, paramString3 }));
	  }
	
	public static String a(String paramString1, String paramString2)
	  {
	    try
	    {
	      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString1.getBytes(), "HmacSHA1");
	      Mac localMac = Mac.getInstance("HmacSHA1");
	      localMac.init(localSecretKeySpec);
	      localMac.update(paramString2.getBytes());
	      String str = c(localMac.doFinal());
	      return str;
	    }
	    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
	    {
	      localNoSuchAlgorithmException.printStackTrace();
	      return null;
	    }
	    catch (InvalidKeyException localInvalidKeyException)
	    {
	      localInvalidKeyException.printStackTrace();
	    }
	    return null;
	  }
	public static String c(byte[] b) 
	{
	    StringBuilder hs = new StringBuilder();
	    String stmp;
	    for (int n = 0; b!=null && n < b.length; n++) {
	        stmp = Integer.toHexString(b[n] & 0XFF);
	        if (stmp.length() == 1)
	            hs.append('0');
	        hs.append(stmp);
	    }
	    return hs.toString().toUpperCase();
	}
	
	
	
	
	
	public static String a(Date paramDate)
	  {
		DateFormat g=null;
	    if (paramDate == null) {
	      return null;
	    }
	    if (g == null)
	    {
	      g = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
	      g.setTimeZone(TimeZone.getTimeZone("GMT"));
	    }
	    return g.format(paramDate);
	  }
	
	
	
	
	
	
	/*
	 * hmacsha1加密
	 */
	
	public static String hamcsha1(byte[] data, byte[] key) 
	{
	      try {
	          SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
	          Mac mac = Mac.getInstance("HmacSHA1");
	          mac.init(signingKey);
	          return byte2hex(mac.doFinal(data));
	      } catch (NoSuchAlgorithmException e) {
	           e.printStackTrace();
	      } catch (InvalidKeyException e) {
	           e.printStackTrace();
	      }
	     return null;
	 }
	
	public static String byte2hex(byte[] b) 
	{
	    StringBuilder hs = new StringBuilder();
	    String stmp;
	    for (int n = 0; b!=null && n < b.length; n++) {
	        stmp = Integer.toHexString(b[n] & 0XFF);
	        if (stmp.length() == 1)
	            hs.append('0');
	        hs.append(stmp);
	    }
	    return hs.toString().toUpperCase();
	}
}
