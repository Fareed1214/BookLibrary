package com.library.data.repository;


import com.library.data.bo.BookInfo;
import com.library.data.bo.LibraryView;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository {

	Object mongoAction(Object input);
}
