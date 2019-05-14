package com.ucmed.nuts;

import java.io.IOException;
import java.nio.ByteBuffer;

public class IsBase64Code {
	public static final char[] BASE64_CODE = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
	            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
	            '5', '6', '7', '8', '9', '+', '/', '=' };

	    private static final int MAX_BUFF_SIZE = 4000000;
	    private static boolean doCheck(String xml) throws IOException {
	    	ByteBuffer buffer = ByteBuffer.allocate(1024);
	        String line = null;
	        String lastLine = null;
	        byte[] src = xml.getBytes();

	        for (int i = 0; i < src.length; i++) {
	            final char c = (char) src[i];
	            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '+' || c == '/') {
	                continue;
	            }
	            return false;
	        }
	        if ((src.length) % 4 != 0) {
	            return false;
	        }

	        return true;
	    }

	    public static ByteBuffer tryAllocate(ByteBuffer buffer, int length) {
	        if (length > buffer.remaining()) {
	            buffer.flip();
	            return ByteBuffer.allocate(roundup(buffer.limit() + length)).put(buffer);
	        }
	        return buffer;
	    }
	    public static int roundup(int length) {
	        if (length > MAX_BUFF_SIZE) {
	            throw new IllegalArgumentException("length too large!");
	        }
	        int capacity = 16;
	        while (length < capacity) {
	            capacity = capacity << 1;
	        }
	        return capacity;
	    }

	    public static void main(String[] args){
			String xml = "PD94bWwgdmVyc2lvbj0iMS4wIiB"
					+ "lbmNvZGluZz0idXRmLTgiPz4NCjxyZ"
					+ "XF1ZXN0Pg0KICA8cmVxdWVzdGlkPjU"
					+ "yMzwvcmVxdWVzdGlkPg0KICA8cGFnZ"
					+ "WFjdGlvbmluPg0KICAgIDxjdXJyZW5"
					+ "0cGFnZW51bT4xPC9jdXJyZW50cGFnZ"
					+ "W51bT4NCiAgICA8cm93c3BlcnBhZ2U"
					+ "+MjAwPC9yb3dzcGVycGFnZT4NCiAgI"
					+ "CA8cGFnZWFjdGlvbj5maXJzdHBhZ2U"
					+ "8L3BhZ2VhY3Rpb24+DQogICAgPHRvc"
					+ "GFnZW51bT4yMDA8L3RvcGFnZW51bT4"
					+ "NCiAgPC9wYWdlYWN0aW9uaW4+DQogI"
					+ "DxyZXRyaWV2ZWFyZ3M+DQogICAgPGJ"
					+ "lZ2luZGF0ZT4xOTk5LTAxLTAxPC9iZ"
					+ "WdpbmRhdGU+DQogICAgPGhvc3BpdGF"
					+ "saWQ+MTAwMTwvaG9zcGl0YWxpZD4NCi"
					+ "AgICA8ZGVwdGNvZGU+PC9kZXB0Y29kZT"
					+ "4NCiAgPC9yZXRyaWV2ZWFyZ3M+DQo8L3JlcXVlc3Q+";
			boolean a = false;
			try {
				a = doCheck(xml);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(a);		
		}
	}




