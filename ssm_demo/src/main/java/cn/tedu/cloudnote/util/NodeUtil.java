package cn.tedu.cloudnote.util;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;


public class NodeUtil implements Serializable {

	private static final long serialVersionUID = -1496517091583858392L;
	public static String md5(String password){
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] data=md.digest(password.getBytes());
			String output=Base64.encodeBase64String(data);
			return output;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String createId(){
		String id=UUID.randomUUID().toString();
		return id;
	}
}
