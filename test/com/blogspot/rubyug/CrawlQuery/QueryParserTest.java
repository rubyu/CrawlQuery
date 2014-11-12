/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.rubyug.crawlquery;

import java.util.*;
import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tukigase
 */
public class QueryParserTest {

    public QueryParserTest() {
    }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  /**
   * Test of parse method, of class QueryParser.
   */
  @Test
  public void testParse() throws Exception {
    System.out.println("parse");

    List<Map> tests = new ArrayList<Map>();
    Map test;
    
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\", \"http://test/\" ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\", \"http://test/\", \"http://test/\" ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > 1 ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ /test/ > $ /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ /test/ig ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ /test/ig > $ /test/ig ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ url /test/ig ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ url /test/ig > $ url /test/ig ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > # /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > # /test/ig ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > # url /test/ig ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > # url /test/ig > # url /test/ig ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ /test/ > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > $ /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ /test/ > 1 > $ /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > $ /test/ > 1 ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", false);
    test.put("pattern", "\"http://test/\" > \"http://test/\" ");
    tests.add(test);



    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ ! /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ ! ! /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ /test/ & /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ /test/ | /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", false);
    test.put("pattern", "\"http://test/\" > $ /test/ ! /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ ! /test/ & ! /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ ! /test/ | ! /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ ( /test/ ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ ! ( /test/ ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ ( ! /test/ ) | ( ! /test/ ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > $ ( ! /test/ | ! /test/ ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", false);
    test.put("pattern", "\"http://test/\" > $ ( ! /test/ ) ( ! /test/ ) ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > 1 ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > 1 > 1 ) > 1 > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > $ /test/ ) > $ /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > $ /test/ > $ /test/ ) > $ /test/ > $ /test/ ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" | \"http://test/\" ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > 1 | \"http://test/\" > 1 ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > 1 > 1 | \"http://test/\" > 1 > 1 ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > $ /test/ | \"http://test/\" > $ /test/ ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > $ /test/ > $ /test/ |  \"http://test/\" > $ /test/ > $ /test/ ) ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" | \"http://test/\" | \"http://test/\" ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > 1 | \"http://test/\" > 1 | \"http://test/\" > 1 ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > 1 > 1  |  \"http://test/\" > 1 > 1  | \"http://test/\" > 1 > 1 ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > $ /test/ | \"http://test/\" > $ /test/ | \"http://test/\" > $ /test/ ) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" > $ /test/ > $ /test/ | \"http://test/\" > $ /test/ > $ /test/ | \"http://test/\" > $ /test/ > $ /test/ ) ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" )) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" > 1 )) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" > 1 > 1 )) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" > $ /test/ )) ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" > $ /test/ > $ /test/ )) ");
    tests.add(test);


    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" ) > 1 ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" > 1 ) > 1 ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" > 1 > 1 ) > 1 > 1 ) > 1 > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" > $ /test/ ) > $ /test/ ) > $ /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " (( \"http://test/\" > $ /test/ > $ /test/ ) > $ /test/ > $ /test/ ) > $ /test/ > $ /test/ ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ ASC, DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url ASC, url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ /test/, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url /test/, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ ASC, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ /test/, ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url ASC, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url /test/, url ASC ");
    tests.add(test);

    /*
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", false);
    test.put("pattern", "  \"http://test/\" > @ url: ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: ASC, DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url ASC, url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: /test/, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url /test/, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: ASC, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: /test/, ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url ASC, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url /test/, url ASC ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: ASC, DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url ASC, url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: /test/, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url /test/, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: ASC, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: /test/, ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url ASC, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url /test/, url ASC ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: ASC, DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url ASC, url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: /test/, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url /test/, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: ASC, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: /test/, ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url ASC, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url /test/, url ASC ");
    tests.add(test);
    
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ ASC  > @ ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ ASC > @ ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ ASC, DESC > @ ASC, DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url ASC > @ url ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url DESC > @ url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url DESC > @ url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ /test/ > @ /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ /test/, /test/ > @ /test/, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url /test/, url /test/ > @ url /test/, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ ASC, /test/ > @ ASC, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ /test/, ASC > @ /test/, ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url ASC, url /test/ > @ url ASC, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url /test/, url ASC > @ url /test/, url ASC ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url > @ url ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title > @ url, title ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", false);
    test.put("pattern", "  \"http://test/\" > @ url: > @ url: ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: ASC > @ url: ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: DESC > @ url: DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: ASC, DESC > @ url: ASC, DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url ASC > @ url: url ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url DESC > @ url: url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url ASC, url DESC > @ url: url ASC, url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: /test/ > @ url: /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: /test/, /test/ > @ url: /test/, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url /test/, url /test/ > @ url: url /test/, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: ASC, /test/ > @ url: ASC, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: /test/, ASC > @ url: /test/, ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url ASC, url /test/ > @ url: url ASC, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url: url /test/, url ASC > @ url: url /test/, url ASC ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: ASC > @ url, title: ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: DESC > @ url, title: DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: ASC, DESC > @ url, title: ASC, DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url ASC > @ url, title: url ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url DESC > @ url, title: url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url ASC, url DESC > @ url, title: url ASC, url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: /test/ > @ url, title: /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: /test/, /test/  > @ url, title: /test/, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url /test/, url /test/ > @ url, title: url /test/, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: ASC, /test/ > @ url, title: ASC, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: /test/, ASC> @ url, title: /test/, ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url ASC, url /test/ > @ url, title: url ASC, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title: url /test/, url ASC > @ url, title: url /test/, url ASC ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: ASC > @ url, title, linkword: ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: DESC > @ url, title, linkword: DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: ASC, DESC > @ url, title, linkword: ASC, DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url ASC > @ url, title, linkword: url ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url DESC > @ url, title, linkword: url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url ASC, url DESC > @ url, title, linkword: url ASC, url DESC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: /test/ > @ url, title, linkword: /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: /test/, /test/ > @ url, title, linkword: /test/, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url /test/, url /test/ > @ url, title, linkword: url /test/, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: ASC, /test/ > @ url, title, linkword: ASC, /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: /test/, ASC > @ url, title, linkword: /test/, ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url ASC, url /test/ > @ url, title, linkword: url ASC, url /test/ ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" > @ url, title, linkword: url /test/, url ASC > @ url, title, linkword: url /test/, url ASC ");
    tests.add(test);
    */
    
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" | \"http://test/\" > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" & \"http://test/\" > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" ^ \"http://test/\" > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" - \"http://test/\" > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" | \"http://test/\" > 1 > @ ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" | \"http://test/\" | \"http://test/\" > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" & \"http://test/\" & \"http://test/\" > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" ^ \"http://test/\" ^ \"http://test/\" > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" - \"http://test/\" - \"http://test/\" > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "  \"http://test/\" | \"http://test/\" | \"http://test/\" > 1 > @ ASC ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" | \"http://test/\" ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" & \"http://test/\" ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" ^ \"http://test/\" ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" - \"http://test/\" ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" | \"http://test/\" ) > 1 > @ ASC ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" | \"http://test/\" | \"http://test/\" ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" & \"http://test/\" & \"http://test/\" ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" ^ \"http://test/\" ^ \"http://test/\" ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" - \"http://test/\" - \"http://test/\" ) > 1 ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", " ( \"http://test/\" | \"http://test/\" | \"http://test/\" ) > 1 > @ ASC ");
    tests.add(test);

    /*
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > HTML ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > SIMPLE ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > TEXT ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > HTML ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > SIMPLE ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > TEXT ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > @ ASC > HTML ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > @ ASC > SIMPLE ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > @ ASC > TEXT ");
    tests.add(test);

    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > MERGE ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > MERGE ");
    tests.add(test);
    test = new HashMap();
    test.put("assert", true);
    test.put("pattern", "\"http://test/\" > 1 > @ ASC > MERGE ");
    tests.add(test);
    */

    List<Map> errors = new ArrayList<Map>();
    long total = tests.size();
    long success = 0;
    for (Map t : tests) {
      System.out.println( "--------" );
      String pattern = (String)t.get("pattern");
      System.out.println( pattern );
      QueryParser parser = new QueryParser( new StringReader( pattern ) );
      if ((Boolean)t.get("assert")  == true) {
        try {
          SimpleNode query = parser.parse();
          System.out.println( "    ----" );
          query.dump("");
          System.out.println( "    ----" );
          System.out.println( " -> OK" );
          success += 1;
        } catch( ParseException pe ) {
          errors.add(t);
          System.out.println( " -> NG" );
          System.out.println( "parse(): an invalid expression!" );
          System.out.println( ThrowableToString(pe) );
        } catch( TokenMgrError e )  {
          errors.add(t);
          System.out.println( " -> NG" );
          System.out.println( "a Token Manager error!" );
          System.out.println( ThrowableToString(e) );
        }
      } else {
        try {
          SimpleNode query = parser.parse();
          System.out.println( "    ----" );
          query.dump("");
          System.out.println( "    ----" );
          System.out.println( " -> NG" );
          errors.add(t);
        } catch(Throwable e) {
          System.out.println( " -> OK" );
          success += 1;
        }
      }
    }
    System.out.println( "--------" );
    System.out.println( "# total: " + success + "/" + total );
    for (Map e : errors) {
      System.out.println( " - " + e.get("pattern") + " : " + e.get("assert") );
    }
    System.out.println( "--------" );
    
    assertEquals(total, success);
  }
  public static String ThrowableToString(Throwable t) {
      Writer writer = new StringWriter();
      PrintWriter pw = null;
      try {
        pw = new PrintWriter(writer);
        t.printStackTrace(pw);
        pw.flush();
      } finally {
        if (pw != null) {
            pw.close();
        }
      }
      return writer.toString();
  }
}