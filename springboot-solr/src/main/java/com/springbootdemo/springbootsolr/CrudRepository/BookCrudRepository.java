package com.springbootdemo.springbootsolr.CrudRepository;

import com.springbootdemo.springbootsolr.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * @Author: Jiang Hao
 * @Date: 2018-11-23 15:17
 */
public interface BookCrudRepository extends SolrCrudRepository<Book, String> {
    List<Book> findByAuthor(String auth);

    @Query("piece:312 and number:123")
    List<Book> findMe(Sort sort);
}
