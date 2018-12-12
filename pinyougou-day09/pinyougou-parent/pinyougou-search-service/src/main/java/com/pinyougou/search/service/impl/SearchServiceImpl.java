package com.pinyougou.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by crowndint on 2018/10/22.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SolrTemplate solrTemplate;
    @Override
    public Map<String, Object> search(Map searchMap) {
        Query query=new SimpleQuery();
        //添加查询条件
        Criteria criteria= new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        Map<String,Object> map=new HashMap<>();
        map.put("rows", page.getContent());
        return map;
    }



    /*@Autowired
    private HttpSolrServer httpSolrServer;
    @Override
    public Map<String, Object> search(Map<String, Object> searchMap)  {
        HashMap<String, Object> searchResult = new HashMap<>();
        try {

            String keywords = (String) searchMap.get("keywords");
            if (StringUtils.isEmpty(keywords)) {
                keywords = "*";
            }

            SolrQuery query = new SolrQuery("item_keywords:"+keywords);

            //高亮显示
            query.setHighlight(true);
            //高亮显示的域
            query.addHighlightField("product_name");
            //高亮显示的前缀
            query.setHighlightSimplePre("<em style='color:red'>");
            //高亮显示的后缀
            query.setHighlightSimplePost("</em>");


            QueryResponse queryResponse = httpSolrServer.query(query);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            long numFound = solrDocumentList.getNumFound();

            ArrayList<TbItem> itemList = new ArrayList<>();
            for (SolrDocument solrDocument : solrDocumentList) {
                TbItem item = new TbItem();
                String id = (String) solrDocument.get("id");
                String title = (String) solrDocument.get("item_title");
                Double price = (Double) solrDocument.get("item_price");
                String image = (String) solrDocument.get("item_image");
                String category = (String) solrDocument.get("item_category");
                String brand = (String) solrDocument.get("item_brand");

                //取高亮显示
                Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
                List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
                //判断是否有高亮内容
                if (null != list) {
                    title = list.get(0);
                }


                item.setId(Long.parseLong(id));
                item.setTitle(title);
                item.setPrice(new BigDecimal(price));
                item.setImage(image);
                item.setCategory(category);
                item.setBrand(brand);

                itemList.add(item);
            }

            searchResult.put("total", numFound);
            searchResult.put("rows", itemList);

        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return searchResult;
    }*/


}
