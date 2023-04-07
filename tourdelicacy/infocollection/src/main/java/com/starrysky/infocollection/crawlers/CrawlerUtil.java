package com.starrysky.infocollection.crawlers;

import cn.wanghaomiao.seimi.core.Seimi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CrawlerUtil {
    public static int getPageCount(LocalDate beginDate, LocalDate endDate, int pageSize) {
        try {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
            URL url = new URL(CrawlerConstant.TOUR_URL.replace("{pageNum}", "1")
                    .replace("{pageSize}", "" + pageSize)
                    .replace("{beginTime}", beginDate.format(df))
                    .replace("{endTime}", endDate.format(df)));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int code = connection.getResponseCode();
            String content = "";
            if (code == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    content += line + "\n";
                }
                reader.close();
            }
            connection.disconnect();
            String pageCount = content.substring(content.indexOf("\"numPages\":") + 11, content.indexOf(",\"numResults\""));
            return Integer.parseInt(pageCount);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void crawlBili(){
        Seimi seimi = new Seimi();
        seimi.goRun("crawler_bili");
    }
}
