
# SYSTEM TEST CONTEXT: [SauceDemo/Login]

## 1. Role & Objective
Act as a Senior QA Automation Engineer. Generate highly structured test cases based on the attached software requirement document.

## 2. Product Ecosystem & Architecture
- Application Type: [Web Application]
- User Personas: 
  - [Persona 1, e.g., Admin - Full read/write access]
  - [Persona 2, e.g., Customer - Verified buyer, restricted views]

## 3. Test Planning Format
Objective: Aim
Scope: Features in scope and not in scope
Testing methodology: Based on application
Approach: Test Scenarios/Test cases/user stories/ flow charts
Assumption: Like: Proper SRS documentation, resource availability, proper KT, Env status
Risk: Assumption breaks
Mitigation Plan: To avoid the percentage of Risk
Roles and Responsibilities:
Scheduling: Release/ Sprint 
Defect Tracking: Jira
Test Environment: Test data details
Entry and Exit criteria:
Test Automation Tool: 
Deliverables: Release notes
Templates

## 4 User Stories
For every requirement generate all possible user stories

##5 Flow charts of Workflow
High level design Flow charts of workflow (Change Request/Work Request/Incident report)
Low level design Flow charts of workflow (Change Request/Work Request/Incident report)

## 5 Test Case Generation Blueprint
For every user story/requirement, generate all positive and negative test cases using this exact schema:
-User Story 
-Test Case ID: [ProjectCode-Module-001]
- Title: [Action + Expected Outcome]
- Prerequisites: [State or setup required before execution]
- Acceptance criteria
- Test Steps: [Numbered, explicit UI or API actions]
- Expected Result: [Clear, verifiable success criteria]
- Test Data: [Specific valid/invalid values to use]



## 6 QA KPI(Key Performance Indicator)

 - Defect Detection Efficiency (DDE)= (QA bugs)/(QA bugs+Prod bugs)*100 
  Exclude Non IRs, Duplicate IRs, Cannot reproduce (Same release/Sprint)
  
  -Test script Executed Per Day= (No of scripts executed)/(No of days of testing window)
  
  -Defect Acceptance Rate=(No of bugs accepted)/(No of bugs raised)*100
  
  - Blocked script rate=(No of scripts blocked)/(Total scripts)*100
  
  - Defect Density rate
     Traditional= (No of bugs accepted)/(Total functional points)*100
     Agile= (No of bugs accepted)/(Total user stories)*100
  
  - Defect Leakage rate= (Prod bugs)/(UAT+Testing+Prod bugs)*100
   * Same release/Sprint * DDE % + Defect Leakage % will always equal exactly 100%
   
  Testing Status report: Includes Total scripts, Total executed, Total pass, Total fail
  
   
##7 Release capacity and Timeline (need to work around)

  
   - QA Capacity Ratio (QCR) (Call to accomodate feature)
   QCR=Required Effort(Person-days)/Available Runaway(Person-days)*100
   example: Require effort=(40 storypoints)/(5 storypoints/day)=8 person-days needed
   Available Runaway=2 testers*3days=6 persons-days available
   QA capacity ratio=8/6*100=133%
   QCR>100 %- overloaded
   QCR 86%-100% - correct zero buffer room (possibility of delay because of block/env issue)
   QCR<80 - Release can go smoothly
   
   
   
   
  
  