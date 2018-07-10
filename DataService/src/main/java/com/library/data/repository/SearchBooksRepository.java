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

@Repository("searchBooksRepo")
public class SearchBooksRepository extends BookRepository
{

	@Override
	public Object mongoAction(Object input) {
		LibraryView view = null;
		try {
			MongoTemplate template = getTemplate();
			List<BookInfo> bookInfos = template.find(new Query(), BookInfo.class);
			if (bookInfos.size() > 0) {
				view = new LibraryView();
				bookInfos.stream().forEach(info -> info.setAvailable(info.getNoOfCopies() > 0));
				view.setLibrary(bookInfos);
			}
		} catch (Exception e) {
			throw e;
		}
		return view;

	}
}
