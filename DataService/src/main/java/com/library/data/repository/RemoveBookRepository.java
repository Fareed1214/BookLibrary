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

@Repository("removeBookRepo")
public class RemoveBookRepository extends BookRepository
{

	@Override
	public Object mongoAction(Object input) {
		Boolean result = false;
		try {
			List<BookInfo> list = fetchBookInfo((String)input);
			if (list.size() > 0) {
				BookInfo info = list.get(0);
				MongoTemplate template = getTemplate();
				if (info.getNoOfCopies() > 1) {
					info.setNoOfCopies(info.getNoOfCopies() - 1);
					template.save(info);
				} else
					template.remove(info);
				result = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return result;

	}
}
