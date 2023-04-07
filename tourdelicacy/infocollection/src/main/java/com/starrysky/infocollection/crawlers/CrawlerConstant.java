package com.starrysky.infocollection.crawlers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CrawlerConstant {
    public static final String BASE_URL = "https://www.bilibili.com/";
    public static String TOUR_URL = "https://s.search.bilibili.com/cate/search?main_ver=v3&search_type=video&view_type=hot_rank&copy_right=-1&new_web_tag=1&order=click&cate_id=212&page={pageNum}&pagesize={pageSize}&time_from={beginTime}&time_to={endTime}";
    public static LocalDate beginDate;
    public static LocalDate endDate;
    public static int pageNum = 1;
    public static int maxPageNum;
    public static int pageSize;
    public static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
}
