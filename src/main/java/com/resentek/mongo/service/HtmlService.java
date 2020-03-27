package com.resentek.mongo.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HtmlService {
    public String genHTML(String[] names){
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Created Beans by Spring</title></head><body>");
        sb.append("<H1>")
          .append(String.format("Beans Count: %d", names.length))
          .append("</H1><hr/>");
        sb.append("<ul>");
        for(String nm: names){
            sb.append(String.format("<li>%s</li>", nm));
        }
        sb.append("</ul>");
        sb.append("</body></html>");
        return sb.toString();
    }
}
