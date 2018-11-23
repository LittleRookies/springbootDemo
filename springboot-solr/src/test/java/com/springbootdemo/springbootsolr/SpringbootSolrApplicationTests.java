package com.springbootdemo.springbootsolr;

import com.springbootdemo.springbootsolr.CrudRepository.BookCrudRepository;
import com.springbootdemo.springbootsolr.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSolrApplicationTests {
    @Autowired
    private BookCrudRepository bookCrudRepository;

    @Test
    public void contextLoads() {
        Book book = new Book();
        book.setAuthor("吴承恩");
        book.setBookName("西游记");
        book.setNumber(123);
        book.setPiece(312);
        bookCrudRepository.save(book);
    }

    @Test
    public void find(){
        List<Book> findByAuthor = bookCrudRepository.findMe(new Sort(Sort.Direction.DESC, "piece").and(new Sort(Sort.Direction.ASC, "number")));
        System.out.println(findByAuthor);
//        Iterable<Book> all = bookCrudRepository.findAll();
//        for (Book book : all) {
//            System.out.println(book.toString());
//        }

    }

}
