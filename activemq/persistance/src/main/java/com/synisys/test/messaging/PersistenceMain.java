package com.synisys.test.messaging;

import com.synisys.test.messaging.dao.ProjectDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author armen mkrtchyan
 * @version 1.0
 */
public class PersistenceMain {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Files.deleteIfExists(Paths.get(new URI("file:/home/armen/IdeaProjects/message-queue-tests/activemq/persistance/src/main/resources.mv.db")));
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring/persistance-context.xml");
        ProjectDao projectDao = (ProjectDao) context.getBean("projectDao");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

}
