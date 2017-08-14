package com.example.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookRepository bookRepository;
 
    @RequestMapping(method = RequestMethod.POST)
    public Book create(@RequestBody Book book){
    	Book result = bookRepository.save(book);
        return result;
    }
     
    @RequestMapping(method = RequestMethod.GET, value="/{bookId}")
    public Book get(@PathVariable String bookId){
        return bookRepository.findOne(bookId);
    }
}
