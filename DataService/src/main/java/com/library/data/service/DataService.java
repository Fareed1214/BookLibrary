package com.library.data.service;

import org.springframework.stereotype.Service;

import com.library.data.bo.BookInfo;
import com.library.data.bo.LibraryView;

@Service
public interface DataService
{
	public Object operation(Object input);
}
