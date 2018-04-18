package com.cnipr.schedule;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class StringUtils {

	private Key key;
	private byte[] byteMi = null;
	private byte[] byteMing = null;
	private String strMi = "";
	private String strM = "";
	
	public StringUtils() {
		this.setKey("cnipr#JP@");
	}

	// 根据参数生成KEY
	public void setKey(String strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			this.key = _generator.generateKey();
			_generator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 加密String明文输入,String密文输出
//	public void setEncString(String strMing) {
//		BASE64Encoder base64en = new BASE64Encoder();
//		try {
//			this.byteMing = strMing.getBytes("UTF8");
//			this.byteMi = this.getEncCode(this.byteMing);
//			this.strMi = base64en.encode(this.byteMi);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			this.byteMing = null;
//			this.byteMi = null;
//		}
//	}

	// 加密以byte[]明文输入,byte[]密文输出
	private byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}

		return byteFina;
	}

	// 解密:以String密文输入,String明文输出
//	public void setDesString(String strMi) {
//		BASE64Decoder base64De = new BASE64Decoder();
//		try {
//			this.byteMi = base64De.decodeBuffer(strMi);
//			this.byteMing = this.getDesCode(byteMi);
//			this.strM = new String(byteMing, "UTF8");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			base64De = null;
//			byteMing = null;
//			byteMi = null;
//		}
//
//	}

	// 解密以byte[]密文输入,以byte[]明文输出
	private byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	// 返回加密后的密文strMi
	public String getStrMi() {
		return strMi;
	}

	// 返回解密后的明文
	public String getStrM() {
		return strM;
	}
	
	private static final String AES = "AES";

	private static final String CRYPT_KEY = "YUUAtestYUUAtest";

	/**
	 * 加密
	 * 
	 * @param encryptStr
	 * @return
	 */
	public static byte[] encrypt(byte[] src, String key) throws Exception {
		Cipher cipher = Cipher.getInstance(AES);
		SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);
		cipher.init(Cipher.ENCRYPT_MODE, securekey);//设置密钥和加密形式
		return cipher.doFinal(src);
	}

	/**
	 * 解密
	 * 
	 * @param decryptStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, String key)  throws Exception  {
		Cipher cipher = Cipher.getInstance(AES);
		SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);//设置加密Key
		cipher.init(Cipher.DECRYPT_MODE, securekey);//设置密钥和解密形式
		return cipher.doFinal(src);
	}
	
	/**
	 * 二行制转十六进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("长度不是偶数");
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}
	
	/**
	 * 解密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public void setDesString(String data) {
		try {
			strM = new String(decrypt(hex2byte(data.getBytes()),
					CRYPT_KEY));
		} catch (Exception e) {
		}
	}

	/**
	 * 加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public void setEncString(String data) {
		try {
			strMi =  byte2hex(encrypt(data.getBytes(), CRYPT_KEY));
		} catch (Exception e) {
		}
	}
	

//	public static void main(String[] args) {
//		String ID = "611111";
//		
//		String idEncrypt = encrypt(ID);
//		System.out.println(idEncrypt);
//		String idDecrypt = decrypt(idEncrypt);
//		System.out.println(idDecrypt);
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringUtils abc = new StringUtils();
//		String key = "cnipr"; // 初始化密钥。
//		abc.setKey(key); // 调用set函数设置密钥。
		abc.setEncString("g21hze7h");// 将要加密的明文传送给Encrypt.java进行加密计算。
		String Mi = abc.getStrMi(); // 调用get函数获取加密后密文。
		System.out.println(Mi);
		StringUtils abc1 = new StringUtils();
		abc1.setDesString("69A6CD44B4BD928EE90760A5297B79AF"); // 将要解密的密文传送给Encrypt.java进行解密计算。
		String M = abc1.getStrM(); // 调用get函数获取解密后明文。
		System.out.println(M);
	}

}
