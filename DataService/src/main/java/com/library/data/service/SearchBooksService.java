package com.library.data.service;

import com.library.data.bo.LibraryView;
import com.library.data.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("searchBooks")
public class SearchBooksService implements DataService
{

    @Autowired
    @Qualifier("searchBooksRepo")
    DataRepository repository;

    @Override
    public Object operation(Object input)
    {
        LibraryView library = null;
        try {
            library = (LibraryView) repository.mongoAction(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return library;
    }

}
