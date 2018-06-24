package com.ro.soccer.teams;


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ro.soccer.teams.config.FiltersConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApiSoccerTeamsApplication.class, FiltersConfiguration.class})
@Transactional
public abstract class AbstractTestClass {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
}
