package com.test.qa.pageobjects.utils;

import net.rcarz.jiraclient.*;

public class JiraServiceProvider {


        public JiraClient jira;
        public String project;

        public JiraServiceProvider(String jiraUrl, String username, String password, String project) {
            BasicCredentials creds = new BasicCredentials(username, password);
            jira = new JiraClient(jiraUrl, creds);
            this.project = project;
        }

        public void createJiraTicket(String issueType, String summary, String description, String reporterName) {

            try {
                Issue.FluentCreate fleuntCreate = jira.createIssue(project, issueType);
                fleuntCreate.field(Field.SUMMARY, summary);
                fleuntCreate.field(Field.DESCRIPTION, description);
                Issue newIssue = fleuntCreate.execute();
                System.out.println("new issue created in jira with ID: " + newIssue);

            } catch (JiraException e) {
                e.printStackTrace();
            }

        }

    }

