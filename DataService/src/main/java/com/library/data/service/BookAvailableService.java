package com.library.data.service;

import com.library.data.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("isBookAvailable")
public class BookAvailableService implements DataService
{

    @Autowired
    @Qualifier("availableBookRepo")
    DataRepository repository;

    @Override
    public Object operation(Object input)
    {
        Boolean result = false;
        try {
            if (input != null && !((String)input).isEmpty())
                result = (Boolean) repository.mongoAction(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
