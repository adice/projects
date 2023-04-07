package com.starrysky.infocollection.crawlers;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Response;
import com.alibaba.fastjson.JSON;
import com.starrysky.infocollection.entity.Video;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Crawler(name = "crawler_bili")
public class BiliCrawler extends BaseSeimiCrawler {
    public String[] startUrls() {
        // 获取cookie
        Connection.Response response = null;
        Map<String, String> cookies;
        try {
            response = Jsoup.connect(CrawlerConstant.BASE_URL).ignoreContentType(true).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response != null) {
            cookies = response.cookies();
            logger.info("cookies={}", cookies);
        }
        String[] urls = new String[CrawlerConstant.maxPageNum];
        for (int i = 0; i < CrawlerConstant.maxPageNum; i++) {
            urls[i] = CrawlerConstant.TOUR_URL.replace("{pageNum}", "" + CrawlerConstant.pageNum)
                    .replace("{pageSize}", "" + CrawlerConstant.pageSize)
                    .replace("{beginTime}", CrawlerConstant.beginDate.format(CrawlerConstant.df))
                    .replace("{endTime}", CrawlerConstant.endDate.format(CrawlerConstant.df));
            CrawlerConstant.pageNum++;
        }
        return urls;
    }

    @Override
    public void start(Response response) {
        String content = response.getContent();
        String result = content.substring(content.indexOf("\"result\":") + 9, content.indexOf(",\"show_column\""));

        // 将json转为实体集合
        List<Video> videos = JSON.parseArray(result, Video.class);
        videos.forEach(System.out::println);
        CrawlerWriter.writeVideo(videos);
    }
}
