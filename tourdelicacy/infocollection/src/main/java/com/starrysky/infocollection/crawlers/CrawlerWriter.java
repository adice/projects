package com.starrysky.infocollection.crawlers;

import com.starrysky.infocollection.entity.Video;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CrawlerWriter {
    public static void writeVideo(List<Video> list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("I:/videos.txt", true));
            for (Video video : list) {
                bw.write(video.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
