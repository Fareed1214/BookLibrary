package com.library.data.repository;

import com.library.data.bo.BookInfo;
import com.library.data.bo.LibraryView;
import com.library.data.util.MongoDBUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("returnBookRepo")
public class ReturnBookRepository extends BookRepository
{


	//@Override
	//public String returnBook(String input) {
	//	return null;
	//}

	@Override
	public Object mongoAction(Object input) {
		return null;
	}
}
