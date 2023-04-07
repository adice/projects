package com.starrysky.infocollection.scheduled;

import cn.wanghaomiao.seimi.core.Seimi;
import com.starrysky.infocollection.crawlers.CrawlerConstant;
import com.starrysky.infocollection.crawlers.CrawlerUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class CrawlerScheduled {

    @Scheduled(cron = "58 * 0,23 * * 1,7")
    public void crawlBili(){
        CrawlerConstant.endDate = LocalDate.now();
        CrawlerConstant.beginDate = CrawlerConstant.endDate.with(DayOfWeek.MONDAY);
        CrawlerConstant.pageNum = 1;
        CrawlerConstant.pageSize = 30;

        CrawlerConstant.maxPageNum = CrawlerUtil.getPageCount(CrawlerConstant.beginDate, CrawlerConstant.endDate, 30);
        CrawlerUtil.crawlBili();

    }
}
