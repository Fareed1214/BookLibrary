package com.library.data.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.library.data.bo.BookInfo;
import com.library.data.bo.LibraryView;
import com.library.data.util.MongoDBUtil;

@Repository("addBookRepo")
public class AddBookRepository extends BookRepository
{

	@Override
	public Object mongoAction(Object input) {
		Boolean result = false;
		try {
			BookInfo info = (BookInfo)input;
			int copies = info.getNoOfCopies();
			List<BookInfo> list = fetchBookInfo(info.getTitle());
			if (list.size() > 0) {
				info = list.get(0);
				info.setNoOfCopies(info.getNoOfCopies() + copies);
			}
			info.setAvailable(info.getNoOfCopies() > 0);
			getTemplate().save(info);
			result = true;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
}
