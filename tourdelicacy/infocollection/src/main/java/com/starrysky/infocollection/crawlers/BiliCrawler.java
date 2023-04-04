package com.starrysky.infocollection.crawlers;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Response;
import com.alibaba.fastjson.JSON;
import com.starrysky.infocollection.entity.Video;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.seimicrawler.xpath.JXDocument;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Crawler(name = "crawler_bili")
public class BiliCrawler extends BaseSeimiCrawler {

    public String[] startUrls() {
        Map<String, String> cookies = null;
        String baseUrl = "https://www.bilibili.com";
        String baseUrl1 = "https://s.search.bilibili.com/cate/search?main_ver=v3&search_type=video&view_type=hot_rank&copy_right=-1&new_web_tag=1&order=click&cate_id=215&page=1&pagesize=30&time_from=20230208&time_to=20230215";
        String baseUrl2 = "https://s.search.bilibili.com/cate/search?main_ver=v3&search_type=video&view_type=hot_rank&copy_right=-1&new_web_tag=1&order=click&cate_id=76&page=1&pagesize=30&time_from=20230208&time_to=20230215";
        // 获取cookie
        Connection.Response response = null;
        try {
            response = Jsoup.connect(baseUrl).ignoreContentType(true).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response != null) {
            cookies = response.cookies();
            logger.info("cookies={}", cookies);
        }
        return new String[] {baseUrl1, baseUrl2};
    }

    @Override
    public void start(Response response) {
        JXDocument doc = response.document();
        String content = response.getContent();
        String result = content.substring(content.indexOf("\"result\":") + 9, content.indexOf(",\"show_column\""));
        logger.info("{}", result);

        // 将json转为实体集合
        List<Video> videos = JSON.parseArray(result, Video.class);

        videos.forEach(System.out::println);
    }
}
