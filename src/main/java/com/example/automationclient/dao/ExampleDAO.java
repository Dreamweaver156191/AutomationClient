package com.example.automationclient.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleDAO.class);

    public String getHelloMessage() {
        LOGGER.info("Fetching hello message from DAO");
        return "Hello, World!";
    }

    public String getGoodbyeMessage() {
        LOGGER.info("Fetching goodbye message from DAO");
        return "Goodbye, World!";
    }

    public String updateMessage() {
        LOGGER.info("Updating message in DAO");
        return "Updated!";
    }

    public String postMessage() {
        LOGGER.info("Posting message in DAO");
        return "Posted!";
    }

    public String deleteMessage() {
        LOGGER.info("Deleting message in DAO");
        return "Deleted!";
    }
}
