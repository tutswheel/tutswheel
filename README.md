tutswheel
=========

##Project Setup Description

1. Create project Id on App console.

2. Use the created App Id to Create Web application

3. On Eclipse, Select the File menu > New > Web Application Project . If you do not see this menu option, select the Window menu > Reset Perspective..., click OK, then try the File menu again. Alternatively, click the Google button Google Plugin icon in the Eclipse toolbar and select New Web Application Project.

4. The "Create a Web Application Project" wizard opens. For "Project name," enter a name for your project, such as tutswheel for the project described in the Getting Started Guide. For "Package," enter an appropriate package name, such as tutswheel.

5. If you're not using Google Web Toolkit, uncheck "Use Google Web Toolkit." Verify that "Use Google App Engine" is checked.

6. If you installed the App Engine SDK using Software Update, the plugin is already configured to use the SDKs that were installed. If you would like to use a separate installation of the App Engine SDK, click Configure SDKs..., and follow the prompts to add a configuration with your SDK's appengine-java-sdk/ directory.

7. Click Finish to create the project.

##Maven Configurations

1. Copy pom.xml file, Run clean & install, eclipse commands.
2. Deploy on GAE localhost.(Within Eclipse)

##Run App on terminal

1. Navigate to directory and run mvn clean install
2. Fire up server with command: mvn appengine:devserver

##To push app in GAE cloud
1. Run command mvn appengine:update. 


