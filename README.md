# noir-servlet

An HttpServlet subclass that delegates all requests to Noir. A views namespace must be supplied.

## Installation

Leiningen:

    :dependencies [[noir-servlet "0.1.0"]]

Maven:

    <dependency>
      <groupId>noir-servlet</groupId>
      <artifactId>noir-servlet</artifactId>
      <version>0.1.0</version>
    </dependency>
    <repositories>
      <repository>
        <id>clojars</id>
        <url>http://clojars.org</url>
      </repository>
    </repositories>

## Usage

Example web.xml:

    <?xml version="1.0" encoding="ISO-8859-1"?>
    <web-app xmlns="http://java.sun.com/xml/ns/javaee"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
          version="3.0">
      <display-name>my-webapp</display-name>

      <servlet>
        <servlet-name>noir</servlet-name>
        <servlet-class>noir-servlet.servlet</servlet-class>
        <init-param>
          <param-name>views-ns</param-name>
          <param-value>my-webapp.views</param-value>
        </init-param>
      </servlet>

      <servlet-mapping>
        <servlet-name>noir</servlet-name>
        <url-pattern>/*</url-pattern>
      </servlet-mapping>
    </web-app>

### Development Mode

Define a system property "noir.mode" with value "dev" to run in development mode.

## TODO

More configurability.

Tests.

## License

Copyright © 2012 Jacob Williams

Distributed under the Eclipse Public License, the same as Clojure.
