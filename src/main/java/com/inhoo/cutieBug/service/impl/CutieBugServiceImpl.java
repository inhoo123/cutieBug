package com.inhoo.cutieBug.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inhoo.cutieBug.config.DataCutieBugConfig;
import com.inhoo.cutieBug.model.CutieBug;
import com.inhoo.cutieBug.model.CutieBugList;
import com.inhoo.cutieBug.service.CutieBugService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CutieBugServiceImpl implements CutieBugService {
	@Override
	public List<CutieBug> getBugNames(String bugName) {
// Key 
		String st = DataCutieBugConfig.CUTIEBUG_ST; //검색어 구분
		String sw = DataCutieBugConfig.CUTIEBUG_ST; //검색어
		String apiURI = DataCutieBugConfig.CUTIEBUG_URL; //id
		apiURI += "?serviceKey=" + DataCutieBugConfig.CUTIEBUG_API_KEY;//UR
		String numOfRows = DataCutieBugConfig.CUTIEBUG_NUM_OF_ROWS; // 한 페이지 결과 수
		String pageNo = DataCutieBugConfig.CUTIEBUG_PAGE_NO; //페이지 번호

// key try catch
		String cutieBugSt = null;
		String cutieBugSw = null;
		URI    cutieBugURI = null;
		String cutieBugNumOfRows = null;
		String cutieBugPageNo= null;
		try {
			cutieBugSt = new String(st);
			cutieBugSw = new String(sw);
			cutieBugURI = new URI(apiURI);
			cutieBugNumOfRows = new String(numOfRows);
			cutieBugPageNo = new String(pageNo);
		} catch (URISyntaxException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// template
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			return response;
		});
		ResponseEntity<CutieBugList> cutieBugListEntity = null;
		cutieBugListEntity = restTemplate.exchange(cutieBugURI, // 여기 더 추가해야될거같은데?
				HttpMethod.GET, null, CutieBugList.class);
//filtering
		List<CutieBug> cutieBugList = cutieBugListEntity.getBody().CutieBug_List;
		if (!bugName.isEmpty()) {
			cutieBugList = cutieBugList.stream().filter(bug -> bug.systemkorname.contains(bugName))
					.collect(Collectors.toList());
		}
		log.debug("받은데이터{}", cutieBugList.toString());
		return cutieBugList;
	}

}
