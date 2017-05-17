Online jewellery Project:

Implemented Functions: - user registration with greeting e-mail, login/logout - viewing products with images - adding products to the shopping cart - browsing the shopping cart with a possibility to order/delete the product - administrator section, where you can add/modify/delete entities - editing the commodity image (administrator only) - both server and client side validation for most operations

Elapsed Time: - database design, entity mapping, database access layer 4 hours - administrator section  8 hours - authentication, registration, user profile  6 hours - shopping cart, orders  2 hours - validation for all operations  5 hours - html/css writing 5 hours - deploying the project to a hosting 16 hours Total Elapsed Time: 46 hours

Project Configuration: 1) To change database connectivity credentials, open [WEB-INF/classes/META-INF/persistence.xml] and modify these lines:

2) To change JSP files location, open [WEB-INF/servlet-context.xml] and modify these lines:
  <bean
   class="org.springframework.web.servlet.view.InternalResourceViewResolver">
   <property name="prefix">
    <value>/WEB-INF/[PATH TO JSP FILES]</value>
   </property>
   <property name="suffix">
    <value>.jsp</value>
   </property>
  </bean>
  
3) To change the location of XML files, do the following:
  persistence.xml
  Open [WEB-INF/application-context.xml] and modify this line:
  <property name="persistenceXmlLocation" value="classpath:/META-INF/persistence.xml" />
  
  For other files:
  Open [WEB-INF/web.xml] and modify these lines:
  servlet-context.xml
  <init-param>
   <param-name>contextConfigLocation</param-name>
   <param-value>
    /WEB-INF/servlet-context.xml
   </param-value>
  </init-param>
  
  application-context.xml, security-context.xml
  <context-param>
   <param-name>contextConfigLocation</param-name>
   <param-value>
    /WEB-INF/application-context.xml
    /WEB-INF/security-context.xml
   </param-value>
  </context-param>
Design Patterns: DAO - creating a layer of interfaces to access database and isolate it from business logic
Factory - is used by jpa to provide entity managers
Singleton - restricting the instantiation of a class to one object (Spring Beans)
MVC - dividing a given application into three interconnected parts
(M - model, V - view, C - controller) model - represented by the object which carries data
view - represented by the visual part of application 
controller - controls the data flow between model and view
Used Frameworks: Java Persistence API - to work with the database
Spring IoC - for dependency injection and beans management
Spring MVC - for MVC pattern implementation Spring Security - for user authentication
Other:
- the eclipse project includes Maven build configuration to automatically create WAR and run it on embedded 
- Tomcat Server - resources such as commodity images are located at https://adm.tools/hosting/ 
- database dump is included
