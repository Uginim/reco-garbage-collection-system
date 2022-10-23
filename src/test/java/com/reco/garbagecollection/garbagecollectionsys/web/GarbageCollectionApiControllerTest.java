package com.reco.garbagecollection.garbagecollectionsys.web;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class GarbageCollectionApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void returns_hello() throws Exception {
        String hello = "hello";

        mockMvc.perform(get("/gc-api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    // 1. 업장 이름, 지역, 수거량, 수거 통수를 출력하는 API
    public void returns_SiteStatus () throws Exception {
        mockMvc.perform(get("/gc-api/v1/site-status"))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[*].siteName",is(name)))
//                .andExpect(jsonPath("$[*].siteName",is(amount)));
        ;
    }

    // 3. 업장 정보를 입력하는 API
    public void input_siteinfo() throws Exception {
//        mockMvc.perform(post("/"))
    }

    // 4. 수거 이력 정보를 리턴 하는 API
    public void getHistoryPages() throws Exception {
        mockMvc.perform(get("/gc-api/v1/histories?page=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", Matchers.empty()));
    }
/*
1. 업장 이름, 지역, 수거량, 수거 통수를 출력하는 API
2. 실제 수거 시간 (yyyy-MM-dd)를 파라미터로 받아 수거 이력에 실제 수거 날짜와 같은 수거 이력과 수거 사진 정보를 출력하는 API
    - 응답 객체는 다음과 같이 나타냅니다.
        - 업장 이름, 실제 수거 시간
            - 수거 사진
                - 파일 이름
                - 지역
                - 사업자 이름
                - 수거량
                - 수거 통수
3. 업장 정보를 입력하는 API
4. 수거 이력 정보를 리턴 하는 API
    a. 데이터 페이징 처리가 가능한 형태로 작성해주세요.
* */

//    @Test
//    public void
}

