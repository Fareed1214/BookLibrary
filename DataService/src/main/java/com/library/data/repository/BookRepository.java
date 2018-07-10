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

@Repository("addBookRepo")
public abstract class BookRepository implements DataRepository
{

	@Value("${mongo.host}")
	protected String host;

	@Value("${mongo.port}")
	protected String port;

	@Value("${mongo.dbname}")
	protected String dbName;

	@Value("${mongo.BookCollection}")
	protected String bookColl;

	protected MongoTemplate mongoDBtemplate;;

	protected MongoTemplate getTemplate()
	{
		if (mongoDBtemplate == null)
			mongoDBtemplate = MongoDBUtil.getMongoTemplate(host, Integer.valueOf(port), dbName);
		return mongoDBtemplate;
	}

	protected List<BookInfo> fetchBookInfo(String input)
	{
		List<BookInfo> bookInfos;
		try {
			MongoTemplate template = getTemplate();
			Query query = new Query();
			if ((input.length() == 24 && (input.matches("\\b[0-9A-Fa-f]+\\b"))))
				query.addCriteria(Criteria.where("_id").is(new ObjectId(input)));
			else
				query.addCriteria(Criteria.where("title").is(input));
			bookInfos = template.find(query, BookInfo.class);
		} catch (Exception e) {
			throw e;
		}
		return bookInfos;
	}

}
