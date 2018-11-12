package com.springbootdemo.springbootelasticsearch.searchrepository;

import com.springbootdemo.springbootelasticsearch.bean.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/12 11:24
 */
public interface BookSearchRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findBookByAuthor(String name);

    //使用 Page<Country> countrys = countrySearchRepository.findByName("测试",  PageRequest.of(0, 10)); //分页是从0开始的
    Page<Book> findBookByBookName(String name, Pageable pageable);

    Book findBookById(String name);
}
