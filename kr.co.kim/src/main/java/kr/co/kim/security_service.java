package kr.co.kim;

import java.security.MessageDigest;

import org.springframework.stereotype.Service;


public interface security_service {
	
	default StringBuilder secode_sha(String passwd) throws Exception {
		
		MessageDigest md5 = MessageDigest.getInstance("SHA-224");
		md5.update(passwd.getBytes());
		byte[] repw = md5.digest();
		StringBuilder sb = new StringBuilder();
		for(byte w : repw) {
			String word = String.format("%x", w);
			sb.append(word);
		}
	
		return sb;
	}
	
	default StringBuilder secode(String passwd) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(passwd.getBytes());
		byte[] repw = md5.digest();
		StringBuilder sb = new StringBuilder();
		for(byte w : repw) {
			String word = String.format("%x", w);
			sb.append(word);
		}
	
		return sb;
	}

}
