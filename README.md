# U-Blog
The details of the folders inside the project are as follows

    com.upgrad.ublog.dao: This folder contains classes which will be responsible for interacting with the database. This folder is the database layer for your web app.

    com.upgrad.ublog.db: This folder contains just one class which will be used to establish a connection with the database. This folder also contains the 'setup.sql' file which contains SQL queries to set up your database.

    com.upgrad.ublog.dto: This folder contains two classes which will be used to transfer data between different layers of your application.

    com.upgrad.ublog.exceptions: This folder contains two custom exception classes, which will be used for exception handling in your web app.

    com.upgrad.ublog.services: This folder contains classes which will be responsible for fetching data from the database layer, process the data and send to the presentation layer. It will also get requests from the presentation layer and save data into the database. This folder is the service layer of your web app.

    com.upgrad.ublog.servlets: This folder contains classes which will be responsible for getting request from the client, process the request with help of service layer and send the response back to the client. This folder is part of the presentation layer of your web app.

    com.upgrad.ublog.utils: This folder contains three classes, which will be used to perform utility tasks for your project.

    webapp/ublog: This folder contains the JSP files which contain the structure of the web pages that will be rendered in the browser. This folder, and the three other JSP files inside the webapp folder, are part of the presentation layer of your web app.

    webapp/WEB-INF: This folder contains the web.xml file which is used to connect the front-end layer with the back-end layer.
