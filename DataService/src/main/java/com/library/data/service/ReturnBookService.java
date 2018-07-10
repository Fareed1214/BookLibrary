package com.library.data.service;

import com.library.data.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("returnBook")
public class ReturnBookService implements DataService
{
    @Autowired
    @Qualifier("returnBookRepo")
    DataRepository repository;

    @Override
    public  Object operation(Object input)
    {
        String result = "";
        try {
            if (input != null && !((String)input).isEmpty())
                result = (String) repository.mongoAction(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
