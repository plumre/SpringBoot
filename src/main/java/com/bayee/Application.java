package com.bayee;

/*
 * Created by renhongjiang on 2019/2/27.
 */

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/27 15:42
 */
@RestController
@SpringBootApplication
public class Application {

    @Autowired
    private TransportClient client;

    @SuppressWarnings("unchecked")
    @GetMapping("/get/book/novel")
    @ResponseBody
    public ResponseEntity getNovel(String id) {
        if (StringUtils.isEmpty(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        GetResponse response = client.prepareGet("book", "novel", id).get();
        if (!response.isExists()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response.getSource(), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/add/book/novel")
    @ResponseBody
    public ResponseEntity addNovel(String title, String author, int wordCount,
                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date publishDate) {
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(author) || wordCount < 1) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        try {
            XContentBuilder contentBuilder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title", title)
                    .field("author", author)
                    .field("word_count", wordCount)
                    .field("publish_date", publishDate.getTime())
                    .endObject();
            IndexResponse response = client.prepareIndex("book", "novel").setSource(contentBuilder).get();
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/book/novel")
    @ResponseBody
    public ResponseEntity deleteBook(String id) {
        DeleteResponse response = client.prepareDelete("book", "novel", id).get();
        return new ResponseEntity(response, HttpStatus.OK);
    }


    @SuppressWarnings("unchecked")
    @PutMapping("/update/book/novel")
    @ResponseBody
    public ResponseEntity updateBook(String id, String title, String author) {
        UpdateRequest updateRequest = new UpdateRequest("book", "novel", id);
        try {
            XContentBuilder contentBuilder = XContentFactory.jsonBuilder().startObject();
            if (title != null) {
                contentBuilder.field("title", title);
            }
            if (author != null) {
                contentBuilder.field("author", author);
            }
            contentBuilder.endObject();
            updateRequest.doc(contentBuilder);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            UpdateResponse updateResponse = client.update(updateRequest).get();
            return new ResponseEntity(updateResponse.getResult().toString(), HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SuppressWarnings("unchecked")
    @PostMapping("query/book/novel")
    @ResponseBody
    public ResponseEntity queryBook(String title, String author, int gtWordCount, int ltWordCount) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (title != null) {
            queryBuilder.must(QueryBuilders.matchQuery("title", title));
        }
        if (author != null) {
            queryBuilder.must(QueryBuilders.matchQuery("author", author));
        }

        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("word_count").from(gtWordCount);
        if (ltWordCount > 0) {
            rangeQuery.to(ltWordCount);
        }
        queryBuilder.filter(rangeQuery);
        SearchRequestBuilder builder = client.prepareSearch("book")
                .setTypes("novel")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(queryBuilder)
                .setFrom(0)
                .setSize(10);
        System.out.println("builder = " + builder);
        SearchResponse searchResponse = builder.get();
        System.out.println("searchResponse = " + searchResponse);
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits()) {
            list.add(hit.getSourceAsMap());
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}