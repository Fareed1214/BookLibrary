package com.library.data.service;

import com.library.data.bo.BookInfo;
import com.library.data.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("addBook")
public class AddBookService implements DataService
{

    @Autowired
    @Qualifier("addBookRepo")
    DataRepository repository;

    @Override
    public Object operation(Object input)
    {
        Boolean result = false;
        try {
            if (input != null) {
                result = (Boolean) repository.mongoAction(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
