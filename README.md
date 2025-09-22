 # Redz Mobile & Performance Testing Project

## Project Overview

This project is part of the **QA Bootcamp Final Project**, where we applied the **full software testing process** on both **Mobile Automation Testing** and **Performance Testing**.  
Our goal was to design, implement, and execute automated tests for a mobile application using **Appium, Java, and TestNG**, in addition to building a **Performance Testing suite** using **JMeter** for a web-based Contact List application.  
The project followed the **Scrum methodology** to simulate a real QA team working environment.

- **System Under Test (SUT 1):** Redz Mobile App (available on Google Play).  
- **System Under Test (SUT 2):** Contact List Web App (for Performance Testing).  

---

## Project Timeline (5 Days – Scrum Sprints)

- **Day 1 – Analysis & Planning**
  - Select applications under test (Redz Mobile App & Contact List Web App).
  - Identify mobile and performance testing features to automate.
  - Write the **Test Plan** & **SRS**.

- **Day 2 – Test Design**
  - Prepare test scenarios and test cases for mobile & performance.
  - Define performance KPIs (response time, throughput, error rate).
  - Plan automation workflows for selected features.

- **Day 3 – Setup & Implementation**
  - Set up **Appium project** with Java + Maven for mobile automation.
  - Configure desired capabilities & environment (Android Emulator + UiAutomator2).
  - Set up **JMeter test plan** for performance testing (users, tokens, listeners, assertions).
  - Start automation coding for Redz features.

- **Day 4 – Execution**
  - Continue automation coding (mobile).
  - Execute test scripts on **Android Emulator**.
  - Run performance tests with **JMeter** (100–1000 concurrent users).
  - Collect results & debug failures.

- **Day 5 – Reporting & Presentation**
  - Generate **TestNG Reports** (mobile).
  - Generate **JMeter Reports** (performance).
  - Finalize documentation (SRS, Test Plan, Test Cases, RTM).
  - Present all project deliverables in a final session.

---

## Deliverables

By the end of the project, the following artifacts were produced:

- 📄 **SRS Document** (describing app requirements and workflows).  
- 📑 **Test Plan & Test Cases** (mobile + performance).  
- 💻 **Automation Code** (Appium + Java + TestNG).  
- ⚡ **Performance Test Plan** (JMeter).  
- 📊 **Reports** (TestNG & JMeter results).  
- 🎤 **Final Presentation** (application details, workflows, results, QA documentation).  

---

## Tools & Frameworks

- **Mobile Automation:**
  - Appium
  - Java
  - TestNG
  - Apache Maven
  - Android Studio (Emulator & UiAutomator2)

- **Performance Testing:**
  - Apache JMeter (v5.6.3)

- **Collaboration & Documentation:**
  - Trello (task management)
  - Microsoft Excel / Word (test cases & reports)
  - GitHub (version control)

---

## Applications Under Test

- **System 1: Redz Mobile App**  
  Selected Features for Automation:
  - User Login & Logout
  - Like & Dislike Video
  - Comment on Video (Add, Edit, Delete)
  - Upload & Delete Video
  - Search for Content/Users  

- **System 2: Contact List Web App**  
  Performance Testing Coverage:
  - User Registration & Login
  - Fetching Contact List
  - Adding/Editing/Deleting Contacts
  - Measuring Response Time, Throughput & Error Rate

---

## Example Test Coverage

- **Mobile Automation:**
  - Valid & invalid login attempts
  - Comment workflow (add, edit, delete)
  - Liking/Disliking content
  - Uploading & deleting video
  - Searching for users or content  

- **Performance Testing:**
  - Load testing with 100–1000 concurrent users
  - Assertions on response codes & payloads
  - Measuring latency, throughput, error %
  - Performance KPIs:
    - Response Time (≤ 2s for 95% of requests)
    - Error Rate (≤ 1%)
    - Throughput (requests/sec)

---

## Team Collaboration

The project followed a **Scrum framework**:
- Sprint Planning (analyzing requirements & assigning tasks).  
- Daily Scrum (sync meetings).  
- Sprint Review (final presentation & demo).  
