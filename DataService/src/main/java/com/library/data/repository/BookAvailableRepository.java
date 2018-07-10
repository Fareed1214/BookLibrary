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

@Repository("availableBookRepo")
public class BookAvailableRepository extends BookRepository
{

	@Override
	public Object mongoAction(Object input) {
		Boolean isAvailable = false;
		try {
			List<BookInfo> list = fetchBookInfo((String)input);
			isAvailable =  (list.size() > 0 && list.get(0).getNoOfCopies() >= 1);
		} catch (Exception e) {
			throw e;
		}
		return isAvailable;
	}
}
