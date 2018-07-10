package com.library.data.service;

import com.library.data.bo.BookInfo;
import com.library.data.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("searchBook")
public class SearchBookService implements DataService
{

    @Autowired
    @Qualifier("searchBookRepo")
    DataRepository repository;

    @Override
    public  Object operation(Object input)
    {
        BookInfo bookView = null;
        try {
            if (input != null && !((String)input).isEmpty())
                bookView = (BookInfo) repository.mongoAction(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookView;
    }
}
