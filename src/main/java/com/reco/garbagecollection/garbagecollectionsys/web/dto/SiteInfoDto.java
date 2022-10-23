package com.reco.garbagecollection.garbagecollectionsys.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class SiteInfoDto {
    @NotBlank(message = "수거사업장 이름을 입력하세요")
    private String siteName; // 업장이름
    @NotBlank(message ="업장 지역을 입력해주세요")
    private String location; // 업장 지역
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "계약일자를 입력해주세요 yyyy-MM-dd")
    @Pattern(regexp = "\\d{4}-(0\\d|1[0-2])-([0_2]\\d|3[0-1])", message = "날짜 형식을 지켜주세요 yyyy-MM-dd (년-월-일)")
    private LocalDate contractDate ; // 계약일자
    @NotBlank(message = "사업자명을 입력해주세요")
    private String ownerName; // 사업자명

    @Builder
    public SiteInfoDto (String siteName, String location, LocalDate contractDate, String ownerName) {
        this.siteName = siteName;
        this.location = location;
        this.contractDate = contractDate;
        this.ownerName = ownerName;
    }
}
