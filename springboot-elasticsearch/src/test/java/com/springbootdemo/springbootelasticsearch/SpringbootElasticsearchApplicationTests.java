package com.springbootdemo.springbootelasticsearch;

import com.springbootdemo.springbootelasticsearch.bean.Book;
import com.springbootdemo.springbootelasticsearch.searchrepository.BookSearchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {
    @Autowired
    BookSearchRepository bookSearchRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void save() {
        Book book = new Book();
        book.setAuthor("吴承恩");
        book.setBookName("西游记");
        Book save = bookSearchRepository.save(book);
        System.out.println(save);
    }

    @Test
    public void find() {
        List<Book> wu = bookSearchRepository.findBookByAuthor("吴");
        for (Book book1 : wu) {
            System.out.println(book1);
        }
    }
}
