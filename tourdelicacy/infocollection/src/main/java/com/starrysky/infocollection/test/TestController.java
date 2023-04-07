package com.starrysky.infocollection.test;

import cn.wanghaomiao.seimi.core.Seimi;
import com.starrysky.infocollection.crawlers.CrawlerConstant;
import com.starrysky.infocollection.crawlers.CrawlerUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/seimi")
public class TestController {

    @GetMapping("test")
    public String test() {
        CrawlerConstant.endDate = LocalDate.now();
        CrawlerConstant.beginDate = CrawlerConstant.endDate.with(DayOfWeek.MONDAY);
        CrawlerConstant.pageNum = 1;
        CrawlerConstant.pageSize = 30;

        CrawlerConstant.maxPageNum = CrawlerUtil.getPageCount(CrawlerConstant.beginDate, CrawlerConstant.endDate, 30);

        Seimi seimi = new Seimi();
        seimi.goRun("crawler_bili");
        return "test";
    }
}
