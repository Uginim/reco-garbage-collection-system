package com.reco.garbagecollection.garbagecollectionsys.web;

import com.reco.garbagecollection.garbagecollectionsys.service.GCHistoryService;
import com.reco.garbagecollection.garbagecollectionsys.service.GCSiteService;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.historypage.GCHistoryPageDto;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.historyofday.SiteCollectionHistoryDto;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.SiteInfoDto;
import com.reco.garbagecollection.garbagecollectionsys.web.dto.SiteStatusDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Api(value = "garbage-collection")
@RequiredArgsConstructor
@RestController
@RequestMapping("/gc-api")
public class GarbageCollectionApiController {

    private final GCSiteService siteService;
    private final GCHistoryService historyService;

/*
    @GetMapping("/hello")
    public String hello() {
        return "hello";

    }
*/

    /**
     * 업장이름, 지역, 수거량, 수거통수를 출력하는 API
     * @return 업장현황 리스트
     */
    @ApiOperation(value = "업장현황목록", notes = "업장이름, 지역, 수거량, 수거통수를 출력하는 API입니다.")
    @GetMapping("/v1/sites/statuses")
    public List<SiteStatusDto> getAllSiteStatus() {
        return siteService.getAllSiteStatus();
    }


    /**
     * 입력된 일자(yyyy-MM-dd)에 수거이력과 수거사진 정보를 출력하는 API
     * @param dateStr 조회항 일자문자열
     * @return
     */

    @ApiOperation(value = "수거이력요청", notes = "입력된 일자에(yyyy-MM-dd)에 수거이력과 수거사진 정보를 출력하는 API입니다. 수거이력과 수거사진은 1:N관계입니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "일자 정보(yyyy-MM-dd)", required = true),
    })
    @GetMapping("/v1/histories")
    public List<SiteCollectionHistoryDto> test(@RequestParam(name="date",required = true) String dateStr) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-ddHHmmss");

        LocalDateTime searchStartDate = LocalDateTime.parse(dateStr+"000000",format);
        List<SiteCollectionHistoryDto> result = historyService.getCollectionHistoriesOnDate(searchStartDate);
        return result;
    }

    /**
     * 새로운 업장 정보를 입력받아 저장하는 API
     * @param siteInfoDto 업장정보
     * @param response 응답설정을 위한 객체
     * @return 새로 입력한 업장에 할당된 id(실패시 음수)
     */
    @ApiOperation(value = "수거사업장정보 입력", notes = "새로운 업장 정보를 입력받아 저장하는 API")
    @PostMapping("/v1/sites")
    public long writeNewSite(@RequestBody @Valid SiteInfoDto siteInfoDto , HttpServletResponse response) {
        long result = -1;
        try{
            result = siteService.saveSiteInfoDto(siteInfoDto);
        }catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return result;
        }
        response.setStatus(HttpServletResponse.SC_CREATED);
        return result;
    }

    /**
     * 수거이력 정보를 페이징하여 리턴하는 API
     * @param pageable 페이지정보
     * @return 이력페이지Dto
     */
    @ApiOperation(value = "이력페이지 요청", notes = "수거이력을 페이지형태로 요청합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지번호(0부터시작)", required = true),
            @ApiImplicitParam(name = "size", value = "페이지사이즈(기본20)", required = false)
    })
    @GetMapping("/v1/histories/pages")
    public GCHistoryPageDto getHistoriesPage(Pageable pageable){
        GCHistoryPageDto pageContent = null;
        pageContent = historyService.getHistoriesPage(pageable);
        return pageContent;
    }


}
