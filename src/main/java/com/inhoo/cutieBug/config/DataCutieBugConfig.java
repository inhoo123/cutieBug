package com.inhoo.cutieBug.config;

public class DataCutieBugConfig {
	public final static String CUTIEBUG_ST = ""; // 검색어구분 샘플데이터(1) 1:분류군 국명 2:분류군명 3:분류군국명일치 4:분류군명일치 st
	public final static String CUTIEBUG_SW = ""; // 검색어 샘플데이터(잠자리) 검색대상어 sw
	public final static String CUTIEBUG_API_KEY ="http://apis.data.go.kr/1400119/KfniService"; // api id
	public final static String CUTIEBUG_URL ="ADpF1vIamlNqL8poa0VpZW5SCJVXcLjwrfnD5TF5fMzC%2B166Nn7Aixn1D%2Fd5EWPpFbUH1F8jnJwm3PGRObYjbA%3D%3D"; // serviceKey
	public final static String CUTIEBUG_NUM_OF_ROWS = "10"; // 한 페이지 결과 수 numOfRows
	public final static String CUTIEBUG_PAGE_NO = "1"; // 페이지 번호 pageNo
	/*
	 * 예:1) st = “1”이고 sw=“잠자리”일때 분류군국명에 “잠자리”을 포함하는 “물잠자리”가 검색됨 
	 * 예:2) st = “2”이고 sw=“Atro”일 때 분류군명에 “Atro”을 포함하는 “Atrocalopteryx”가 검색됨 
	 * 예:3) st = “3”이고 sw=”물잠자리”일때 일치하는 분류군국명 “물잠자리”가 검색됨
	 * 예:4) st = “4”이고 sw=" Atrocalopteryx"일때 일치하는 분류군명 “Atrocalopteryx”가 검색됨
	 */
}
