package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BootRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
//    private static List<Book> list=new ArrayList<>();
//    static{
//        list.add(new Book(12,"Java Complete Reference","XYZ"));
//        list.add(new Book(36,"Think Java","ABC"));
//        list.add(new Book(1234,"Head first to java","LMN"));
//    }
	@Autowired
	private BootRepository bookRepository;

	// get all books
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	// get single bbok by id
	/**
	 * @param id
	 * @return
	 * @return
	 * @return
	 */
	public Book getBookById(int id) {
//        Book out=null;
//        out=list.stream()
//            .filter(e->e.getId()==id)
//            .findFirst().get();
//        return out;
		return this.bookRepository.findById(id);
	}

	// adding the book
	public Book addBook(Book b) {
//        list.add(b);
//        return b;
		return this.bookRepository.save(b);
	}

	// delete book
	public void deleteBook(int id) {
//        Book book = list.stream()
//        .filter(e -> e.getId() == id)
//        .findFirst()
//        .orElse(null);
//
//    // If the book exists, remove it from the list
//        if (book != null) {
//            list.remove(book);
//        }
//
//        return book;
		bookRepository.deleteById(id);
	}

	public Book updateBook(Book book, int id) {
//       Book b=list.stream()
//       .filter(e-> e.getId()==id)
//       .findFirst().orElse(null);
//
//       b.setAuthor(book.getAuthor());
//       b.setTitle(book.getTitle());
//       b.setId(book.getId());
//       return b;
		book.setId(id);

		return this.bookRepository.save(book);
	}

}
