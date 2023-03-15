package com.example.automationclient.service;

import com.example.automationclient.dao.ExampleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleService.class);

    private final ExampleDAO exampleDao;

    @Autowired
    public ExampleService(ExampleDAO exampleDao) {
        this.exampleDao = exampleDao;
    }

    public String getHelloMessage() {
        LOGGER.info("Fetching hello message from service");
        return exampleDao.getHelloMessage();
    }

    public String getGoodbyeMessage() {
        LOGGER.info("Fetching goodbye message from service");
        return exampleDao.getGoodbyeMessage();
    }

    public String updateMessage() {
        LOGGER.info("Updating message from service");
        return exampleDao.updateMessage();
    }

    public String postMessage() {
        LOGGER.info("Posting message from service");
        return exampleDao.postMessage();
    }

    public String deleteMessage() {
        LOGGER.info("Deleting message from service");
        return exampleDao.deleteMessage();
    }
}
